
@cart
Feature: Successfull Checkout of the cart 
  I want to checkout the cart after sucessfully adding the products

  @add
  Scenario: Add products to cart
    Given I want to land in Blisspad Website
    And I click on Sanitary Napkins tab
    When I apply filters
    And Select the product
    And click on add to cart
    Then I verify products are added to the cart
