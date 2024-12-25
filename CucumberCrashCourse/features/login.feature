Feature: Login Functionality
 To login to open cart application

Background:
	Given User navigates to Opencart Application Login page
  
 Scenario: Valid Login To OpenCart Application
    Given User enters valid username and password
    When User cliks on Login
    Then Login should be Successfull

  
 Scenario Outline: Invalid Login To OpenCart Application
    Given User enters invalid "<username>" and "<password>"
    When user clicks login button
    Then user should see the "<error>" message
    
    Examples: 
      | username  | password | error   |
      | acbww     |  w53wwr  |  Warning: No match for E-Mail Address and/or Password. |
      |           |   wrrrt7 |  Warning: No match for E-Mail Address and/or Password. |
