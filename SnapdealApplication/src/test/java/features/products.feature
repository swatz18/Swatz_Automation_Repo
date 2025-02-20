

Feature: Product Page Validations
  To check the filters and its results in Product Page

@price
Scenario: Price Validations
    Given Im in Snapdeal Product Page
    When I drag left slider to 50 and right slider to -50
    Then Check for price of the products
    And price should be greater than 733 and less than 2446
@cart
Scenario: Add to cart
    Given Im in Snapdeal Product Page
    When I click on product ,select the "M" Size
    And Check for availability of product for the pincode "641035"
    And Click Add to cart
    Then Check for the product in the cart
    And Remove the Product from the cart
