Feature:Login functionality
@LoginTest
Scenario Outline: Login to the App
  Given ck12 is launched
  When  user clicks on SignIn button
  And   user enters username "<username>"
  And   user enter password "<password>"
  And   user clicks login button
  Then  SignIn should be "<Expected_Result>"
  Examples:
  |username|password|Expected_Result|
  |mzakkar@gmail.com|test123|successful|