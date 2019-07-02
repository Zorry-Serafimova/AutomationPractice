Feature: Automation Practice website, final Project

    Background:
      Given User navigates to login page
      When Login form is present
      And User enters "abcde@abcde.com" in email field and "testing" in password field
      Then User is On My Account page

      Scenario: User clicks on Women Category
        Given Women Category exists on page
        When User clicks on Women category
        Then Women Category page is loaded
