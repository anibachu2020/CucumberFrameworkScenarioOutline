Feature: Login feature of Automation Practice
  User has to login sucessfully with valid credentials and see validation messages for invalid credentials

  Background:
    Given User is on home page
    When User click SignIn link
    Then User should be able to navigate to Authentication page
    And User should see SignIn Panel


  @smoke1
  Scenario: Verify user can login suceesfully with valid credentials
  When User enter Email address as anib1@gmail.com, password as Password2
  And click SIgnIn button
  Then User should loggedIn sucessfully
  And User should be on My Account page

  @regression @smoke2
  Scenario Outline:Verify that user an see validation message for invalid credentials
    When User enter Email address as <email>, password as <password>
    And click SIgnIn button
    Then User should see validation message as <errormessage>
    Examples:
      | email | password | errormessage               |
      |       |          | An email address required. |
      |       | password | An email address required.  |
      |anitha@gmail.com|Password2|Authentication failed.|
      |ani             |Password2|Invalid email address.|
      |anib1@gmail.com |         |Password is required. |

