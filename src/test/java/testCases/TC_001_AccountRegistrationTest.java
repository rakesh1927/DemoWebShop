package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"master", "regression"})
	public void verify_account_registration() {
		logger.info("**** starting TC_001_AccountRegistrationTest  *****");

		try {
			HomePage hp = new HomePage(driver);

			hp.clickRegisterLink();
			logger.info("Clicked on registration link");

			logger.info("Entering customer details.. ");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email

			String password = randomAlphaNumeric();

			regpage.setPassword(password);

			regpage.setMale();
			regpage.clickRegister();
			logger.info("clicked on register..");

		} catch (Exception e) {
			logger.error("test failed..");

		}

		logger.info("**** finished TC_001_AccountRegistrationTest  *****");

	}

}
