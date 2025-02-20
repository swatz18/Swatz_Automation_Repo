package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPageObj extends BaseClass {
	
	List<String> titles=new ArrayList<String>();
	List<String> prices=new ArrayList<String>();
	
	public SearchPageObj(WebDriver driver)
	{
		super(driver);
	}
	Actions a=new Actions(driver);
	
	@FindBy(xpath="//*[@class=\"product-title\"]")	List<WebElement> prdct_title;
	//price slider
	@FindBy(xpath="//a[contains(@class,\"left-handle\")]")	WebElement left_slider;
	@FindBy(xpath="//a[contains(@class,\"right-handle\")]")	WebElement right_slider;
	@FindBy(xpath="//a[contains(@data-key,\"Price|Price\")]")	WebElement min_max_price;
	@FindBy(xpath="//span[contains(@id,\"display-price\")]")	List<WebElement> product_prices;
	
	//Add to cart
	@FindBy(xpath="//picture[contains(@class,\"picture-elem\")]//parent::a")	WebElement product_image;
	@FindBy(xpath="//div[contains(@selectedattr,\"M\")]/div[text()=\"M\"]")	WebElement product_size;
	@FindBy(how=How.ID,using="pincode-check")	WebElement pincode_check;
	@FindBy(how=How.ID,using="pincode-change")	WebElement change_pincode;
	@FindBy(how=How.ID,using="pincode-check-bttn")	WebElement pincode_chk_btn;
	@FindBy(xpath="//p[contains(.,\"Item is available at\")]")	WebElement prdct_available_msg;
	@FindBy(how=How.ID,using="add-cart-button-id")	WebElement add_to_cart;
	@FindBy(xpath="//a[contains(@id,\"rzp-quickcart-button\")]//following::div[contains(.,\"View Cart\")]") WebElement view_cart;
	@FindBy(xpath="//p[@class=\"item-extra-feature\"]/span[contains(.,\"Size:\")]")	WebElement 	size_in_cart;
	@FindBy(xpath="//span[contains(@class,\"remove-item-shortlist\")]")	WebElement	remove_from_cart;
	@FindBy(how=How.LINK_TEXT,using="START SHOPPING NOW")	WebElement	start_shopping_btn;
	@FindBy(xpath="//*[@class=\"row reset-margin\"]")	WebElement random_click;
	
	public int getTitleCount()
	{
		int count=prdct_title.size();
		return count;
	}
	public List<String> getAllTitle()
	{
		for(int i=0;i<prdct_title.size();i++)
		{
			String title=prdct_title.get(i).getText();
			titles.add(title);
		}
		return titles;	
	}
	public int getMinLocation()
	{
		int min=left_slider.getLocation().getX();
		return min;
	}
	public int getMaxLocation()
	{
		int max=right_slider.getLocation().getY();
		return max;
	}
	
	public void dragLeftSlider(int minoffset)
	{
		a.dragAndDropBy(left_slider,minoffset,0).perform();
	}
	public void dragRighttSlider()
	{
		a.dragAndDropBy(right_slider,-50,0).perform();
	}
	public String[] fetchMinMaxPrice()
	{
		String priceRange=min_max_price.getText();
		String pr[]=priceRange.split(" ");
		System.out.println(Arrays.toString(pr));
		return pr;
	}
	
	public List<String> getProductprice()
	
	{
		for(int i=0;i<product_prices.size();i++)
		{
			String price=product_prices.get(i).getText();
			String p[]=price.split(" ");
			String pri=p[1];
			prices.add(pri);
			//System.out.println(Arrays.toString(p));	
		}
		System.out.println(prices);
		return prices;
		
	}
	//Add to cart
	public void clickProduct()
	{
		product_image.click();
	}
	public void switchtoNewTab()
	{
		Set<String> wh=driver.getWindowHandles();
		List<String> id=new ArrayList<>(wh);
		String newtab=id.get(1);
		driver.switchTo().window(newtab);
	}
	public void clickProductSize()
	{
		boolean res=product_size.isDisplayed();
		if(res)
		product_size.click();
		random_click.click();
	}
	public void checkForPincode(String pin) throws InterruptedException
	{
		
		boolean isVisible=change_pincode.isDisplayed();
		if(isVisible)
		{
			change_pincode.click();
			pincode_check.clear();
		}
		boolean res=pincode_check.isEnabled();
		if(res)
		{
		Thread.sleep(3000);
		pincode_check.click();
		pincode_check.sendKeys(pin);
		pincode_chk_btn.click();
		}
	}
	public String checkIfProductAvailableForPincode() throws InterruptedException
	{
		Thread.sleep(3000);
		String msg=prdct_available_msg.getText();
		System.out.println(msg);
		return msg;
	}
	public void addTocart()
	{
		add_to_cart.click();
	}
	public void clickViewCart()
	{
		view_cart.click();
	}
	public String checkForSelectedSizeInCart() throws InterruptedException
	{
		Thread.sleep(3000);
		String txt=size_in_cart.getText();
		//System.out.println(txt);
		String text[]=txt.split(" ");
		//System.out.println(Arrays.toString(text));
		String size=text[1];
		return size;
	}
	public void removeFromCart()
	{
		remove_from_cart.click();
	}
	public void clickStartShopping()
	{
		start_shopping_btn.click();
	}
}
