package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;

public class LoginForgotPasswordTest extends BaseTest {

	// Create datasheet
	@DataProvider(name = "registerFormData")
	public Object[][] create_dataset1() {
		return new Object[][] {
				{ "Qustodio Family Portal", "demo11@mailinator1.com", "captcha", "The code doesn't match" } };
	}

	/**
	 *
	 * This test clicks on the Lost Password Link and set an incorrect captcha.We
	 * check captcha error. On DEV environment we should disable captcha to test the
	 * whole functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "registerFormData")
	public void testClickForgotPasswordAndSetWrongCaptcha(String titleLoginPageToCheck, String username,
			String captchaValue, String errorCaptcha) throws InterruptedException {

		LoginPage localPage = new LoginPage(driver);

		localPage.goToLoginPage();

		// Check we are where at LoginPage
		Assert.assertEquals(localPage.getTitlePage(), titleLoginPageToCheck);

		localPage.enterUserName(username);
		localPage.clickLostPasswordLink();
		localPage.enterCaptchaCode(captchaValue);
		localPage.clickResetButton();

		Thread.sleep(1000);

		// Check error captcha
		Assert.assertTrue(driver.getPageSource().contains(errorCaptcha));
	}

}