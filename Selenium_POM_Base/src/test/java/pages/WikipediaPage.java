package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BaseSelenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WikipediaPage extends BaseSelenium {

    private WebDriver driver;
    WikipediaPage page;
    By searchInput = By.cssSelector("input[name=search]");
    By buttonSearch = By.id("searchButton");

    By tittle = By.cssSelector("span[class=mw-page-title-main]");


    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    public void openWikipedia() {
        page = new WikipediaPage(driver);
        driver = page.chromeDriverConnection();
        page.visit("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        driver.manage().window().maximize();
    }

    public void searchWord(String word) {
        page.type(searchInput, word);
        page.click(buttonSearch);
    }

    public void validateTittle(String word) {
        page.wait(tittle);
        assertEquals(page.getText(tittle), word);
        assertTrue(page.getURL().contains(word));
        page.close();
    }


}
