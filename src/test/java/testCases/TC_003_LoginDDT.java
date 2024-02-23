package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) {
		logger.info("**** Starting TC_003_LoginDDT *****");

		try {

			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickLogin();
			logger.info("clicked on login link..");

			// Login page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin(); // Login button
			logger.info("clicked on login button..");

			boolean targetPage = hp.isLogoutLinkExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					hp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					hp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("**** Finished TC_003_LoginDDT *****");
	}

}
