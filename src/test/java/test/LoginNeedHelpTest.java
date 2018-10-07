package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;
import page.NeedHelpPage;

public class LoginNeedHelpTest extends BaseTest {

	// Create datasheet
	@DataProvider(name = "registerFormData")
	public Object[][] create_dataset1() {
		return new Object[][] { { "Qustodio Family Portal", "Qustodio Help Center - Qustodio" }

		};
	}

	/**
	 * This test click on need help link.
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "registerFormData")
	public void testClickNeedHelpLink(String titleLoginPageToCheck, String titleHomePageToCheck)
			throws InterruptedException {

		LoginPage localPage = new LoginPage(driver);

		localPage.goToLoginPage();

		// Check we are where at LoginPage
		Assert.assertEquals(localPage.getTitlePage(), titleLoginPageToCheck);

		NeedHelpPage needHelpPage = localPage.clickNeedHelpLink();

		needHelpPage.changeChromeTab(1);

		// Check we are at Need Help Page
		Assert.assertEquals(needHelpPage.getTitlePage(), titleHomePageToCheck);

	}

}