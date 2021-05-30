# OutlookEmailValidations
------------------------------------------------------------------------
*****************Covered scenario in this framework*********************
-------------------------------------------------------------------------

This project has below automated scenario:
1)- Login to outlook email account and click on first email if it is there.
2)- Verify if subject and body of this email contains predefined string.
3)- Logout of the account and login with other users to do same.

---------------------------------------------------------------------
*********************** Necessary information ************************
---------------------------------------------------------------------
This whole scenario is automated through Selenium with Java, TestNg and Maven. 
User credentials are stored in Resources/Testdata.xlsx file and properties file stored at Configs folder contains details of body, subject, URl and driverpath.

------------------------------------------------------------------------
*************************How to run this project************************
-------------------------------------------------------------------------

Download the project and import as Maven project in eclipse ide.
Open Properties file and update chromedriver path.
Open Testdata.xlsx file from Resources folder and update users details.
Right click on Testng.xml and run as Test NG suite.



