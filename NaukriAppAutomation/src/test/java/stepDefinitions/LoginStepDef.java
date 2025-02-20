package stepDefinitions;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObj;

public class LoginStepDef {
	
	WebDriver driver;
	LoginPageObj lp;
	
	@Given("I want to land in Naukri Application")
	public void i_want_to_land_in_naukri_application() {
	   lp=new LoginPageObj(Base.getDriver());
	   lp.selectLogin();
	}
	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void i_enter_for_creds(String un, String pass) {
	    lp.enterCredentials(un, pass);
	}
	@When("clcik the Login button")
	public void clcik_the_button() {
	    lp.selectLoginButton();
	}
	@Then("^I verify the \"([^\"]*)\" based on the credentials$")
	public void i_verify_based_on_the_credentials(String emsg) {
	    String amsg=lp.verifyAlertMessage();
	    assertEquals(emsg,amsg);
	}
	@Then("user should land in home page")
	public void user_should_land_in_home_page() {
	    boolean res=lp.verifyLogoIsPresent();
	    assertTrue(res);
	}
}
