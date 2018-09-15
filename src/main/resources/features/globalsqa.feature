Feature: Validating globalsqa website button

  Scenario: Open globalsqa website and click multiple buttons
    Given Open globasqa website
    When User Clicks on button
    Then website navigates to a screen header with content
    And close browser
