package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseSelenium {


    private WebDriver driver;


    public BaseSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    public String getText(By Element) {
        wait(Element);
        return findElement(Element).getText();
    }
    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = findElement(element);
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }
    public void type(By locator, String inputText) {
        wait(locator);
        driver.findElement(locator).sendKeys(inputText);
    }
    public void click(By locator) {
        wait(locator);
        driver.findElement(locator).click();
    }
    public void visit(String url) {
        driver.get(url);
    }
    public void close() {
        driver.quit();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

}
