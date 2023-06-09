package org.example.demoqapageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    //Defining the constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Defining the web elements of the page
    private @FindBy(id = "userName")
    WebElement userName;

    private @FindBy(id = "password")
    WebElement passWord;

    private @FindBy(id = "login")
    WebElement loginBtn;

    //Implementing the methods
    public void setUserName(String userNameInput) {
        userName.sendKeys(userNameInput);
    }

    public void setPassWord(String passWordInput) {
        passWord.sendKeys(passWordInput);
    }

    public void clickOnLogin(String passWordInput) {
        loginBtn.click();
    }
}
