package com.Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/Login.feature",
		glue="com.stepDefinition",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty",
				"html:target/HTML Reports"}
)
public class Runner {

}
