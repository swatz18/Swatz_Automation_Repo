package testRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"./features"},
				  glue={"stepDefinitions"},
				  plugin={"pretty","html:reports/myreport.html",
						  "rerun:target/rerun.txt"},
				  monochrome=true,
				  publish=true,
				  tags="@invalid")
public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
