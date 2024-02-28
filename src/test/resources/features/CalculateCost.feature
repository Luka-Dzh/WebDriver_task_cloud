Feature: Calculate cost

  Scenario: Login to GitHub

    Given User is on "Login Page"

    When User enters search info as "Google Cloud Platform Pricing Calculator" and clicks om the first result

    Then User is successfully navigated to the  "Calculator Page"