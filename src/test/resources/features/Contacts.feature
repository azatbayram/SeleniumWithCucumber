Feature: Contacts Page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers" "Contacts"
    Then the default page number should be 1


  Scenario: Verify Create Calendar Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to "Activities" "Calendar Events"
    Then the title should contains "Calendar"
    #add "s" at the end of calendar to fail

  Scenario: Menu Options
    Given the user logged in as "driver"
    Then the user should see following options
    |Fleet     |
    |Customers |
    |Activities|
    |System    |

  Scenario: Menu Options for Sales Manager
    Given the user logged in as "sales manager"
    Then the user should see following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

@wip
  Scenario: Contacts test with email
    Given the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "mbrackstone9@example.com" from contacts
    Then the information should be same with database

  Scenario Outline: Contacts Test
    Given the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "<email>" from contacts
    Then the information for "<email>" should be same with database

    Examples:
      |email|
      |mbrackstone9@example.com|
      |mike.jorden@hotmail.com |