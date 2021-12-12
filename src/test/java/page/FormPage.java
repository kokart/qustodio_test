package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage extends BasePage {

	public FormPage(WebDriver driver) {
		super(driver);
	}

	// WebElements on the Form Page. Locators by CssSelector, id, and xpath. We
	// should encourage dev team to add IDS for QA. 

	//Language buttons
	//private final String flagLanguageButtonCsSelector=".btn-section";
	//private final String flagChangeLanguageButtonCssSelector=".btn-.taglib-text-icon";

	//Form field
	private final String nameFieldXpath ="//input[@class='form-control ddm-field-text']";
	private final String dobPickerCssSelector =".lexicon-icon-calendar > use";
	private final String whyFieldCssSelector =".col-md-12 > .ddm-field-container .ddm-field-text";

	//Submit button
	private final String submitButtonID="ddm-form-submit";

	// URL FormPage
	public final String baseURL = "https://forms.liferay.com/web/forms/shared/-/form/122548";


	//We avoid implementation of methods to change language. Same behaviour as form fields.

	// Return name Field object
	public WebElement txtbx_name() {
		return driver.findElement(By.xpath(nameFieldXpath));			
	}

	// Return dob datapicker object
	public WebElement txtbx_dob() {
		return driver.findElement(By.cssSelector(dobPickerCssSelector));
	}

	// Return Why Testing Field object
	public WebElement txtbx_whyTesting() {
		return driver.findElement(By.cssSelector(whyFieldCssSelector));
	}

	// Return submit button object
	public WebElement btn_Submit() {
		return driver.findElement(By.id(submitButtonID));
	}

	//Obtain object which contains error text. I've decided to have one method for each following the same pattern as before, one method for each element.

	//Return name error object
	public WebElement findErrorNameField() {
		return 	driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item"));
	}

	//Return dob error object
	public WebElement findErrorDOBField() {
		return 	driver.findElement(By.cssSelector(".form-feedback-group:nth-child(7) > .form-feedback-item"));
	}

	//Return whytesting error object
	public WebElement findErrorWhyTestingField() {
		return 	driver.findElement(By.cssSelector(".col-md-12 > .ddm-field-container .form-feedback-item"));
	}

	// *********Page Methods*********
	// we avoid methods to change language. out of scope.

	// Go to Form Page
	public void goToFormPage() {
		driver.get(baseURL);
	}

	//Set a text on name field
	public void setNameField(String username) {
		txtbx_name().sendKeys(username);
	}

	//Choose a hardcoded data. We have to implement an extense method to allow choose the desired data. 
	public void setDOBField() {
		txtbx_dob().click();
		driver.findElement(By.cssSelector(".date-picker-date-row:nth-child(4) > .date-picker-col:nth-child(3) > .date-picker-date")).click();
	}

	//Set a text on why testing field
	public void setWhyTestingField(String username) {
		txtbx_whyTesting().sendKeys(username);
	}

	//Click on submit button
	public void submitClick() {
		btn_Submit().click();
	}

	//Fill full form
	public void fillForm (String username, String whyTesting) {
		setNameField(username);
		setDOBField();
		setWhyTestingField(whyTesting);
		submitClick();
	}

	//Get text from an empty name field	
	public String getErrorTextNameField() {
		return findErrorNameField().getText();	
	}

	//Get text from an empty dob field
	public String getErrorTextDOBField() {
		return findErrorNameField().getText();	
	}

	//Get text from an empty why testing field
	public String getErrorTextWhyTestingField() {
		return findErrorNameField().getText();	
	}
}
