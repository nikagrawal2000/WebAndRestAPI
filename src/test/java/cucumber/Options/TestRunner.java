package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
				plugin = {"pretty","json:target/cucumber-reports/cucumber.json","html:target/cucumber/report.html",
						"junit:target/cucumber-reports/cucumber-report.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"},
				glue = {"stepDefinations" },
				monochrome=true,
				tags = "@Backend",
				dryRun=false
				)

public class TestRunner {
}
