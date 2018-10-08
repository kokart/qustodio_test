package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;
	public String PATH_SCREENSHOTS = null;

	// Data for local testing
	public final String PATH_CHROMEDRIVER = "src\\test\\resources\\chromedriver.exe";
	public final String FILE_TO_CHECK = "src\\test\\resources\\local";
	public final String PATH_LOCAL_SCREENSHOTS = "target\\surefire-reports\\";

	// Data to use Testing bot
	public final String KEY = System.getenv().get("KEY_TESTINGBOT");
	public final String SECRET = System.getenv().get("SECRET_TESTINGBOT");
	public final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
	public final String PATH_REMOTE_SCREENSHOTS = "target/surefire-reports/";

	/**
	 * Launch Chrome using TestBot
	 * 
	 * @throws MalformedURLException
	 */
	@BeforeClass
	public void setup() throws MalformedURLException {

		// Use localDriver or RemoteDriver.
		if (new File(FILE_TO_CHECK).exists()) {
			System.setProperty("webdriver.chrome.driver", PATH_CHROMEDRIVER);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else {
			DesiredCapabilities capabillities = new DesiredCapabilities();
			capabillities.setCapability("platform", "WIN7");
			capabillities.setCapability("version", "69");
			capabillities.setCapability("browserName", "chrome");
			driver = new RemoteWebDriver(new URL(URL), capabillities);
		}
	}

	/**
	 * Close Chrome
	 */
	@AfterClass
	public void teardown() {
		driver.quit();
	}

	/**
	 * If test fails we get a schreenshot and it's stored at PATH_SCREENSHOTS.
	 * 
	 * @param testResult
	 * @throws IOException
	 */
	@AfterMethod

	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {

		// Choose the correct path to store screenshots depending if you are using local
		// or remote
		PATH_SCREENSHOTS = new File(FILE_TO_CHECK).exists() ? PATH_LOCAL_SCREENSHOTS : PATH_REMOTE_SCREENSHOTS;
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(PATH_SCREENSHOTS + "SCREEN_ERROR" + testResult.getName() + ".png"));
		}

	}
}
