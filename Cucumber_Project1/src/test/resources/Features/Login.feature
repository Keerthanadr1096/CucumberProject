Feature: Test the login functionality of OrangeHRM

Scenario: Test the valid login

Given user is on loginpage
When user enters username as "Admin" and password as "admin123"
And click on login button
Then page title should be "OrangeHRM"
And close browser


