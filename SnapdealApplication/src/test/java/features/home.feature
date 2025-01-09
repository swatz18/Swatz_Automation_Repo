
Feature: Snapdeal Homepage 
  validate functions in Home Page of Snapadeal Application

  @home
  Scenario: Verify the Logo and Search Bar
    Given user lands in "snapdeal" application
    When user cheks for "Logo" and enters "Kurti" in search bar
    Then "Logo" should be visible
    And user must be able to search using "Kurti"

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
