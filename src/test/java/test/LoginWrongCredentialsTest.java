package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;

public class LoginWrongCredentialsTest extends BaseTest {

	// Create datasheet
	@DataProvider(name = "registerFormData")
	public Object[][] create_dataset1() {
		return new Object[][] {
				{ "Qustodio Family Portal", "emailMALO@mailinator.com", "ZGVtbzEx", "Invalid email or password" } };
	}

	/**
	 * This test login with wrong credentials to check the error displayed
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "registerFormData")
	public void testLoginUsingWrongCredentials(String titleLoginPageToCheck, String username, String password,
			String errorWrongCredentials) throws InterruptedException {

		LoginPage localPage = new LoginPage(driver);

		localPage.goToLoginPage();

		// Check we are where at LoginPage
		Assert.assertEquals(localPage.getTitlePage(), titleLoginPageToCheck);

		localPage.enterUserName(username);
		localPage.enterUserPassword(password);
		localPage.clickJoinButton();

		Thread.sleep(1000);

		// Check we are in
		Assert.assertTrue(driver.getPageSource().contains(errorWrongCredentials));
	}

}