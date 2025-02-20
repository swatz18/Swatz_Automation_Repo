package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects extends BaseClass{
	
	public LoginPageObjects(WebDriver driver) {
		super(driver);
	}
	WebDriver driver;
	 
	@FindBy(xpath="//input[@name='email']") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement passwrd;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]") WebElement errormsg;
	@FindBy(xpath="//h2[text()=\"My Account\"]") WebElement home;
	
	public void setUsername(String un)
	{
		uname.sendKeys(un);
	}
	public void setPassword(String pwd)
	{
		passwrd.sendKeys(pwd);
	}
	public void clickLogin()
	{
		loginbtn.click();
	}
	public String readErrorMessage()
	{
		String msg=errormsg.getText();
		return msg;
	}
	public boolean checkSuccessLogin()
	{
		boolean status=home.isDisplayed();
		return status;
	}
}