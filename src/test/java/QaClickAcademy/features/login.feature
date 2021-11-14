Feature: Homepage Login

  Scenario: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://RahulShettyAcademy.com"
    And Click on Login link in home page to land on sign in page
    When User enters "test99@gmail.com" and "123456" and logs in
    Then Verify that user is successfully logged in
