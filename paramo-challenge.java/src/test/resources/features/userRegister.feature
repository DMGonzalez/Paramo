@tag
Feature: Registration user

  @Test_Registration
  Scenario: user creates an account, checks it and deposits the bonus
    Given Executing Chrome Driver
    When User registration
    And Checking registration and deposit the bonus
    Then Close Chrome Driver