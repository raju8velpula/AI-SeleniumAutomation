Feature: test

@practice @popups
Scenario: Verify alert popup on Popups page
  Given I am on Practice Automation home page "https://practice-automation.com/"
  When I click on Popups link
  Then I should land on the Popups page
  When I click the Alert popup button
  Then I should see an alert and accept it

# ...existing code...

