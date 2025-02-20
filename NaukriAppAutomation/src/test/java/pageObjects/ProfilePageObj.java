package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageObj extends BaseClass{
	String msg;
	public ProfilePageObj(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(partialLinkText="View")	WebElement	view_profile_button; 
	@FindBy(xpath="//*[@id=\"_nj1mrmev4Navbar\"]/div")	WebElement	chat_close;
	@FindBy(xpath="//div[contains(@class,\"quickLink \")]//span[contains(.,\"Career profile\")]")	WebElement	carrer_profile_link;
	@FindBy(xpath="//div[@id=\"lazyDesiredProfile\"]//span[contains(.,\"editOneTheme\")]")	WebElement	carrer_profile_edit;
	@FindBy(id="desiredProfileForm")	WebElement	carrer_profile_form;
	@FindBy(id="locationSugg")	WebElement	location_preference;
	@FindBy(xpath="//*[text()=\"Chennai\"]/i")	WebElement	location_add;
	@FindBy(id="saveDesiredProfile")	WebElement	cp_save_button;
	@FindBy(xpath="//div[@class=\"mod-date\"]/span[contains(.,\"Today\")]")	WebElement	last_profile_update_status;
	@FindBy(xpath="//span[contains(text(),\"Preferred work\")]")	WebElement location_label;
	@FindBy(xpath="//a[text()='Update']")	WebElement update_link;
	@FindBy(xpath="//div[contains(@class,\"resume-name\")]/div") WebElement resume_name;
	
	public void clickViewProfile()
	{
		view_profile_button.click();
	}
	public void clickUpdateLink()
	{
		update_link.click();
	}
	public void uploadResume()
	{
		update_link.sendKeys("E:/Swathi M S Documents/FResume.pdf");
	}
	public String validateResumeName()
	{
		String name=resume_name.getText();
		return name;
	}
	
	public void closeChat()
	{
		boolean res=chat_close.isDisplayed();
		
		if(res)
		chat_close.click();
	}
	public void clickCarrerProfile()
	{
		carrer_profile_link.click();
	}
	public void editCarrerProfile()
	{
		carrer_profile_edit.click();
	}
	public String verifyProfileUpdateStatus()
	{
		
	    msg=last_profile_update_status.getText();
		return msg;
	}
	public boolean verifyFormIsPresent()
	{
		boolean res=carrer_profile_form.isDisplayed();
		return res;
	}
	public void clickLocationLabel()
	{
		location_label.click();
		
	}
	public void clickForLocation()
	{
		location_preference.click();
	}
	public void clickcpSaveButton()
	{
		cp_save_button.click();
	}
	public void addLocation()
	{
		location_add.click();
	}
	public boolean isLocationSelected()
	{
		boolean isSelected=location_add.isSelected();
		return isSelected;
	}
	
	
}
