package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;

public class LoginDownloadQustodioLinkTest extends BaseTest {

	// Create datasheet
	@DataProvider(name = "registerFormData")
	public Object[][] create_dataset1() {
		return new Object[][] { { "Qustodio Family Portal", "Download Qustodio - Qustodio" } };
	}

	/**
	 *
	 * This test clicks on the Download button and check if we are where we expect
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "registerFormData")
	public void testClickDownloadButtonOnLoginPage(String titleLoginPageToCheck, String tittleHomePageToCheck)
			throws InterruptedException {

		LoginPage localPage = new LoginPage(driver);

		localPage.goToLoginPage();

		// Check we are where at LoginPage
		Assert.assertEquals(localPage.title_LoginPage(), titleLoginPageToCheck);

		HomePage homepage = localPage.clickDownloadButton();

		homepage.changeChromeTab(1);
		Thread.sleep(1212);

		// Ckeck we are in
		Assert.assertEquals(homepage.title_HomePagee(), tittleHomePageToCheck);

	}

}