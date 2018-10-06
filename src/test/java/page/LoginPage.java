package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	//WebElements on the LoginPage. Locators by class, id, name and xpath. We should encourage dev team to add IDS! 
	String usernameName = "email";
	String passwordName = "password";
	String loginButtonId = "login_button";
	String lostPasswordClass = "lost_password_link";
	String needHelpClass = "contact-us";
	String joinButtonXpath = "//*[@id=\"newuser_panel\"]/a/span[1]";

	//Get tittle of the LoginPage
	public String title_LoginPage(WebDriver driver) {
		return driver.getTitle();
	}

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
}
