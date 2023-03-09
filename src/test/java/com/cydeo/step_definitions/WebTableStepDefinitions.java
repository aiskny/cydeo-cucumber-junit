package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTableStepDefinitions {
    WebTableLoginPage webTablePage = new WebTableLoginPage();

    @Given("user is on the login page of web app")
    public void user_is_on_the_login_page_of_web_app() {
        String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTablePage.userNameBtn.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTablePage.passwordBtn.sendKeys(string);

    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTablePage.loginBtn.click();
    }

//    @Then("user should see url contains orders")
//    public void user_should_see_url_contains_orders() {
//        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains());
//    }

    @Then("user should see url contains {string}")
    public void user_should_see_url_contains(String expectedURL) {
//        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedURL));
        BrowserUtils.verifyURLContains("orders");
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String pw) {
//        webTablePage.userNameBtn.sendKeys(username);
//        webTablePage.passwordBtn.sendKeys(pw);
//        webTablePage.loginBtn.click();

        webTablePage.login(username,pw);
    }

    @Then("user should see url contains orders")
    public void userShouldSeeUrlContainsOrders() {

    }



    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {
        System.out.println("credentials.get(\"username\") = " + credentials.get("username"));
        System.out.println("credentials.get(\"password\") = " + credentials.get("password"));
//        webTablePage.userNameBtn.sendKeys(credentials.get("username"));
//        webTablePage.passwordBtn.sendKeys("password");
//        webTablePage.loginBtn.click();

        //we can call login method and pass values from map
        webTablePage.login(credentials.get("username"), credentials.get("password") );

    }

}
