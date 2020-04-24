Feature: Company Management

Scenario Outline: Clerk Login

Given User is on the login page
When Title of the Login Page is Wise Clicnic
Then User enters the "<log>" and "<pwd>"
Then User clicks on login button
Then Verify that user is able to login

Examples:

	| log | pwd |
    | clinic1admin  | test |
