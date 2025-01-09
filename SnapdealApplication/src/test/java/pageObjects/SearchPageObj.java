package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageObj extends BaseClass {
	List<String> titles=new ArrayList<String>();
	public SearchPageObj(WebDriver driver)
	{
		super(driver);
	}
	 
	@FindBy(xpath="//*[@class=\"product-title\"]")	List<WebElement> prdct_title;
	
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
	
}
