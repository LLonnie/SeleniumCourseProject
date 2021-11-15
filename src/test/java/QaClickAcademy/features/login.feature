Feature: Homepage Login

  #To parameterize tests you have to use Scenario Outline: instead of Scenario:
  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://RahulShettyAcademy.com"
    And Click on Login link in home page to land on sign in page
    When User enters "<username>" and "<password>" and logs in
    Then Verify that user is successfully logged in
    And Close browser

    Examples:
      |username             |password  |
      |test99@gmail.com     |123456   |
      |llonnie21@gmail.com  |password  |

