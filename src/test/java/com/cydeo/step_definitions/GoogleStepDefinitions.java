package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();
    }


    @When("user types {word} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter2(String searchKeyWord) {

        googleSearchPage.searchBox.sendKeys(searchKeyWord+Keys.ENTER);

    }
    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String searchKeyWord) {

        googleSearchPage.searchBox.sendKeys(searchKeyWord+Keys.ENTER);
        
    }

    @Then("user sees {string} is in the google title")
    public void userSeesIsInTheGoogleTitle(String string) {

        String expectedTitle = string+" - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title is not as expected",expectedTitle,actualTitle);
    }
    
    @When("user types apple in the google search box and clicks enter")
    public void user_types_apple_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.cookie.click();
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);

    }

    @Then("user sees Steve Jobs is in the google title")
    public void user_sees_steve_jobs_is_in_the_google_title() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
     //   Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

}