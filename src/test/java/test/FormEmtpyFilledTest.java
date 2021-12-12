package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.FormPage;

public class FormEmtpyFilledTest extends BaseTest {

	// Create datasheet
	@DataProvider(name = "emptyFormData")
	public Object[][] create_dataset1() {
		return new Object[][] { { "This is a Liferay Forms","This field is required."} };
	}

	/**
	 * This test check all fields are mandatory.
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "emptyFormData")
	public void formEmtpyFilled(String titleFormPageToCheck, String errorTextToCheck) throws InterruptedException {

		FormPage formPage = new FormPage(driver);

		formPage.goToFormPage();

		// Check we are where at Form Page
		Assert.assertEquals(formPage.getTitlePage(), titleFormPageToCheck);
		
		//Wait 1 sec until page is fully loaded. Sorry for using sleep instead of waitTo method...but no time to do a better code.
		Thread.sleep(1000);
		formPage.submitClick();

		//Wait 1 sec until errores are loaded. Sorry for using sleep instead of waitTo method...but no time to do a better code.
		Thread.sleep(1000);
		
		//All fields are required,so a message should be displayed in each field. Furthermore, at the end we check that we are still on the same Form Page.
		Assert.assertEquals(formPage.getErrorTextNameField(), errorTextToCheck);
		Assert.assertEquals(formPage.getErrorTextDOBField(), errorTextToCheck);
		Assert.assertEquals(formPage.getErrorTextWhyTestingField(), errorTextToCheck);
		Assert.assertEquals(formPage.getTitlePage(), titleFormPageToCheck);
		}

}