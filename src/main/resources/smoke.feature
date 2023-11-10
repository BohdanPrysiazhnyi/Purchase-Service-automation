Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario: Login to the BO and Purchase Service with Auth service
    Given User opens start page
    When User click on HFN login button
    And User click on Login text field and enter '<login>'
    And User click on Password text field and enter '<password>'
    Then User verify that login to the system is successful

