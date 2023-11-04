Feature: Login Functionality

Scenario Outline: Login with valid crendentials
Given User navigates to login page
When User enters valid email address <username> into email field
When User enters valid password <password> into password field
And User clicks on Login Button
Then User should get successfully logged in

Examples:
|username           			|password|
|amotooricap1@gmail.com   |12345   |
|amotooricap2@gmail.com   |12345 	 |
|amotooricap3@gmail.com   |12345   |
Scenario: Login with invalid crendentials
Given User navigates to login page
When User enters invalid email address "amotooricap12564@gmail.com" into email field
When User enters valid password "123458956" into password field
And User clicks on Login Button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
When User enters invalid password "123458956" into password field
And User clicks on Login Button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address "amotooricap12564@gmail.com" into email field
When User enters valid password "12345" into password field
And User clicks on Login Button
Then User should get a proper warning message about credentials mismatch
