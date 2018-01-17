## Seed code - Boilerplate for step 7 AuthenticationService - Activity Stream Assignment

### Problem Statement

In this case study Activity Stream Step 7 - AuthenticationService, We will write main class for spring boot Application, configuration class, model class, repository class, service class and interface, logging aspect.

### Steps to be followed:

    Step 1: Add relevant dependencies in pom.xml file. 
        Note: Read the comments mentioned in pom.xml file for identifying the relevant dependencies.
    Step 2: Create Schema UserServiceDB.
    Step 3: Write code for model class(i.e User).
    Step 4: Write code for UserRepository (i.e Write query to find all circles matching with search string).
    step 5: Go thru UserService methods Don't change any method.
    step 6: Implement UserService methods in UserServiceImpl class.
    step 7: Write code for UserController class.
    step 8: Write code for UserAuthenticateController class. 
    step 9: Write the code for JwtFilter in config package.
    step 10: Write code for logger in LoggingAspectUser.java class consider all methods in controller classes.
    step 11: Write code for logger in LoggingAspectUserService.java class consider all methods in Service classes.
    step 12: Write code for AuthenticationServiceBoot.java class.
    step 13: Run UserControllerTest.java class.
    step 14: Run Spring boot application (i.e Run As -> spring boot app).
    
### Project structure

The folders and files you see in this repositories, is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
	|
	├── com.stackroute
	|	    └── AuthenticationServiceBoot.java      // This is the main class of Spring boot
	├── com.stackroute.activitystream.aspect
	|	    └── LoggingAspectUser.java                    // This class is responsible to generate the log reports
	|	    └── LoggingAspectUserService.java 
	├── com.stackroute.activitystream.config	           
	|	    └── JwtFilter.java                              // This class implements the custom filter by extending org.springframework.web.filter.GenericFilterBean. 
	├── com.stackroute.activitystream.controller
	|		└── UserController.java                      // This interface contains all the behaviours of User Repository
	├── com.stackroute.activitystream.model
	|		└── User.java                                // This class will be acting as the data model for the User Table in the database.
	├── com.stackroute.activitystream.repository
	|		└── UserRepository.java                      // This interface contains all the behaviours of User Repository
	├── com.stackroute.activitystream.service
	|		└── UserService.java                        // This class implements the UserRepository interface. This class has to be annotated with @Repository annotation.
	|		└── UserServiceImpl.java                    // This class implements the UserRepository interface. This class has to be annotated with @Repository annotation.
	├── com.stackroute.controller
	|		└── UserAuthenticateController.java         // This class will be used to create RESTful microservice for User Authentication.
	├── com.stackroute.activitystream.test              // All the test case classes are made available in this package
	|		└── UserControllerTest.java
	├── src/main/resources
	|		└── application.yml                 // This file contains all the properties for Database Connectivity
	|		└── logback.xml                     // XML file for configuring the logs
	├── .classpath			                    // This file is generated automatically while creating the project in eclipse
	├── .hobbes   			                    // Hobbes specific config options, such as type of evaluation schema, type of tech stack etc., Have saved a default values for convenience
	├── .project			                    // This is automatically generated by eclipse, if this file is removed your eclipse will not recognize this as your eclipse project. 
	├── pom.xml 			                    // This is a default file generated by maven, if this file is removed your project will not get recognised in hobbes.
	└── PROBLEM.md  		                    // This files describes the problem of the assignment/project, you can provide as much as information and clarification you want about the project in this file

> PS: All lint rule files are by default copied during the evaluation process, however if need to be customizing, you should copy from this repo and modify in your project repo

### Important instructions for Participants
> - We expect you to write the assignment on your own by following through the guidelines, learning plan, and the practice exercises
> - The code must not be plagirized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow through the problem statement shared with you

### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment select Run As -> spring boot app to run your Assignment.
- Right click on the Assignment select Run As -> JUnit Test to run your Assignment.