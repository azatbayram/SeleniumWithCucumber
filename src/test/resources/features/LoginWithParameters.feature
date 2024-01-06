Feature: Login as different users

  Scenario: login as driver user
    Given the user is on the login page
    When the user logs in "user10" and "UserUser123"
    Then the user should be able to login