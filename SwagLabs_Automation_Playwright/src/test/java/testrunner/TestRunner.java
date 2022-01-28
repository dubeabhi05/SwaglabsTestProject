package testrunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions( 
        features = "src/test/resources/features/",
        glue = {"stepdefinitions","hooks"},
        		plugin = { "pretty",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber", "junit:target/junitreport.xml",
                        "json:target/jsonreport.json", "html:target/cucumber-reports"
        },
        		
        		
        monochrome = true,publish = true 
        
        
)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
}
