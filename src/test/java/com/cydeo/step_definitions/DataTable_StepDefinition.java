package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTable_StepDefinition {
    DropdownsPage dropdownsPage = new DropdownsPage();

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(1));
    }

    @Given("User is on th dropdowns page of practice tool")
    public void user_is_on_th_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Then("should see below info in month dropdown")
    public void should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
        System.out.println("expectedMonths = " + expectedMonths);
//        Select select = new Select(dropdownsPage.monthDropdown);
//        List<WebElement> actualOptionsAsWebElement = select.getOptions();
//        List<String> actualOptionsAsString = new ArrayList<>();
//        for (WebElement eachOption : actualOptionsAsWebElement) {
//            actualOptionsAsString.add(eachOption.getText());

        List<String>actualMonths = BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);
        Assert.assertEquals(expectedMonths,actualMonths);
        }
       // Assert.assertTrue(actualOptionsAsString.equals(expectedMonths));

    }

