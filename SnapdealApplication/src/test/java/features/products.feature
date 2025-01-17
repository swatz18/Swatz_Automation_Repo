

Feature: Product Page Validations
  To check the filters and its results in Product Page

  @price
  Scenario: Price Validations
    Given Im in Snapdeal Product Page
    When I drag left slider to 50 and right slider to -50
    Then Check for price of the products
    And price should be greater than 733 and less than 2446

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
