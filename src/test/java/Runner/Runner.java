package Runner;

import Base.CutomizeTestNGCucmberRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/resources/Feature/test.feature",
		glue = { "stepDef", "Hooks" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		
		)

public class Runner extends CutomizeTestNGCucmberRunner {

}
