@LoginPage
Feature: Login to a test Application

  Background:
    Given User is on QA Practice Login Shop page "https://qa-practice.netlify.app/auth_ecommerce.html"

  @ValidCredentials
  Scenario: Login with valid credentials

    When User enters email as "admin@admin.com" and password as "admin123"
    Then User should be able to login successfully and new page "SHOPPING CART" opens

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters email as "admin@admin.com" and password as "bozo"
    Then User should be able to see error message "Bad credentials! Please try again! Make sure that you've registered."

    Examples:
      | email           | password |
      | admin@admin.com | bozo     |
      | bozo@admin.com  | admin123 |

  @ValidCredentialsLoadTest
  Scenario Outline: Login with valid credentials 20 times in a row

    When User enters email as "<email>" and password as "<password>"
    Then User should be able to login successfully and new page "SHOPPING CART" opens

    Examples:
      | email           | password |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
      | admin@admin.com | admin123 |
