package org.example.testCases.demoqa.tests;

import org.example.demoqapageobjects.BookStorePage;
import org.example.demoqapageobjects.LoginPage;
import org.example.models.*;
import org.example.network.ApiClients.AccountApiClient;
import org.example.network.ApiClients.BookStoreApiClient;
import org.example.testCases.demoqa.testcomponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class demoQaTests extends BaseTest {

    WebDriver driver;

    //Initializing the driver
    {
        try {
            driver = initializeDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Defining the required objects for the tests
    BookStorePage bookStorePage = new BookStorePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    // Testing the dynamic table page
    @Test
    public void loginToPortal() {
        bookStorePage.goTo();
        bookStorePage.goToLogin();
      //  loginPage.setUserName(accountApiClient.getUserBody().getUserName());
       // loginPage.setPassWord(accountApiClient.getUserBody().getPassword());

    }
}
