@allure.label.epic:Smoke
Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario Outline: Login to the BO and Purchase Service with correct Auth service credentials
    Given User opens start page
    When User click on HFN login button
    And User click on Login text field and enter '<login>'
    And User click on Password text field and enter '<password>'
    And User click on login button
    Then User verify that login to the system is successful

    Examples:
      | login         | password   |
      | test.testsson | pt72r=P+=_ |

  Scenario Outline: Login to the BO and Purchase Service with correct standart login
    Given User opens start page
    When User click on additional login methods button
    And User click on standart login button
    And User click on standartLogin email field and enter '<login>'
    And User click on standartLogin Password text field and enter '<password>'
    And User click on signIn button
    Then User verify that login to the system is successful

    Examples:
      | login            | password |
      | test@example.com | test     |


  Scenario Outline: Login to the BO and Purchase Service with incorrect standart login
    Given User opens start page
    When User click on additional login methods button
    And User click on standart login button
    And User click on standartLogin email field and enter '<login>'
    And User click on standartLogin Password text field and enter '<password>'
    And User click on signIn button
    Then User verify that login to the system is not successful

    Examples:
      | login            | password |
      | test@example.com | test1    |


  Scenario Outline: Login to the BO and Purchase Service with wrong Auth service credentials
    Given User opens start page
    When User click on HFN login button
    And User click on Login text field and enter '<login>'
    And User click on Password text field and enter '<password>'
    And User click on login button
    Then User verify that login to the system is not successful '<errorMessage>'

    Examples:
      | login         | password  | errorMessage                                |
      | test.testsson | pt72r=P+= | These credentials do not match our records. |

  Scenario Outline: User check that all default widgets are displayed on the Dashboard page of Purchase Service
    Given User opens start page
    And User click on HFN login button
    And User click on Login text field and enter '<login>'
    And User click on Password text field and enter '<password>'
    And User click on login button
    When User click on change service button
    And User click on Purchase Service button
    Then User verify that all default widgets are displayed on the Purchase Service Dashboard page

    Examples:
      | login         | password   |
      | test.testsson | pt72r=P+=_ |

  Scenario Outline: User opens the Purchase Orders list page of Purchase Service
    Given User opens start page
    And User click on HFN login button
    And User click on Login text field and enter '<login>'
    And User click on Password text field and enter '<password>'
    And User click on login button
    When User click on change service button
    And User click on Purchase Service button
    And User click on the Purchase Orders list tab

    Examples:
      | login         | password   |
      | test.testsson | pt72r=P+=_ |

