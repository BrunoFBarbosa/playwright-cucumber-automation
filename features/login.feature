#language:en
@login
Feature: Login

  @positive
  Scenario: Login to the application with valid credentials
    Given the user is on login page
    When the user logs in with a valid credential
    Then the home page should be visible

  @negative
  Scenario Outline: Login to the application with wrong credentials
    Given the user is on login page
    When the user logs in with '<credential>' credentials
    Then the login error message '<error_message>' should be visible

    Examples:
      | credential       | error_message                                                   |
      | invalid          | Username and password do not match any user in this service     |
      | locked           | Sorry, this user has been locked out                            |