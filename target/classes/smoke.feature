Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario Outline: Login to the BO and Purchase Service with Auth service
    Given User opens start page '<loginPageUrl>'
    When User click on HFN login button
    And User click on Login text field and enter '<login>'
    And User click on Password text field and enter '<password>'
    Then User verify that login to the system is successful

    Examples:
      | loginPageUrl                                      | login         | password   |
      | http://dashboard-5925.trademax-test.com/spa/login | test.testsson | pt72r=P+=_ |
