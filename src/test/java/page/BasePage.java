package page;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// Change to desired Tab
	public void changeChromeTab(int tabSelected) {
		// Swap Chrome tab. New window is opened when Join Button is clicked
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		if (!availableWindows.isEmpty()) {
			driver.switchTo().window(availableWindows.get(tabSelected));
		}

	}

	// Get Source Code of the Web Page
	public String getSourceCodeOfHTMLPage() {
		return driver.getPageSource();
	}
}