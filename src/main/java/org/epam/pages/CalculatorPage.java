package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"input_100\"]")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//md-select [@ng-model=\"listingCtrl.computeServer.series\"]")
    private WebElement selectorForSeries;
    @FindBy(xpath = "//md-select [@ng-model=\"listingCtrl.computeServer.instance\"]")
    private WebElement machineType;
    @FindBy(xpath ="//md-checkbox[@ng-model=\"listingCtrl.computeServer.addGPUs\"]")
    private WebElement addGpu;
    @FindBy(xpath = "//md-select [@placeholder=\"Local SSD\"]")
    private WebElement localSsd;
    @FindBy(xpath = "//md-select[@placeholder=\"GPU type\"]")
    private WebElement gpuType;
    @FindBy(xpath = "//md-select[@placeholder=\"Number of GPUs\"]")
    private WebElement numberOfGpu;
    @FindBy(xpath = "//md-select[@placeholder=\"Datacenter location\"]")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//md-select[@placeholder=\"Committed usage\"]")
    private WebElement comittedUsage;
    @FindBy(xpath = "//button[contains(text(),\"Add to Estimate\")]")
    private WebElement addToEstimate;
    @FindBy(xpath = "//button[@id=\"Email Estimate\"]")
    private WebElement emailEstimate;
    @FindBy(xpath = "//h2[@class=\"md-flex ng-binding ng-scope\"]")
    private WebElement estimatedPrice;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
    public EmailPage setValues(){
        driver.switchTo().frame(0);
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        driver.switchTo().frame("myFrame");



        waitForElements(numberOfInstances).sendKeys("4");

        selectorForSeries.click();
        WebElement elementSeries = driver.findElement(By.xpath("//md-option[@value=\"n1\"]"));
        waitForElements(elementSeries).click();

        machineType.click();
        WebElement elementMachine = driver.findElement(By.xpath("//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]"));
        waitForElements(elementMachine).click();

        addGpu.click();

        localSsd.click();
        WebElement elementSsd = driver.findElement(By.xpath("//md-option[@id=\"select_option_495\"]"));
        waitForElements(elementSsd).click();

        gpuType.click();
        WebElement elementGpu = driver.findElement(By.xpath("//md-option[@value=\"NVIDIA_TESLA_V100\"]"));
        waitForElements(elementGpu).click();

        numberOfGpu.click();
        WebElement elementNumberGpu = driver.findElement(By.xpath("//md-option[@id=\"select_option_520\"]"));
        waitForElements(elementNumberGpu).click();

        datacenterLocation.click();
        WebElement elementDatacenter = driver.findElement(By.xpath("//md-option[@id=\"select_option_268\"]"));
        waitForElements(elementDatacenter).click();

        comittedUsage.click();
        WebElement elementUsage = driver.findElement(By.xpath("//md-option[@id=\"select_option_138\"]"));
        waitForElements(elementUsage).click();

        addToEstimate.click();
        emailEstimate.click();

        return new EmailPage(driver);
    }
    public String estimated(){
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.switchTo().frame(0);
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        driver.switchTo().frame("myFrame");
        return estimatedPrice.getText();
    }
}
