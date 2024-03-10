package org.epam.pages;

import org.epam.BasePage;
import org.epam.Utility;
import org.epam.decorator.PageDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends BasePage {
    private final Utility utility = new Utility(driver);

    private static final String NUMBER_OF_INSTANCES_XPATH = "//*[@id=\"input_100\"]";
    private static final String SELECTOR_FOR_SERIES_XPATH = "//md-select [@ng-model=\"listingCtrl.computeServer.series\"]";
    private static final String MACHINE_TYPE_XPATH = "//md-select [@ng-model=\"listingCtrl.computeServer.instance\"]";
    private static final String ADD_GPU_XPATH = "//md-checkbox[@ng-model=\"listingCtrl.computeServer.addGPUs\"]";
    private static final String LOCAL_SSD_XPATH = "//md-select [@placeholder=\"Local SSD\"]";
    private static final String GPU_TYPE_XPATH = "//md-select[@placeholder=\"GPU type\"]";
    private static final String NUMBER_OF_GPU_XPATH = "//md-select[@placeholder=\"Number of GPUs\"]";
    private static final String DATACENTER_LOCATION_XPATH = "//md-select[@placeholder=\"Datacenter location\"]";
    private static final String COMMITTED_USAGE_XPATH = "//md-select[@placeholder=\"Committed usage\"]";
    private static final String ADD_TO_ESTIMATE_XPATH = "//button[contains(text(),\"Add to Estimate\")]";
    private static final String EMAIL_ESTIMATE_XPATH = "//button[@id=\"Email Estimate\"]";
    private static final String ESTIMATED_PRICE_XPATH = "//h2[@class=\"md-flex ng-binding ng-scope\"]";
    private static final String ELEMENT_SERIES_XPATH = "//md-option[@value=\"n1\"]";
    private static final String ELEMENT_MACHINE_XPATH = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]";
    private static final String ELEMENT_SSD_XPATH = "//md-option[@id=\"select_option_495\"]";
    private static final String ELEMENT_GPU_XPATH = "//md-option[@value=\"NVIDIA_TESLA_V100\"]";
    private static final String ELEMENT_NUMBER_GPU_XPATH = "//md-option[@id=\"select_option_520\"]";
    private static final String ELEMENT_DATACENTER_XPATH = "//md-option[@id=\"select_option_268\"]";
    private static final String ELEMENT_USAGE_XPATH = "//md-option[@id=\"select_option_138\"]";


    private final PageDecorator pageDecorator;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        this.pageDecorator = new PageDecorator(driver, this);
    }

    public EmailPage setValues() {// sets all values for the server
        driver.switchTo().frame(0);

        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));

        driver.switchTo().frame("myFrame");


        pageDecorator.waitForElements(driver.findElement(By.xpath(NUMBER_OF_INSTANCES_XPATH))).sendKeys("4");

        driver.findElement(By.xpath(SELECTOR_FOR_SERIES_XPATH)).click();
        pageDecorator.waitForElements(driver.findElement(By.xpath(ELEMENT_SERIES_XPATH))).click();

        driver.findElement(By.xpath(MACHINE_TYPE_XPATH)).click();
        pageDecorator.waitForElements(driver.findElement(By.xpath(ELEMENT_MACHINE_XPATH))).click();

        driver.findElement(By.xpath(ADD_GPU_XPATH)).click();

        driver.findElement(By.xpath(LOCAL_SSD_XPATH)).click();
        pageDecorator.waitForElements(driver.findElement(By.xpath(ELEMENT_SSD_XPATH))).click();

        driver.findElement(By.xpath(GPU_TYPE_XPATH)).click();
        pageDecorator.waitForElements(driver.findElement(By.xpath(ELEMENT_GPU_XPATH))).click();

        driver.findElement(By.xpath(NUMBER_OF_GPU_XPATH)).click();
        pageDecorator.waitForElements(driver.findElement(By.xpath(ELEMENT_NUMBER_GPU_XPATH))).click();

        driver.findElement(By.xpath(DATACENTER_LOCATION_XPATH)).click();
        pageDecorator.waitForElements(driver.findElement(By.xpath(ELEMENT_DATACENTER_XPATH))).click();

        driver.findElement(By.xpath(COMMITTED_USAGE_XPATH)).click();
        pageDecorator.waitForElements(driver.findElement(By.xpath(ELEMENT_USAGE_XPATH))).click();

        driver.findElement(By.xpath(ADD_TO_ESTIMATE_XPATH)).click();
        driver.findElement(By.xpath(EMAIL_ESTIMATE_XPATH)).click();

        return new EmailPage(driver);
    }

    public String estimated() {
        utility.changeTab();

        driver.switchTo().frame(0);
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        driver.switchTo().frame("myFrame");

        return driver.findElement(By.xpath(ESTIMATED_PRICE_XPATH)).getText();
    }
}
