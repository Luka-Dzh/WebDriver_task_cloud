package org.epam.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.epam.BaseTest;
import org.epam.pages.CalculatorPage;
import org.epam.pages.EmailPage;
import org.epam.pages.LoginPage;
import org.epam.pages.StartingPage;
import org.testng.Assert;

import java.util.NoSuchElementException;

import static org.epam.Utility.extractDigits;


public class CalculatorSteps extends BaseTest {
    private final LoginPage loginPage = new LoginPage(driver);
    private final StartingPage startingPage = new StartingPage(driver);
    private final CalculatorPage calculatorPage = new CalculatorPage(driver);
    private final EmailPage emailPage = new EmailPage(driver);

    @Given("the user navigates to the calculator page from the login page")
    public void navigateToCalculatorPage() {
        loginPage.open()
                .search("Google Cloud Platform Pricing Calculator");
    }

    @Given("User is on Calculator Page")
    public void userIsOnPage() {
        startingPage.search();
    }

    @When("User sets all values for the machine and clicks on the Estimate")
    public void setMachineValues() {
        calculatorPage.setValues();
    }

    @Then("User sees the price")
    public void seePrice() {
        emailPage.open()
                .creatingEmail();

        emailPage.estimatedEmail();
    }

    @When("the user searches for {string}")
    public void searchFor(String naming) {
        try {
            loginPage.open()
                    .search(naming);
            startingPage.search();
        }catch (NoSuchElementException ignored){
        }
    }

    @Then("an error message {string} should be displayed")
    public void verifyErrorMessage(String errorMessage) {

    }
}
