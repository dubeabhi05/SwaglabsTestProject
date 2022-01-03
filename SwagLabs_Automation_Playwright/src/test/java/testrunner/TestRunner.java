package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true,
        features = "src/test/resources/features/",
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber","junit:target/junitreport.xml","json:target/jsonreport.json","html:target/cucumber-reports",
}
        
)
public class TestRunner {
	
	
}
