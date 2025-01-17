package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
}
