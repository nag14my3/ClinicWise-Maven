Feature: ClinicWise Login Feature

Scenario Outline: CliniWise Login Test Scenario

Given User is on the login page
When Title of the Login Page is Wise Clicnic
Then User enters the "<log>" and "<pwd>"
Then User clicks on login button
Then Verify that user is able to login

Examples:

	| log | pwd |
    | admin  | test |
    | sharon | test |
    | mark | test |
    
    