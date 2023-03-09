package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameBtn;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBtn;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;


    /**
     * no parameters
     * when we call this method it will directly login using
     * Username:Test
     * Password:Tester
     */
    public void login() {
        this.userNameBtn.sendKeys("Test");
        this.passwordBtn.sendKeys("Tester");
        this.loginBtn.click();
    }

    /**
     * This method will accept two arguments and login
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        userNameBtn.sendKeys(username);
        passwordBtn.sendKeys(password);
        loginBtn.click();
    }

    /**
     * this method will login in using credentials from
     * configuration.properties
     */
    public void loginWithConfig(){
        userNameBtn.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        passwordBtn.sendKeys(ConfigurationReader.getProperty("web.table.pw"));
        loginBtn.click();
    }
}
