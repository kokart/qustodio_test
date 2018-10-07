package page;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// WebElements on the LoginPage. Locators by class, id, name and xpath. We
	// should encourage dev team to add IDS!
	String usernameName = "email";
	String passwordName = "password";
	String loginButtonId = "login_button";
	String captchaCodeId = "captcha_code";
	String resetPasswordId = "reset_password_button";
	String lostPasswordClass = "lost_password_link";
	String needHelocalPageClass = "contact-us";
	String returnLoginLinkClass = "return_to_login_link";
	String downloadQustodioXpath = "//*[@id=\"newuser_panel\"]/a/span[1]";

	// URL LoginPage
	String baseURL = "https://family.qustodio.com/";

	// Return Username field object
	public WebElement txtbx_UserName() {
		return driver.findElement(By.name(usernameName));
	}

	// Return Password field object
	public WebElement txtbx_Password() {
		return driver.findElement(By.name(passwordName));
	}

	// Return Login button object
	public WebElement btn_LogIn() {
		return driver.findElement(By.id(loginButtonId));
	}

	// Return reset password button object
	public WebElement btn_ResetPwd() {
		return driver.findElement(By.id(resetPasswordId));
	}

	// Return captacha field object
	public WebElement txtbx_CaptchaCode() {
		return driver.findElement(By.id(captchaCodeId));
	}

	// Return login link object after click forgot password
	public WebElement lnk_returnLogin() {
		return driver.findElement(By.className(returnLoginLinkClass));
	}

	// Return lost password link object
	public WebElement lnk_LostPassword() {
		return driver.findElement(By.className(lostPasswordClass));
	}

	// Return need helocalPage link object
	public WebElement lnk_NeedHelocalPage() {
		return driver.findElement(By.className(needHelocalPageClass));
	}

	// Return join qustodio button object
	public WebElement btn_downloadQustodio() {
		return driver.findElement(By.xpath(downloadQustodioXpath));
	}
	// *********Page Methods*********

	// Go to LoginPage
	public void goToLoginPage() {
		driver.get(baseURL);
	}

	// Get tittle of the LoginPage
	public String title_LoginPage() {
		return driver.getTitle();
	}

	// Fill Username field
	public void enterUserName(String username) {
		txtbx_UserName().sendKeys(username);
	}

	// Fill Password field
	public void enterUserPassword(String password) {
		txtbx_Password().sendKeys(StringUtils.newStringUtf8(Base64.decodeBase64(password)));
	}

	// Fill captcha code
	public void enterCaptchaCode(String captchaValue) {
		txtbx_CaptchaCode().sendKeys(captchaValue);
	}

	// Click Join button
	public DashBoardPage clickJoinButton() {
		btn_LogIn().click();
		return new DashBoardPage(driver, wait);
	}

	// Click Lost Password Link
	public void clickLostPasswordLink() {
		lnk_LostPassword().click();

	}

	// Click Reset Button
	public void clickResetButton() {
		btn_ResetPwd().click();
	}

	// Fill username and password and click Login. Return DashBoard Page
	public DashBoardPage enterUserCredentials(String username, String password) {
		enterUserName(username);
		enterUserPassword(password);
		return clickJoinButton();
	}

	// Click Download Button. Return Home Page
	public HomePage clickDownloadButton() {
		btn_downloadQustodio().click();
		return new HomePage(driver, wait);
	}

	// Click Need HelocalPage Link. Return Need Help Page
	public NeedHelpPage clickNeedHelpLink() {
		lnk_NeedHelocalPage().click();
		return new NeedHelpPage(driver, wait);

	}

}
