# leapScholarAssignmentTask

/***** Project created in IntelliJ IDE ******/

TestData.xlsx -> Data is loaded from here [Stored in src/main/resources/TestDataFiles/TestData.xlsx]
Hence Data related maintenance can be handled in Excel file
DataSets as per the scenario can be changed =>Country, SpotCounsellingUrl, Preferred Intake, Course, Education, Percentage, Graduation, StatusOfIELTS, UniversityAdmit, SlotTypeUrl, ProfileChatUrl, ProfileCounsellingUrl

Config.properties -> url, otp, environment[qa/staging], browser type, testdata path can be set here

Web Elements -> are located in Page Elements package as per the Page Names. Hence locator changes maintenance can be done pageElements package

Page Objects ->Page methods and page functions are defined in PageObject package. Any change in the functionalities can be maintained here

StepDefinitions -> The flow defined in feature file is mapped with stepDefinitions

SeleniumUtils -> Handles all the selenium methods and can be enhanced further by implementing waits, screenshots etc

Report -> Execution report can be viewed in target/cucumber-report/html
