package shopping;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTest extends BaseTest {
    String baseUrl = "https://mobile.x-cart.com";


    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyAvengersfabrikationsPlus() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //1.2 Mouse hover on the “Sale”  link and click
       Thread.sleep(500);
        //wait =new WebDriverWait(driver,50);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        //1.3verify the text sale
        Thread.sleep(500);
        String expectedMessage = "Sale";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not Navigate to Sale Page + ", expectedMessage, actualMessage);
        //	1.4 Mouse hover on “Sort By” and select “Name A-Z”
        Thread.sleep(1000);
        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        Thread.sleep(1000);
        clickOnElement(By.partialLinkText("Name A"));
        //	1.5 Click on “Add to cart” button of the product “Avengers:fabrikations Plus”
        Thread.sleep(1000);
        ////a[@class='product-thumbnail next-previous-assigned']
        ////div[@class='product productid-16 ']/div/a
        mouseHover(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));
        Thread.sleep(1000);
        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedText = "Product has been added to your cart";
        String actualText = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals("Product is not add in to cart", expectedText, actualText);
        //1.7 Click on X sign to close the message
        Thread.sleep(500);
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1]"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(500);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        //1.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(500);
        String expectedShoppingCart = "Your shopping cart - 1 item";
        String actualShoppingCart = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("1 Product is not add in to cart", expectedShoppingCart, actualShoppingCart);
        //1.10 Change the Qty = 2
        Thread.sleep(500);
        clear(By.xpath("//input[@id='amount16' and @ name='amount']"));
        sendTextToElement(By.xpath("//input[@id='amount16' and @ name='amount']"), "2");
        //1.11 Verify the text “Your shopping cart - 2 items”
        Thread.sleep(500);
        Thread.sleep(500);
        String expectedShoppingUpdate = "Your shopping cart - 2 items";
        String actualShoppingUpdate = getTextFromElement(By.xpath("//h1[normalize-space()='Your shopping cart - 2 items']"));
        Assert.assertEquals("1 Product is not add in to cart", expectedShoppingUpdate, actualShoppingUpdate);
        Thread.sleep(500);
        //1.12 Verify the Subtotal $29.98
        String expectedPriceSubtotal = "$29.98";
        String actualPriceSubtotal = getTextFromElement(By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']"));
        Assert.assertEquals("Product price is not match ", expectedPriceSubtotal, actualPriceSubtotal);
        Thread.sleep(500);
        //1.13 Verify the total $36.00
        String expectedSubtotal = "$36.00";
        String actualSubtotal = getTextFromElement(By.xpath("//li[@class='total']//span[@class='surcharge-cell']"));
        Assert.assertEquals("Total price is not match", expectedSubtotal, actualSubtotal);
        Thread.sleep(500);
        //1.14 Click on “Go to checkout” button
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));
        Thread.sleep(1000);
        //1.15 Verify the text “Log in to your account”
        String expectedLoginAccount = "Log in to your account";
        String actualLoginAccount = getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        Assert.assertEquals("Total price is not match", expectedLoginAccount, actualLoginAccount);
        Thread.sleep(1000);
        //1.16 Enter Email address
        sendTextToElement(By.xpath("//input[@id='email']"), "Linda.symond" + randomInt + "@outlook.com");
        //1.17 Click on “Continue” Button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//tbody/tr[2]/td[1]/button[1]"));
        //1.18 Verify the text “Secure Checkout”
        Thread.sleep(1000);
        String expectedcheckout = "Secure Checkout";
        String actualcheckout = getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals("Total price is not match", expectedcheckout, actualcheckout);
        Thread.sleep(1000);
        //1.19 Fill all the mandatory fields
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Linda");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Symond");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "41 Burnside Cresent");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='shippingaddress-city']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), "London");
        //Thread.sleep(1000);
        //clear(By.xpath("//select[@id='shippingaddress-country-code']"));
        selectByIndexFromDropDown(By.xpath("//select[@id='shippingaddress-country-code']"), 6);
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "Middlesex");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='shippingaddress-zipcode']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "HA0 1BJ");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-phone']"), "07922569105");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='email']"));
        sendTextToElement(By.xpath("//input[@id='email']"), "Linda.symond" + randomInt + "@outlook.com");
        //Thread.sleep(1000);
        //1.20 Check the check box “Create an account for later use”
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        //Thread.sleep(1500);
        //1.21 Enter the password
        sendTextToElement(By.xpath("//input[@id='password']"), "Abcd@1234");
        //1.22 Select the Delivery Method to “Local Shipping”
        //clear(By.xpath("//input[@id='method127' and @name='methodId']"));
        ////input[@id='method128' and @class='touched']
        Thread.sleep(1500);
        mouseHover(By.xpath("//span[contains(text(),'Local shipping')]"));
        clickOnElement(By.xpath("//input[@id='method128' and @name='methodId']"));
        //1.23 Select Payment Method “COD”
        Thread.sleep(1500);
        //mouseHover(By.xpath("//span[contains(text(),'COD')]"));
        clickOnElement(By.xpath("//input[@id='pmethod6' and @name='methodId']"));
        //1.24 Verify the total $37.03
        Thread.sleep(1500);
        ////div[@class='total clearfix']//span[@class='surcharge-cell']
        String expectedTotalprice3 = "$37.03";
        String actualTotalprice3 = getTextFromElement(By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"));
        Assert.assertEquals(" Above Total price is not match", expectedTotalprice3, actualTotalprice3);
        //1.25 Click on “Place Order” Button
        ////div[@class='button-row']/button
        ////button[@class='btn regular-button regular-main-button place-order submit disabled']
        //Thread.sleep(1000);
        ////span[contains(text(),'Place order: $37.03')]
        Thread.sleep(1500);

        wait = new WebDriverWait(driver,30);
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button-row']/button")));
        //clickOnElement(By.xpath("//div[@class='button-row']/button"));
        //Thread.sleep(1000);
       /* Actions actions= new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//div[@class='button-row']/button"));
        actions.contextClick(button).build().perform();
       // clickOnElement(By.xpath("//div[@class='button-row']/button"));*/

        Thread.sleep(1000);
        //1.26 verify Thank you message
        String expectedverification = "Thank you for your order";
        String actualverification = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you for your order']"));
        Assert.assertEquals("Subtotal is not verified", expectedverification, actualverification);


    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        Thread.sleep(500);
        // 1.2 Mouse hover on the “Bestseller”  link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        //1.3 Verify the text “Bestsellers”
        Thread.sleep(500);
        String expectedMessageVerify = "Bestsellers";
        String actualMessageVerify = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not Navigate to BestSellers Page + ", expectedMessageVerify, actualMessageVerify);
        Thread.sleep(1000);
        //	1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Name A -"));
        //1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        mouseHover(By.cssSelector(" .product.productid-13"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']/span[1]"));
        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedText = "Product has been added to your cart";
        String actualText = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals("Product is not add in to cart", expectedText, actualText);
        //1.7 Click on X sign to close the message
        Thread.sleep(500);
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1]"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(500);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        //1.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(500);
        String expectedShoppingCart1 = "Your shopping cart - 1 item";
        String actualShoppingCart1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("1 Product is not add in to cart", expectedShoppingCart1, actualShoppingCart1);
        //1.10 Click on “Empty your cart” link
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        String alert = driver.switchTo().alert().getText();
        String expectedalerttext = "Are you sure you want to clear your cart";
        Thread.sleep(500);
        //1.12 Click “Ok” on alert
        driver.switchTo().alert().accept();
        //1.13 Verify the message “Item(s) deleted from your cart”
        String expecteditemdeleted = "Item(s) deleted from your cart";
        String actualitemdeleted = getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        Assert.assertEquals("item is not deleted", expecteditemdeleted, actualitemdeleted);
        Thread.sleep(500);
        //1.14 Verify the text “Your cart is empty”
        String expectedcartempty = "Your cart is empty";
        String actualcartempty = getTextFromElement(By.xpath("//h1[normalize-space()='Your cart is empty']"));
        Assert.assertEquals("your cart is not empty", expectedcartempty, actualcartempty);


    }

}


