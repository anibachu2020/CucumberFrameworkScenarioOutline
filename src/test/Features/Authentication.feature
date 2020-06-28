Feature: User should be able to create account with valid data and should see error messages with invalid data

  Background:
    Given User is on home page
    When User click SignIn link
    Then User should be able to navigate to Authentication page
    And User should see create an account panel


    #Happy Path
  @smoke3
   Scenario: User should be able to navigate to registration page with valid data
    When User enter Email address as anibc12@gmail.com
    And Click on Create An Account button
    Then User should be able to navigate to registration page
    When User select Title as Mrs
    And  First name as Anitha, Last name as Bachu,Password as Password2
    And Date of Birth as "1 ","February ","2020  "
    And Company as Shrewsbury,City as London,State as Alaska,Zip as 10000,Country as United States
    And Enter Mobile number as 07402534364
    And click on Register button
    Then User should be on My Account page


    #Unhappy Path
     @regression @smoke4
    Scenario Outline: : User should see error message when invalid email address is entered
    When User enter Email address as <email>
    And Click on Create An Account button
    Then User should be able to see <errorMessage>

      Examples:
      |email|errorMessage|
      |anibc|Invalid email address.|
      |anibachu@gmail.com|An account using this email address has already been registered. Please enter a valid password or request a new one.|
    @regression @smoke5
      Scenario Outline: User cannot create account with invalid data
      When User enter Email address as <email>
      And Click on Create An Account button
      Then User should be able to navigate to registration page
      When User select Title as <Title>
      And  First name as <first name>, Last name as <Last name>,Password as <Password>
      And Company as <Company name>,City as <City>,State as <State>,Zip as <Zip>,Country as <Country>
      And Enter Mobile number as <Mobile no.>
      And click on Register button
      Then User should see validation message as <errorMessage>
      Examples:
      |email|Title|first name|Last name|Password|Company name|City|State|Zip|Country|Mobile no.|errorMessage|
      |anibc@gmail.com|   |          |         |        |            |    |     |   |       |          |Invalid email address.|
      |abc00@gmail.com|Mrs|abc|def     |1234    | abcde  |London|   Alaska | HP22 7BA |  United States |    074976543       |passwd is invalid.|
      |abc00@gmail.com|Mrs|abc|def     | 1234   | abcde  |London|          |  HP22 7BA|   United States |                    |You must register at least one phone number.|
