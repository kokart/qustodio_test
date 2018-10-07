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
				{ "Qustodio Family Portal", "emailMALO@mailinator.com", "ZGVtbzEx", "Correo o contraseña inválidos" } };
	}

	/**
	 * This test login with wrong credentials to check the error displayed
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "registerFormData")
	public void testLoginWrongCredentials(String titleLoginPageToCheck, String username, String password,
			String errorWrongCredentials) throws InterruptedException {

		LoginPage localPage = new LoginPage(driver, wait);

		localPage.goToLoginPage();

		// Check we are where at LoginPage
		Assert.assertEquals(localPage.title_LoginPage(), titleLoginPageToCheck);

		localPage.enterUserCredentials(username, password);

		Thread.sleep(1000);

		// Check we are in
		Assert.assertTrue(driver.getPageSource().contains(errorWrongCredentials));
	}

}