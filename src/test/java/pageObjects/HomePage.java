package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(linkText = "Register") 
	WebElement registerLink;
	
	@FindBy(xpath = "//a[normalize-space()='Log in']") 
	WebElement login;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']") 
	WebElement logout;

	public void clickRegisterLink() {
		registerLink.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public boolean isLogoutLinkExists()   
	{
		try {
			return (logout.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void clickLogout() {
		logout.click();
	}
	
}
