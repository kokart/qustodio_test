# qustodio_test

This is a project based in MAVEN and TESTNG to create Login Tests for Qustodio using Selenium. You only need have configured eclipse (or your favourite IDE), maven and testng plugin. Chromedriver is also included.

It's using Page Object Model pattern. We have a class called LoginPage where we have defined all elements from it and the methods to get the Objects.

The example has a test using DataProvider and if it fails, a screenshot is taken and stored on $PATH_SCREENSHOTS


UPDATE 07/10/2018: 
Now it's running CircleCI and TestingBOT as selenium hub. Chromedrive local file is included but if you want to launch in local you should
modify method BeforeClass of BaseTest.java file.

