package org.example.demoqapageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage {

    private WebDriver driver;

    //Defining the constructor
    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Defining the web elements of the page
    private @FindBy(id = "login")
    WebElement loginLink;
    //Implementing the required methods
    public void goTo() {
        driver.get("https://demoqa.com/books");

    }

    public void goToLogin(){
        loginLink.click();
    }
}
