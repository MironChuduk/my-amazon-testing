Feature: Amazon Tests

  Background:
    Given I open the site in browser

  Scenario: Add product to cart Test
    When I search "iPhone" on Amazon
    Then I see the product
    And I add product to cart
    Then I see the product is added to cart
    And I open cart page
    Then I see the product is displayed on cart page

  Scenario: Verify menu list on Home Page
    Then Verify menu items
      | Today's Deals    |
      | Customer Service |
      | Registry         |
      | Gift Cards       |
      | Sell             |

  Scenario: Verify correct work of sorting and filtering on Gift Cards Page
    When I open Gift Cards Page
    Then I choose format "Gift Box"
    And I choose brand "Amazon"
    And I choose price "$25 to $50"
    And I sort by "Price: Low to High"
    Then Verify first 4 Gift Cards

  Scenario: Verify selected language and currency
    When I scroll page down
    Then Verify language is "English"
    And Verify currency is "$USD - U.S. Dollar"