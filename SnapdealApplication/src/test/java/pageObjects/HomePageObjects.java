package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends BaseClass {
	
	public HomePageObjects(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//img[@title=\"Snapdeal\"]")	WebElement logo;
	@FindBy(id="inputValEnter")	WebElement search_bar;
	@FindBy(xpath="//*[contains(@class,\"searchformButton\")]")	WebElement search_icon; 
	
	public boolean isLogoPresent()
	{
		boolean result=logo.isDisplayed();
		return result;
	}
	public void inputSearchBar(String value)
	{
		search_bar.click();
		search_bar.sendKeys(value);
	}
	public void clickSearchIcon()
	{
		search_icon.click();
	}
}
