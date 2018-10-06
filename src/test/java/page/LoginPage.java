package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	//WebElements on the LoginPage. Locators by class, id, name and xpath. We should encourage dev team to add IDS! 
	String usernameName = "email";
	String passwordName = "password";
	String loginButtonId = "login_button";
	String captchaCodeId = "captcha_code";
	String resetPasswordId = "reset_password_button";
	String lostPasswordClass = "lost_password_link";
	String needHelpClass = "contact-us";
	String returnLoginLinkClass ="return_to_login_link";
	String joinButtonXpath = "//*[@id=\"newuser_panel\"]/a/span[1]";

	//Global variable
	String baseURL ="https://family.qustodio.com/";
	
	//Return Username field object
	public WebElement txtbx_UserName(WebDriver driver) {
		return driver.findElement(By.name(usernameName));
	}

	//Return Password field object
	public WebElement txtbx_Password(WebDriver driver) {
		return driver.findElement(By.name(passwordName));
	}

	//Return Login button object
	public WebElement btn_LogIn(WebDriver driver) {
		return driver.findElement(By.id(loginButtonId));
	}

	//Return reset password button object
		public WebElement btn_ResetPwd(WebDriver driver) {
			return driver.findElement(By.id(resetPasswordId));
	}
		
	//Return captacha field object
		public WebElement txtbx_CaptchaCode(WebDriver driver) {
			return driver.findElement(By.id(captchaCodeId));
	}

		//Return login link object after click forgot password
		public WebElement lnk_returnLogin(WebDriver driver) {
			return driver.findElement(By.className(returnLoginLinkClass));
		}	
		
		
	//Return lost password link object
	public WebElement lnk_LostPassword(WebDriver driver) {
		return driver.findElement(By.className(lostPasswordClass));
	}

	//Return need help link object
	public WebElement lnk_NeedHelp(WebDriver driver) {
		return driver.findElement(By.className(needHelpClass));
	}

	//Return join qustodio button object
	public WebElement btn_JoinQustodio(WebDriver driver) {
		return driver.findElement(By.xpath(joinButtonXpath));
	}
	//*********Page Methods*********
	 
    //Go to LoginPage
    public void goToLoginPage (){
        driver.get(baseURL);       
    }
    //Get tittle of the LoginPage
  	public String title_LoginPage(WebDriver driver) {
  		return driver.getTitle();
  	}
	
}
