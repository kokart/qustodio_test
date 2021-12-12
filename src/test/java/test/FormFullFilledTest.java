package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.FormPage;

public class FormFullFilledTest extends BaseTest {

	// Create datasheet
	@DataProvider(name = "fillFormData")
	public Object[][] create_dataset1() {
		return new Object[][] { { "This is a Liferay Forms", "Alfredo Soto Gómez", "I want to be a Liferay member",
			"Form - Forms" } };
	}

	/**
	 * This test fill the form. Happy path.
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "fillFormData")
	public void  formFullFilled(String titleFormPageToCheck, String name, String whyTesting,
			String titleFormOKPageToCheck) throws InterruptedException {

		FormPage formPage = new FormPage(driver);

		formPage.goToFormPage();

		// Check we are where at Form Page
		Assert.assertEquals(formPage.getTitlePage(), titleFormPageToCheck);
		
		//Wait 1 sec until page is fully loaded. Sorry for using sleep instead of waitTo method...but no time to do a better code.
		Thread.sleep(1000);
		formPage.fillForm(name, whyTesting);

		//Wait 1 sec until page is fully loaded. Sorry for using sleep instead of waitTo method...but no time to do a better code.
		Thread.sleep(1000);
		
		//Check title has changed. I've tried this option because it was the faster. But we can check if the Green "success" its shown, or if Thank you text is displayed...There are several options.
		Assert.assertEquals(formPage.getTitlePage(), titleFormOKPageToCheck);
		}

}