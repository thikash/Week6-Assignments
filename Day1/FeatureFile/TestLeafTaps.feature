Feature: Create Lead Functionallity of Leaftaps Application

Scenario Outline: TC01_Create Lead TestCases
#Given input the username as 'demosalesmanager'
#Given input the password as 'crmsfa'
#When Click the Login button
#When Click the CRMSFA link
#When Click the Leads link
#username to leads steps implement to Hooksimplementation
When Click the CreateLead link
Then CreateLead Page will be displayed
Given Input the CompanyName as <companyName>
Given Input the FirstName as <firstName>
Given Input the LastName as <lastName>
Given Input the PhoneNumber as <phoneNumber>
When Click on Submit button
Then ViewLead should be displayed

Examples:
|companyName|firstName|lastName|phoneNumber|
|'OMega'|'Meena'|'G'|'7392486'|
|'HCL'|'Chithra'|'K'|'869421'|

Scenario Outline: TC02_Duplicate Lead TestCases
When Click the SearchFindLeads link
Given Input the firstName as<firstName>
When Click the FindLeads link
When click on firstLeads link
Then ViewLead Page should be displayed
When Click on Duplicate link
When Click on Submit button
Then viewLead CompanyName
Examples:
|firstName|
|'Meena'|
|'Chithra'|

Scenario Outline: TC03_EditLead TestCases
When Click the SearchFindLeads link
Given Input the firstName as<firstName>
When Click the FindLeads link
When click on firstLeads link
Then ViewLead Page should be displayed
When click on EditLead link
Given update companyName 'IBM'
When Click on Submit button 
Then viewLead CompanyName
Examples:
|firstName|
|'Ragul'|
|'Deepika'|

Scenario Outline: TC04_Merge Lead TestCases
When Click On Merge Leads link
When Click the FromLead <firstNameofFrL>
When Click the ToLead <firstNameofToL>
When Click On the MergeButton
When Click the SearchFindLeads link
Given Capture the  LeadId enter the LeadId

Examples:
|firstNameofFrL|firstNameofToL|
|'Sundram'|'Vignesh'|

Scenario Outline: TC05 Delete Lead TestCase
When Click the SearchFindLeads link
Given Input the firstName as<firstName>
When Click the FindLeads link

Then ViewLead Page should be displayed
When capture Delete LeadID
When Click on Delete Lead button
When Click the SearchFindLeads link
Given Search The Delete LeadId
When Click the FindLeads link
Then No records to display get message
Examples:
|firstName|
|'Ragul'|
|'Ram Prabhu'|