@Healthcheck
Feature: Launching Url and Checking login page
  

  @login @registration
  Scenario: launching the url on browser and fill registration
  
    Given user open the browser and checking  user navigate to right url
    And provide correct email address to navigate
    When user provide correct registration details and login
    Then user is launch on homepage correctly
    
      @login 
  Scenario:  Checking login page
   
   Given use launch the url on browser 
   When user login with valide credential
   Then checking the user launch to home page 
 
 
 


