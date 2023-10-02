package org.epam;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.pages.CalculatorPage;
import org.epam.pages.EmailPage;
import org.epam.pages.LoginPage;
import org.epam.pages.StartingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest extends BaseTest
{

    @BeforeMethod
    public void setUp() {
        setUpWebDriver();
    }
    @AfterMethod
    public void closeDriver() {
       quit();
    }

    @Test
    public void cloudTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open().search();

        StartingPage startingPage = new StartingPage(driver);
        startingPage.search();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.setValues();

        EmailPage emailPage = new EmailPage(driver);
        emailPage.open().creatingEmail();

        Assert.assertEquals(emailPage.estimatedEmail(),calculatorPage.estimated());
    }
}
