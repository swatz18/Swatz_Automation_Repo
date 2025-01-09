package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import pageObjects.SearchPageObj;

public class HomeStepDef {
	static WebDriver driver;
	HomePageObjects hp;
	SearchPageObj sp;
	boolean res;
		@Given("user lands in {string} application")
		public void user_lands_in_application(String appln) {
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
			driver.get("https://www."+appln+".com");
		    driver.manage().window().maximize();
		}

		@When("user cheks for {string} and enters {string} in search bar")
		public void user_cheks_for_and(String string1, String value) {
		    hp=new HomePageObjects(driver);
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
			sp=new SearchPageObj(driver);
			int count=sp.getTitleCount();
			List<String> product_title=sp.getAllTitle();
			for(int i=0;i<count;i++)
			{
				assertTrue(product_title.get(i).contains(value));
			}
			driver.quit();
		}

	}

