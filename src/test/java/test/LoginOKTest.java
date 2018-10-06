package test;		

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
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
public class LoginOKTest {		
		//Declaramos constantes
		private WebDriver driver;
		private final String PATH_SCREENSHOTS = "C:\\errorScreenshots\\";
	    private String pathChromeDriver="src\\test\\resources\\chromedriver.exe";
	    
	    //Creamos juego de pruebas
	    @DataProvider(name = "registerFormData")
	    public Object [][] create_dataset1() {
	  	  return new Object[][] {
	  			  {"https://family.qustodio.com/","Qustodio Family Portal",
	  				  "demo11@mailinator.com","ZGVtbzEx",
	  				  "Hola ALFREDO"}
	  	  };
	    }

	     
	    
		/**
		 * Test que crea un usuario de qustodio.
		 * @throws InterruptedException
		 */	    
	    @Test(dataProvider = "registerFormData")			
		public void testLoginFails(String url,String titleToCheck, String nameForm, String passForm, String dashboardName) throws InterruptedException {	
			LoginPage lp = new LoginPage();
	    	//Open Login Page
	    	driver.get(url);  
			
	    	//Check we are where we want
			Assert.assertEquals(lp.title_LoginPage(driver),titleToCheck);

			lp.txtbx_UserName(driver).sendKeys(nameForm);
			lp.txtbx_Password(driver).sendKeys(StringUtils.newStringUtf8(Base64.decodeBase64(passForm)));
			lp.btn_LogIn(driver).click();

			Thread.sleep(2000);

			//Check we are in
			Assert.assertTrue(driver.getPageSource().contains(dashboardName));
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