package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Hooks {

	WebDriver driver;
	Properties p;
	
	@Before
	public void setup() throws IOException
	{
	driver=Base.initilizeBrowser();
	p=Base.getProperties();
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
	}
	//commenting out quit as I want user to proceed from checkout page
//	@After
//	public void teardown(Scenario scenario)
//	{
//	 driver.quit();
//	}
}
