Feature: Addition product to cart Test

  Scenario: Add product to cart Test
    Given I open link "https://www.amazon.com/" in browser
    When I search "iPhone" on Amazon
    Then Verify if product is displayed
    And I add product to cart
    Then Verify if product is added to cart
    And I open cart page
    Then Verify is product displayed on cart page

  Scenario: Verify menu list on Home Page
    Given I open link "https://www.amazon.com/" in browser
    Then Verify menu items
      | Today's Deals    |
      | Customer Service |
      | Registry         |
      | Gift Cards       |
      | Sell             |

  Scenario: Verify selected language and currency
    Given I open link "https://www.amazon.com/" in browser
    And I scroll page down
    Then Verify language is "English"
    And Verify currency is "$USD - U.S. Dollar"

  Scenario: Verify correct work of sorting and filtering on Gift Cards Page
    Given I open link "https://www.amazon.com/" in browser
    And I open Gift Cards Page
    Then I choose format "Gift Box"
    And I choose brand "Amazon"
    And I choose price "$25 to $50"
    And I sort by "Price: Low to High"
    Then Verify first 4 Gift Cards