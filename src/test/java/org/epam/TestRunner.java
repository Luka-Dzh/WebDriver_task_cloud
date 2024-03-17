package org.epam;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"org.epam.stepdefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
