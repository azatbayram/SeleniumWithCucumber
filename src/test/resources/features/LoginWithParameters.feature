Feature: Login as different users

  Scenario: login as driver user
    Given the user is on the login page
    When the user logs in "user10" and "UserUser123"
    Then the user should be able to login
    And the title should contains "Dashboard"

         #homework
  Scenario: login as a driver
    Given the user logged in as "driver"
    Then the user should be able to login
    And the title should contains "Dashboard"
    #driver,storemanager,salesmanager
   #you will have one step definition and it will handle differnet usertypes

  Scenario: Login as given user
    Given the user is on the login page
    When the user logs in using following credentials
    |username  |user10     |
    |password  |UserUser123|
    | firstname| John      |
    | lastname | Doe       |
    Then the user should be able to login