package homepage;
/*
Create class TopMenuTest
	1 - verifyUserShouldNavigateToShippingPageSuccessfully()
		1.1 Click on the “Shipping” link
		1.2 Verify the text “Shipping”
	2 - verifyUserShouldNavigateToNewPageSuccessfully()
		2.1 Click on the “New!” link
		2.2 Verify the text “New arrivals”
	3 - verifyUserShouldNavigateToComingsoonPageSuccessfully()
		3.1 Click on the “Coming soon” link
		3.2 Verify the text “Coming soon”
	4 - verifyUserShouldNavigateToContactUsPageSuccessfully()
		4.1 Click on the “Contact us” link
		4.2 Verify the text “Contact us”

 */

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://mobile.x-cart.com";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        // 1.1 Click on the “Shipping” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[3]"));


        // 1.2 Verify the text “Shipping”
        Thread.sleep(500);
        String expectedMessage = "Shipping";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User not Navigate to Page + ", expectedMessage, actualMessage);


    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        Thread.sleep(500);
        //2.1 Click on the “New!” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[4]"));
        //2.2 Verify the text “New arrivals”
        String expectedMessage = "New arrivals";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User not Navigate to Page + ", expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException {
        Thread.sleep(500);

        // 3.1 Click on the “Coming soon”link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[5]"));
        Thread.sleep(500);
        //3.2 Verify the text “Coming soon” //Coming soon
        String expectedMessage = "Coming soon";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User not Navigate to Page Coming soon + ", expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException {
        Thread.sleep(500);
        // 4.1 Click on the “Contact us”link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[6]"));
        Thread.sleep(500);
        // 4.2 Verify the text “Contact us”//Contact us
        String expectedMessage = "Contact us";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User not Navigate to Page Coming soon + ", expectedMessage, actualMessage);


    }
}
