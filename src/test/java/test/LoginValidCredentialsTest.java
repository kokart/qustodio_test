package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;

public class LoginValidCredentialsTest extends BaseTest {

	// Create datasheet
	@DataProvider(name = "registerFormData")
	public Object[][] create_dataset1() {
		return new Object[][] { { "Qustodio Family Portal", "demo11@mailinator.com", "ZGVtbzEx", "Hola ALFREDO" } };
	}

	/**
	 * This test does a login with valid credentials
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "registerFormData")
	public void testLoginUsingValidCredentials(String titleLoginPageToCheck, String username, String password,
			String dashboardNameToCheck) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.goToLoginPage();

		// Check we are where at LoginPage
		Assert.assertEquals(loginPage.getTitlePage(), titleLoginPageToCheck);

		DashBoardPage dashboardPage = loginPage.enterUserCredentials(username, password);

		Thread.sleep(2000);

		// Check we are in
		Assert.assertTrue(dashboardPage.getSourceCodeOfHTMLPage().contains(dashboardNameToCheck));
	}

}