Feature: Calculate cost
  Background:
    Given the user navigates to the calculator page from the login page

  Scenario: Estimation

    Given User is on Calculator Page

    When User sets all values for the machine and clicks on the Estimate
    Then User sees the price

  Scenario Outline: Invalid search attempts
    When the user searches for "<naming>"
    Then an error message "<errorMessage>" should be displayed

    Examples:
      | naming                             | errorMessage      |
      | Google Cloud Pricing Calculator    |  Invalid naming   |
      | Google Cloud Platform Calculator   |  Incorrect naming |