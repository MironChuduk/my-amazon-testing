Feature: Reset functionality on login page of Application

  Background:
    Given Open link "https://www.amazon.com/" in browser

  Scenario: Verification of Reset button
    When Search "iPhone" on Amazon
    Then Check if product is displayed
    And Add product to cart
    Then Check if product is added to cart
    And Open cart page
    Then Check is product displayed on cart page