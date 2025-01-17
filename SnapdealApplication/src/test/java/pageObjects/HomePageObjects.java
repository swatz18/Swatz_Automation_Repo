package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends BaseClass {
	
	public HomePageObjects(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//img[@title=\"Snapdeal\"]")	WebElement logo;
	@FindBy(id="inputValEnter")	WebElement search_bar;
	@FindBy(xpath="//*[contains(@class,\"searchformButton\")]")	WebElement search_icon; 
	@FindBy(xpath="//span[contains(.,\"Women's Fashion\")]//parent::a")	 WebElement womens_fashion;
	@FindBy(xpath="//span[contains(.,\"Kurtas & Kurtis\")]")	WebElement kurta_kurti;
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
	 public void clickWomensfashion()
	 {
		Actions a= new Actions(driver);
		a.moveToElement(womens_fashion).moveToElement(kurta_kurti).click().perform();
	 }
}
