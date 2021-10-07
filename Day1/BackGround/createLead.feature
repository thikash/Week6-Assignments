Feature: Create Lead functionality of Leaftaps application
Background: 
Given Open the Chrome Browser
Given Load the URL 'http://leaftaps.com/opentaps/' 


Scenario Outline: TC001_Create lead testcase positive flow

Given input the username as 'demosalesmanager'
Given input the password as 'crmsfa'
When Click the Login button
When Click the CRMSFA link
When Click the Leads link
When Click the CreateLead link
Then CreateLead page will be displayed
Given Input the companyname as <companyName>
Given Input the FirstName as <firstName>
Given Input the LastName as <lastName>
Given Input the phonenumber as <phonenumber>
When Click the CreateLead button
Then ViewLead should be displayed

Examples:

|companyName|firstName|lastName|phonenumber|
|'TVS'|'Maniakandan'|'S'|'777558822'|
|'SBI'|'Sobana'|'V'|'82569741'|

Scenario: TC002_Create lead testcase positive flow


Given input the username as 'democsr'
Given input the password as 'crmsfa'
When Click the Login button
When Click the CRMSFA link
When Click the Leads link
When Click the CreateLead link
Then CreateLead page will be displayed
Given Input the companyname as 'Zoho'
Given Input the FirstName as 'Ranjith'
Given Input the LastName as 'M'
Given Input the phonenumber as '92568147'
When Click the CreateLead button
Then ViewLead should be displayed

