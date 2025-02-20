package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObj extends BaseClass{
	String msg;
	public LoginPageObj(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="login_Layer")	WebElement	login; 
	@FindBy(xpath="//*[contains(@placeholder,\"Username\")]")	WebElement	username;
	@FindBy(xpath="//*[contains(@placeholder,\"password\")]")	WebElement	password;
	@FindBy(xpath="//button[text()=\"Login\"]")	WebElement	login_btn;
	@FindBy(xpath="//div[contains(@class,\"server-err\")]")	WebElement	alert_msg;
	@FindBy(xpath="//img[@alt=\"Naukri Logo\"][1]")	WebElement	logo;
	
	
	public void selectLogin()
	{
		login.click();
	}
	public void enterCredentials(String un, String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
	}
	public void selectLoginButton()
	{
		login_btn.click();
	}
	public String verifyAlertMessage()
	{
		boolean res=alert_msg.isDisplayed();
		if(res)
		{
			msg=alert_msg.getText();
		}
		return msg;
	}
	public boolean verifyLogoIsPresent()
	{
		boolean res=logo.isDisplayed();
		return res;
	}
}
