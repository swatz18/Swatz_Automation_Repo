package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import factory.Base;

public class cartPageObj extends BaseClass {
	
	public cartPageObj(WebDriver driver) {
		super(driver);
	}
	Actions a=new Actions(Base.getDriver());
	JavascriptExecutor js=(JavascriptExecutor) Base.getDriver();
	
	@FindBy(xpath="//input[@placeholder=\"Enter your email\"]")	WebElement loginPopup;
	@FindBy(xpath="//div[@class=\"popup_header\"]//*[name()=\"svg\"]")	WebElement popupClose;
	@FindBy(linkText="Sanitary Napkins")	WebElement napkins;
	@FindBy(xpath="//*[@for=\"Filter-Size-2\"]//*[name()=\"svg\"]")	WebElement sizeXL;
	@FindBy(linkText="Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free")	WebElement productName;
	@FindBy(xpath="//span[contains(text(),\"Select options\")]")	WebElement select;
	@FindBy(xpath="//*[@data-value=\"Pack Of 3\"]")	WebElement pack3;
	@FindBy(xpath="//button[@data-atc-text=\"Add to cart\"]")	WebElement addToCart;
	@FindBy(xpath="//button[contains(@aria-label,\"Increase quantity\")]")	WebElement increaseQuantity;
	@FindBy(xpath="//h4[contains(text(),\"Congrats!\")]")	WebElement freeShipping;
	@FindBy(xpath="//div[@class=\"gokwik-checkout\"]/button")	WebElement checkout;
//	@FindBy(xpath="//*[@data-type=\"min-range\"]")	WebElement sliderMin;
//	@FindBy(xpath="//*[@data-type=\"max-range\"]")	WebElement sliderMax;
//	@FindBy(xpath="//div[contains(@class,\"summary-title\")]")	WebElement summaryArrow;
	@FindBy(xpath="//*[@data-type=\"max-input\"]")	WebElement maxInput;
	@FindBy(xpath="//*[@class=\"m-cart-drawer__items\"]//child::a[contains(text(),\"XL Fluffy\")]")	WebElement productInCart;
	@FindBy(id="phone-input")	WebElement phonenum;
	
	public boolean loginPopupVisible()
	{
		boolean popup=loginPopup.isDisplayed();
		return popup;
	}
	public void popupClose()
	{
		popupClose.click();
	}
	public void napkinsTab()
	{
		napkins.click();
	}
	public void selectSize()
	{
		sizeXL.click();
	}
	public boolean selectProduct()
	{
		boolean prdct=productName.isDisplayed();
		return prdct;
	}
	public void selectOptions()
	{
		select.click();
	}
	public void selectpack()
	{
		pack3.click();
	}
	public void addToCart()
	{
		addToCart.click();
	}
	public void addQuantity()
	{
		increaseQuantity.click();
	}
	public void checkout()
	{
		checkout.click();
	}
	public boolean checkForFreeShipping()
	{
		boolean res=freeShipping.isDisplayed();
		return res;
	}
//	public void sliderMax() throws InterruptedException
//	{
//		System.out.println(sliderMax.getLocation().getX());
//		a.dragAndDropBy(sliderMax,-30,0).perform();
//		Thread.sleep(3000);
//	}
//	public void sliderMin() throws InterruptedException
//	{
//		System.out.println(sliderMin.getLocation().getX());
//		a.dragAndDropBy(sliderMin,30,0).perform();
//		Thread.sleep(3000);
//	}
	public void sendMaxInput()
	{
		maxInput.sendKeys("1000");
	}
	public String checkForProductNameInCart()
	{
		String name=productInCart.getText();
		System.out.println(name);
		return name;
	}
//	public void clickSummaryArrow()
//	{
//		js.executeScript("arguments[0].click();", summaryArrow);
//	}
	public void clickMobile()
	{
		phonenum.sendKeys("7502131997");
	}
}
