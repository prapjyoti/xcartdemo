package hotdeals;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HotDealsTest extends BaseTest {
    String baseUrl = "https://mobile.x-cart.com";

    @Before

    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        // Thread.sleep(500);
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //1.2 Mouse hover on the “Sale”  link and click
        Thread.sleep(500);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        //1.3 Verify the text “Sale”
        Thread.sleep(500);
        ////h1[@id='page-title']
        String expectedMessageText = "Sale";
        String actualMessageText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User not Navigate to Sale Page + ", expectedMessageText, actualMessageText);

        // 1.4 Mouse hover on “Sort By” and select “Name A-Z”
        Thread.sleep(500);
        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        Thread.sleep(500);
       // clickOnElement(By.partialLinkText("Name A"));
        sortData(By.partialLinkText("Name A"));
        //1.5 Verify that the product arrange alphabetically
        Thread.sleep(500);



    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //2.2 Mouse hover on the “Sale”  link and click
        Thread.sleep(500);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(500);
        //2.3 Verify the text “Sale”
        String expectedMessage1 = "Sale";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not Navigate to Sale Page + ", expectedMessage1, actualMessage1);
        Thread.sleep(500);
        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        // 2.4 Mouse hover on “Sort By” and select “Price Low-High”
        Thread.sleep(500);
        sortData(By.partialLinkText("Price Low - Hi"));
        // 2.5 Verify that the product’s price arrange Low to High

    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        //3.1 Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //3.2 Mouse hover on the “Sale”link and click
        Thread.sleep(500);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(500);
        //3.3 Verify the text “Sale”
        String expectedMessage1 = "Sale";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not Navigate to Sale Page + ", expectedMessage1, actualMessage1);
        //3.4 Mouse hover on “Sort By”and select “Rates”
        Thread.sleep(500);
        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        Thread.sleep(500);
        sortData(By.partialLinkText("Rates"));
        //3.5 Verify that the product’s arrange Rates

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        //4.1 Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        Thread.sleep(500);
        //4.2 Mouse hover on the “Bestsellers”link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        //4.3 Verify the text “Bestsellers”
        String expectedMessage2 = "Bestsellers";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not Navigate to BestSellers Page + ", expectedMessage2, actualMessage2);
        Thread.sleep(1000);
        //4.4 Mouse hover on “Sort By”and select “Name Z -A”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(500);
        sortData(By.partialLinkText("Name Z -"));
        //4.5 Verify that the product arrange by Z to A
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {


        //5.1 Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        Thread.sleep(500);
        //5.2 Mouse hover on the “Bestsellers”link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        //5.3 Verify the text “Bestsellers”
        String expectedMessage3 = "Bestsellers";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not Navigate to BestSellers Page + ", expectedMessage3, actualMessage3);

        //5.4 Mouse hover on “Sort By”and select “Price High -Low”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(500);
        sortData(By.partialLinkText("Price High - L"));

        //5.5 Verify that the product’s price arrange High to Low


    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        //6.1 Mouse hover on the “Hot deals”link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //6.2 Mouse hover on the “Bestsellers”link and click
        Thread.sleep(500);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        // 6.3 Verify the text “Bestsellers”
        Thread.sleep(500);
        String expectedMessage4 = "Bestsellers";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User is not Navigate to BestSellers Page + ", expectedMessage4, actualMessage4);
        //6.4 Mouse hover on “Sort By”and select “Rates”
        Thread.sleep(500);
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(500);
        sortData(By.partialLinkText("Rates"));

        //6.5 Verify that the product’s arrange Rates

    }
}

