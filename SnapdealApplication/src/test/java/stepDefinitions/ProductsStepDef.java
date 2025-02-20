package stepDefinitions;

import static org.junit.Assert.*;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import factory.Base;
import io.cucumber.java.en.*;
import pageObjects.HomePageObjects;
import pageObjects.SearchPageObj;

public class ProductsStepDef {
	WebDriver driver;
	HomePageObjects hp;
	SearchPageObj sp;
	int min;
	int max;
	
	@Given("Im in Snapdeal Product Page")
	public void im_in_snapdeal_product_page() {
	    hp=new HomePageObjects(Base.getDriver());
	    hp.clickWomensfashion();
	    System.out.println("Im in Product page");
	    
	}
	@When("I drag left slider to {int} and right slider to {int}")
	public void i_drag_left_slider_to(Integer minoffset, Integer maxoffset) {
		sp=new SearchPageObj(Base.getDriver());
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
	   
	}
	
	//Add to Cart
	@When("I click on product ,select the {string} Size")
	public void i_click_on_product_select_the_size(String string) {
		sp=new SearchPageObj(Base.getDriver());
	    sp.clickProduct();
	    sp.switchtoNewTab();
	    sp.clickProductSize();
	}

	@When("Check for availability of product for the pincode {string}")
	public void check_for_availability_of_product_for_the_pincode(String pin) throws InterruptedException {
	    sp.checkForPincode(pin);
	    String res=sp.checkIfProductAvailableForPincode();
	    assertTrue(res.contains("Item is available at"));
	    System.out.println("Product is available for the pincode");
	}

	@When("Click Add to cart")
	public void click_add_to_cart() {
	    sp.addTocart();
	    System.out.println("Product is added to the cart");
	}

	@Then("Check for the product in the cart")
	public void check_for_the_product_in_the_cart() throws InterruptedException {
	    sp.clickViewCart();
	    String actual_size=sp.checkForSelectedSizeInCart();
	    assertEquals(actual_size,"M");
	    System.out.println("Size of selected product and size of product in cart matches");
	}

	@Then("Remove the Product from the cart")
	public void remove_the_product_from_the_cart() {
		sp.removeFromCart();
		System.out.println("Product removed from cart");
		sp.clickStartShopping();
		hp=new HomePageObjects(Base.getDriver());
		hp.clickLogo();
		System.out.println("Back to Homepage");
	}
	
}
