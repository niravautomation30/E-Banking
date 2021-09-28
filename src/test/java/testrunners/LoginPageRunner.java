package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"./src/test/resources/features/LoginPage.feature"}, // path of feature file
		glue = {"stepdefinations","hooks"}, //path of steps defination file
		plugin= {"pretty",
				"html:target/MyReports/report.html",
				"json:target/MyReports/report.json",
				"junit:target/MyReports/report.xml"
				},
		monochrome=true, // display the console output in a proper readable format
		dryRun=false, // check the mapping is proper between feature file and step defination file
//		strict = true, // it will check if any step is not defined in the step def file
		tags = "@Smoke",
		publish= true
		)
public class LoginPageRunner {

}
