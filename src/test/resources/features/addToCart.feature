@AddToCartPage
Feature: Add an item to a shopping cart

  Background:
    Given User has logged on to the QA Practice Login Shop page "https://qa-practice.netlify.app/auth_ecommerce.html" with email "admin@admin.com" and password "admin123"

  @AddItemToShoppingCart
  Scenario: Add an item to the shopping cart

    When User adds the Apple iPhone 12, 128GB, Black to their shopping cart on the "SHOPPING CART" page
    Then User can see the "REMOVE" button for the Apple iPhone 12, 128GB, Black in their shopping cart

