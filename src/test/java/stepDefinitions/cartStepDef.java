package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.cartPageObj;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class cartStepDef {
	WebDriver driver;
	cartPageObj cpo;
	
	WebDriverWait wait=new WebDriverWait(Base.getDriver(),Duration.ofSeconds(20));
	JavascriptExecutor js=(JavascriptExecutor) Base.getDriver();
	Actions a=new Actions(Base.getDriver());
	
	@Given("I want to land in Blisspad Website")
	public void i_want_to_land_in_blisspad_website() {
	   cpo=new cartPageObj(Base.getDriver());
	   //switch to the frame to check for the popup visibility
	   Base.getDriver().switchTo().frame("cmessage_form_iframe");
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Enter your email\"]")));
	   boolean popup=cpo.loginPopupVisible();
	   //if popup is visible, then close it
	   if(popup)
	   {
		   cpo.popupClose();
	   }
	   Base.getDriver().switchTo().defaultContent();
	}

	@Given("I click on Sanitary Napkins tab")
	public void i_click_on_sanitary_napkins_tab() {
	    cpo.napkinsTab();
	}

	@When("I apply filters")
	public void i_apply_filters() throws InterruptedException {
		//scroll to the Size section
		js.executeScript("window.scrollBy(0,900)", " ");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@for=\"Filter-Size-2\"]//*[name()=\"svg\"]")));
	    cpo.selectSize();
	    Thread.sleep(3000);
//	    cpo.sliderMax();
//	    cpo.sliderMin();
	    cpo.sendMaxInput();
	}

	@When("Select the product")
	public void select_the_product() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(" XL Fluffy (6 Pads) ")));
	    boolean res=cpo.selectProduct();
	    if(res)
	    {
		    cpo.selectOptions();
		    cpo.selectpack();
		    cpo.addQuantity();
	    }
	   }

	@When("click on add to cart")
	public void click_on_add_to_cart() {
	    cpo.addToCart();
	}

	@Then("I verify products are added to the cart")
	public void i_verify_products_are_added_to_the_cart() throws InterruptedException {
	   boolean freeship=cpo.checkForFreeShipping();
	   assertTrue(freeship);
	   //check if the product in cart is same as selected product
	   String name=cpo.checkForProductNameInCart();
	   assertTrue(name.contains("XL Fluffy"));
	   cpo.checkout();
	   //switch to desired frame to enter phone number
	   Base.getDriver().switchTo().frame("gokwik-iframe");
	   cpo.clickMobile();
	   
	}
}
