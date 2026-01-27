Feature: Popups navigation

@practice @popups @navigation
Scenario: Navigate to Popups page from home
  Given I am on Practice Automation home page "https://practice-automation.com/"
  When I navigate to Popups page
  Then I should land on the Popups page

