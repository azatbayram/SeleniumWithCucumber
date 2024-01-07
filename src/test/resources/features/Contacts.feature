Feature: Contacts Page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the usr navigates to "Customers" "Contacts"
    Then the default page number should be 1


  Scenario: Verify Create Calendar Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the usr navigates to "Activities" "Calendar Events"
    Then the title should contains "Calendar"
    #add "s" at the end of calendar to fail
@wip
  Scenario: Menu Options
    Given the user logged in as "driver"
    Then the user should see following options
    |Fleet     |
    |Customers |
    |Activities|
    |System    |