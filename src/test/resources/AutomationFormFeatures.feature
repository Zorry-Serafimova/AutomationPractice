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
    Then Listing is added to cart
