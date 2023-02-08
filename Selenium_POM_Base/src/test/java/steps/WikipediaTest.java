package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.WikipediaPage;

public class WikipediaTest {

    private WebDriver driver;
    WikipediaPage page;


    @Given("^User can navegate to principal wikipedia Page$")
    public void user_can_navegate_to_principal_wikipedia_Page(){

        page = new WikipediaPage(driver);
        page.openWikipedia();

    }

    @When("^Search word \"([^\"]*)\"$")
    public void search_arepa_word(String word) {

         page.searchWord(word);

    }

    @Then("^Then validate if tittle is \"([^\"]*)\"$")
    public void then_validate_if_tittle_is(String word){
        page.validateTittle(word);

    }


}
