package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import factory.Base;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import pageObjects.SearchPageObj;

public class HomeStepDef {
	WebDriver driver;
	HomePageObjects hp;
	SearchPageObj sp;
	boolean res;
		@Given("user lands in {string} application")
		public void user_lands_in_application(String appln) {
			hp=new HomePageObjects(Base.getDriver());
//			String current_url=driver.getCurrentUrl();
//			assertEquals(current_url,"https://www.snapdeal.com");
			System.out.println("I'm in Home Page");
		}

		@When("user cheks for {string} and enters {string} in search bar")
		public void user_cheks_for_and(String string1, String value) {
		    res=hp.isLogoPresent();
		    hp.inputSearchBar(value);
		       
		}

		@Then("{string} should be visible")
		public void should_be_visible(String string) {
			 assertTrue(res);
			    
		}

		@Then("user must be able to search using {string}")
		public void user_must_be_able_to_search_using(String value) {
			hp.clickSearchIcon();
			sp=new SearchPageObj(Base.getDriver());
			int count=sp.getTitleCount();
			List<String> product_title=sp.getAllTitle();
			for(int i=0;i<count;i++)
			{
				assertTrue(product_title.get(i).contains(value));
			}
			System.out.println("All titles contains text kurti");
		}
			
	}

