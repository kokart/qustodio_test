package test;		

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;		
public class LoginNeedHelpTest {		
		//Global values
		private WebDriver driver;
		private final String PATH_SCREENSHOTS = "C:\\errorScreenshots\\";
	    private String pathChromeDriver="src\\test\\resources\\chromedriver.exe";
	    	    
	    //Create datasheet
	    @DataProvider(name = "registerFormData")
	    public Object [][] create_dataset1() {
	  	  return new Object[][] {
	  			  {"https://family.qustodio.com/","Qustodio Family Portal",
	  				   "Qustodio Help Center - Qustodio"}
	  			  
	  	  };
	    }
	    
		/**
		 * Download Qustodio application link is redirecting to Qustodio webPAge
		 * @throws InterruptedException
		 */	    
	    @Test(dataProvider = "registerFormData")			
		public void testLoginNeedHelp(String url,String titleToCheck, String tittleHomePage) throws InterruptedException {	
			LoginPage lp = new LoginPage();	    	
	    	//Open Login Page
	    	driver.get(url);  
			
	    	//Check we are where we want 	    	
							 
			Assert.assertEquals(lp.title_LoginPage(driver),titleToCheck);

			lp.lnk_NeedHelp(driver).click();
						
			ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles()); 
			if (!availableWindows.isEmpty()) { 
			driver.switchTo().window(availableWindows.get(1)); 
			}
			
					
			Assert.assertTrue(driver.getTitle().contains(tittleHomePage));
								
		}	
	    
	    /*
	     * Inicializamos ChromeDriver indicando la ruta del driver
	     */
		@BeforeTest
		public void beforeTest() {	
			System.setProperty("webdriver.chrome.driver", pathChromeDriver );
			 driver = new ChromeDriver();
			
		}		
		
		/*
	     * Cerramos Chrome
	     */
		@AfterTest
		public void afterTest() {
			driver.quit();
		}		
		
		/*
	     * Sacamos captura de pantalla si el test ha fallado
	     */
		@AfterMethod 
		public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
			if (testResult.getStatus() == ITestResult.FAILURE)  { 
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
				FileUtils.copyFile(scrFile, new File(PATH_SCREENSHOTS + testResult.getName() + "-" 
						+  ".png"));
			} 
		}
		
		
}	