package stepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.LoginPageObjects;

public class LoginStepDef {

	WebDriver driver;
	LoginPageObjects lo;
	
	@Before
	public void setup() throws MalformedURLException
	{
//		DesiredCapabilities capabilities=new DesiredCapabilities();
//		capabilities.setPlatform(Platform.WINDOWS);
//		capabilities.setBrowserName("chrome");
//		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Given("User navigates to Opencart Application Login page")
	public void user_navigates_to_login_page() {
	  driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@Given("User enters valid username and password")
	public void user_enters_valid_creds() {
		lo=new LoginPageObjects(driver);
	    lo.setUsername("swatz123@gmail.com");
	    lo.setPassword("Welcomemec1!");
	    
	}

	@When("User cliks on Login")
	public void user_cliks_on_login() {
		 lo.clickLogin();
	}

	@Then("Login should be Successfull")
	public void login_should_be_successfull() {
		boolean result=lo.checkSuccessLogin();
		Assert.assertEquals(result, true);
	}

	@Given("User enters invalid {string} and {string}")
	public void user_enters_invalid_creds(String username,String password) {
		lo=new LoginPageObjects(driver);
	    lo.setUsername(username);
	    lo.setPassword(password);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
	   lo.clickLogin();
	}

	@Then("user should see the {string} message")
	public void user_should_see_error_message(String error) {
	    String actualmsg=lo.readErrorMessage();
	    Assert.assertEquals(actualmsg,error);
	}

}
