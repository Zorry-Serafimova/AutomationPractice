Feature: Automation Practice website, final Project

  Background:
    Given User navigates to login page
    When Login form is present
    And User enters "abcde@abcde.com" in email field and "testing" in password field
    Then User is On My Account page

  Scenario: User clicks on Women Category, selects a listing and adds it to cart
    Given Women Category exists on page
    When User clicks on Women category
    And Women Category page is loaded
    And User clicks on a listing
    And Listing page is loaded
    And User adds listing to Cart
    And Listing is added to cart
    And User clicks on proceed to checkout button
    And User changes delivery address and checks its updated properly
    And User goes to Shipping, click Terms of service and proceed to checkout
    And User selects pay by check
    And User confirms Order
    And Confirm order submitted
    And Go back to orders
    Then User Logs out



