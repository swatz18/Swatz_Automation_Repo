package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import pageObjects.HomePageObjects;
import pageObjects.SearchPageObj;

public class ProductsStepDef {
	static WebDriver driver;
	HomePageObjects hp;
	SearchPageObj sp;
	int min;
	int max;
	
	@Given("Im in Snapdeal Product Page")
	public void im_in_snapdeal_product_page() {
		driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
	    driver.manage().window().maximize();
	    driver.get("https://www.snapdeal.com");
	    hp=new HomePageObjects(driver);
	    hp.clickWomensfashion();
	    System.out.println("Im in Product page");
	    
	}
	@When("I drag left slider to {int} and right slider to {int}")
	public void i_drag_left_slider_to(Integer minoffset, Integer maxoffset) {
		sp=new SearchPageObj(driver);
		int  minoffset_val=sp.getMinLocation();
		sp.dragLeftSlider(minoffset);
		hp.isLogoPresent();
		int maxoffset_val=sp.getMaxLocation();
		sp.dragRighttSlider();
		System.out.println(minoffset_val);
		System.out.println(maxoffset_val);
	    
	}

	@Then("Check for price of the products")
	public void check_for_price_of_the_products() {
	    String p[]=sp.fetchMinMaxPrice();
	    String minp=p[1];
	    String maxp=p[4];
	    min=Integer.parseInt(minp);
	    max=Integer.parseInt(maxp);
	    
	}

	@Then("price should be greater than {int} and less than {int}")
	public void price_should_be_greater_than(Integer min,Integer max) {
	    List<String> pp=sp.getProductprice();
	    for(int i=0;i<pp.size();i++)
	    {
	    	String value=pp.get(i);
	    	String val=value.replace(",","");
	    	int price=Integer.parseInt(val);
	    	if (price>=min && price<=max)
	    	{
	    		System.out.println("Filtered products Price is within the range");
	    	}
	    	else
	    	{
	    		System.out.println("Filtered products Price is not within the range");
	    	}
	    }
	    driver.quit();
	}

	
}
