@Healthcheck

Feature: validation and Navigate

  @SearchBox
  Scenario: validating search box and logout functionality 
  
  Given user landed on home page 
  And validate the user on home page 
  When user provide the searchitem in search box
  And validating any duplicate are present
  Then search result found and user logout
  
