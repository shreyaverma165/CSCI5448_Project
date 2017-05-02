# CSCI-5448 Course Project

# Industree- Factory Management Platform

## Team Members: Nestor Lobo, Shreya Verma, Varsha Teratipally

A user-friendly platform aimed to aid in the management of day-to-day working in a factory. It enables a centralized management systems if tasks such as tracking machine stock levels, getting information of the machine-line status, requesting stock if faulty or running low, etc. It also provides a management system for the Human Resources department for creating employee and managing employee information and enabling employees to apply for leaves and claims through the Approval center, searching for employees and view machine line statuses of all lines. A database is maintained for storing employee information and inventory of stocks. The factory personnels can edit their personal information, view their machine line statuses, apply for leaves and claims and search for any fellow employee in the department. The admin has been given access rights to change user roles of any employee and even deactivate their profile from the system.


## Steps to setup:
* Download the code by either cloning the repository or the zipped version.
* You'll need to update your JDK to a version 1.8.121 or above.
* Update the IDE by including JAR files for spring and hibernate. You can make use of JBoss Tools packages.
* Build the path for getting it running.
* Setup the apache server for running it in local environment.
* The database file is included in the project folder as databasegenerationscript.sql. You can open and run the queries through MYSQL on your local machine.
* Change the hibernate configuration file settings to match and synchronize with the MYSQL database.
* Once the server is up and running, open the following link in your browser: localhost:8080/RiomhaireApp/login.
