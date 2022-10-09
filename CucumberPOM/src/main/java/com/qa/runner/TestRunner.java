package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//I removed this complete path in features to make work, earlier faced java.lang.IllegalArgumentException: path must exist: E:\eclipseWorkspace\FreeCrmBDDCucumberFramework\src\main\java\Features\hooks.feature
		//E:\\eclipseWorkspace\\FreeCrmBDDCucumberFramework\\
		features = "E:\\eclipseWorkspace\\CucumberPOM\\src\\main\\java\\com\\qa\\features\\freecrm.feature",
		glue = {"com/qa/stepDefinitions"}, //the path of the stepdefinition files
		//format = {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
		monochrome = true, //Display the console output in a proper readable format
		strict = true, // it will check and fail the execution, if there are any pending steps or not defined steps in stepDefinition file, it should be treated as errors.
		dryRun = false //dryRun = true ===> it will check the mapping first between feature file with compared to StepDefinition file, It will not proceed to TestExecution
		//dryRun = false will allow now to proceed for TestExecution
		//tags = {"@SmokeTest" } //This is to execute only SmokeTest,Currently not supported
		//tags = {"~@SmokeTest , @RegressionTest"} //This is to execute both SmokeTest and RegressionTest,Currently not supported
		//tags = "@SmokeTest" //This is only currently allowed now and i make this also comment
		)

public class TestRunner {

}
//ORed condition represents tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
//ANDed condition represents tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
//To ignore the tags, simply give like tags = {"~@SmokeTest" , "@RegressionTest"} -- Here only @RegressionTest alone to be executed 
//if i give like tags = {"~@SmokeTest" , "~@RegressionTest"} -- Here remaining tags, which is only @End2End alone to be executed 
//if i give like tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"} -- Here unnamed scenarios alone to be executed