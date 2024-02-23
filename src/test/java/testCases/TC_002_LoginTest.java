package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"sanity", "master"})
	public void verify_login() {
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickLogin();
			logger.info("clicked on login link..");

			// Login page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin(); // Login button
			logger.info("clicked on login button..");

			// My Account Page
//		MyAccountPage macc=new MyAccountPage(driver);

			boolean targetPage = hp.isLogoutLinkExists();

			Assert.assertEquals(targetPage, true, "Login failed");
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
