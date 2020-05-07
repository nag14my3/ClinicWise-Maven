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
    
    
Scenario: Configuration of company info and creating new clinic

Given User is already on login page
When User Starts configuration of company info
Then User creates a new clinic 
Then Apply Settings to the clinic ceated
Then Finish the creation of new clinic
And Verify that new clinic is created by taking screenshot

Scenario: Create a new Staff using Register Staff Functionality

Given User is on login Page
When User clicks on register new staff link
Then User will be forwarded to New Staff Page
Then Enter all the details of Satff 
And Then click on Finish
Then Logout as an admin

    
    
