package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
//	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement radioMale;

	@FindBy(xpath = "//input[@id='register-button']")
	WebElement register;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);

	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);

	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);

	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	public void setMale() {
		Actions act = new Actions(driver);
		act.moveToElement(radioMale).click().perform();

	}

	public void clickRegister() {
		register.click();

		// sol2
		// btnContinue.submit();

		// sol3
		// Actions act=new Actions(driver);
		// act.moveToElement(btnContinue).click().perform();

		// sol4
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", btnContinue);

		// Sol 5
		// btnContinue.sendKeys(Keys.RETURN);

		// Sol6
		// WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}

}
