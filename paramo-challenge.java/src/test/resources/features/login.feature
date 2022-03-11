@tag
Feature: Login test

  @Test_Login
  Scenario: User login with credentials
    Given Executing Chrome Driver
    When User login
    And Checking login
    Then Close Chrome Driver