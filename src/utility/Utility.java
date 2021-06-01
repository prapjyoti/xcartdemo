package utility;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utility {

    public WebDriver driver;
   public WebDriverWait wait;


    public void clickOnElement(By by) {
        driver.findElement(by).click();

    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(By by) {
        driver.findElement(by).sendKeys();
    }

    public void selectByValueFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void selectByVisibleTextFromDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);

    }

    public void selectByIndexFromDropDown(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);
    }

    public WebElement mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        actions.moveToElement(hover).perform();
        return hover;
    }
    public void WebelementAction(By by){
        WebElement element= driver.findElement(by);
        Actions actions= new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    public void Clickelement(By by){
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(by);
        actions.contextClick().build().perform();

    }

    public void clear(By by) {
        driver.findElement(by).clear();

    }

    public String getAttributefromelement(By by, String value) {

        return driver.findElement(by).getAttribute("value");
    }

    public void closeBrowser() {

        driver.quit();
    }

    public String getUrl() {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl;
    }

    public void sortData(By by){
        List<WebElement>productname= driver.findElements(by);
        String[]beforesort_productname= new String[productname.size()];
        for(int i= 0;i < productname.size();i++){
            beforesort_productname[i] = productname.get(i).getText().trim();
        }
        Arrays.sort(beforesort_productname);
        System.out.println("after the sort");
        WebElement sort = driver.findElement(by);
        sort.click();
        productname = driver.findElements(by);
        String[]aftersort_productname = new String[productname.size()];

        for(int i = 0; i< productname.size(); i++){
            aftersort_productname[i] = productname.get(i).getText().trim();
            System.out.println("after");
            Assert.assertArrayEquals("productname is not sorted",beforesort_productname,aftersort_productname);

        }

    }

    public void selectByOptions(By by) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);


        List<WebElement> product = select.getOptions();
        for (WebElement element : product){
            element.getText();
        }


            }

    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);


}

