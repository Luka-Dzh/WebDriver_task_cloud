package org.epam;


import org.epam.pages.CalculatorPage;
import org.epam.pages.EmailPage;
import org.epam.pages.LoginPage;
import org.epam.pages.StartingPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AppTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage(driver);
    private final StartingPage startingPage = new StartingPage(driver);
    private final CalculatorPage calculatorPage = new CalculatorPage(driver);
    private final EmailPage emailPage = new EmailPage(driver);

    @BeforeMethod
    public void setUp() {
        setUpWebDriver();
    }

    @AfterMethod
    public void closeDriver() {
        quit();
    }

    @Test
    public void cloudTest() {
        loginPage.open()
                .search();

        startingPage.search();

        calculatorPage.setValues();

        emailPage.open()
                .creatingEmail();

        String estimated = emailPage.estimatedEmail();
        String expected = calculatorPage.estimated();
        Assert.assertEquals(extractDigits(estimated), extractDigits(expected));
    }
    private static String extractDigits(String input) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            result.append(matcher.group());
        }

        return result.toString();
    }
}
