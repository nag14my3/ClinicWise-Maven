Feature: Practioner Login 

Scenario Outline: Practioner Login to verify newly resgister staff is working

Given User is on the login page
When Title of the Login Page is Wise Clicnic
Then User enters the "<log>" and "<pwd>"
Then User clicks on login button
Then Verify that user is able to login

Examples:

	| log | pwd |
    | Jhony.S | test |
    
 Scenario: Checking Practioner Details
 
 Given Practioner is on the login page
 When User checks his details
 Then He verifies that clinic which he got registered is displayed
 Then Logout as an Practioner
 