package page;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// WebElements on the LoginPage. Locators by class, id, name and xpath. We
	// should encourage dev team to add IDS!
	public final String usernameName = "email";
	public final String passwordName = "password";
	public final String loginButtonId = "login_button";
	public final String captchaCodeId = "captcha_code";
	public final String resetPasswordId = "reset_password_button";
	public final String lostPasswordClass = "lost_password_link";
	public final String needHelocalPageClass = "contact-us";
	public final String returnLoginLinkClass = "return_to_login_link";
	public final String downloadQustodioXpath = "//*[@id=\"newuser_panel\"]/a/span[1]";

	// URL LoginPage
	public final String baseURL = "https://family.qustodio.com/";

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
	public void clickJoinButton() {
		btn_LogIn().click();
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
		clickJoinButton();
		return new DashBoardPage(driver);
	}

	// Click Download Button. Return Home Page
	public HomePage clickDownloadButton() {
		btn_downloadQustodio().click();
		return new HomePage(driver);
	}

	// Click Need HelocalPage Link. Return Need Help Page
	public NeedHelpPage clickNeedHelpLink() {
		lnk_NeedHelocalPage().click();
		return new NeedHelpPage(driver);

	}

}
