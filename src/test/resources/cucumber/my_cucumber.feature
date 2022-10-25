Feature: Addition product to cart Test

  Background:
    Given I open link "https://www.amazon.com/" in browser

  Scenario: Add product to cart Test
    When I search "iPhone" on Amazon
    Then Verify if product is displayed
    And I add product to cart
    Then Verify if product is added to cart
    And I open cart page
    Then Verify is product displayed on cart page