Feature: CCM Client portal access and navigation
  As a user of the CCM Client
  I want to access the portal and perform common actions
  So that I can complete my tasks

  Background:
    Given the CCM Client portal URL "http://153.71.158.137/CCMClient/#/~2"

  Scenario: Portal is reachable
    When I open the CCM Client portal
    Then the page should load successfully
    And I should see the application title "CCM Client"

  Scenario: User login with valid credentials
    Given I am on the login page
    When I login with username "user1" and password "password1"
    Then I should be logged in successfully
    And I should see the dashboard

  Scenario: Navigate to Claims section
    Given I am logged in
    When I navigate to the "Claims" section
    Then I should see the Claims list
    And the URL should contain "/Claims"

  Scenario: Search for a claim by ID
    Given I am on the Claims list page
    When I search for claim ID "CLM-12345"
    Then I should see claim "CLM-12345" in the results

  Scenario: View claim details
    Given a claim "CLM-12345" is in the results
    When I open the claim details
    Then I should see the claim details page
    And the claim status should be visible

  Scenario: Logout
    Given I am logged in
    When I logout
    Then I should be redirected to the login page
    And I should see "Sign In"
