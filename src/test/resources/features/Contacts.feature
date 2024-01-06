Feature: Contacts Page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the usr navigates to "Customers" "Contacts"
    Then the deafult page number should be 1