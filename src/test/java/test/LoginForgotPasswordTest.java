package test;		

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;		
public class LoginForgotPasswordTest extends BaseTest {		
		    
	    //Creamos juego de pruebas
	    @DataProvider(name = "registerFormData")
	    public Object [][] create_dataset1() {
	  	  return new Object[][] {
	  			  {"Qustodio Family Portal",
	  				  "demo11@mailinator1.com","captcha","El código no coincide"}
	  	  };
	    }
	    
		/**
		 * Test que crea un usuario de qustodio.
		 * @throws InterruptedException
		 */	    
	    @Test(dataProvider = "registerFormData")			
		public void testForgotPassword(String titleToCheck, String nameForm, String captchaValue, String errorCaptacha) throws InterruptedException {	
			LoginPage lp = new LoginPage(driver, wait);
	    	//Open Login Page
			lp.goToLoginPage();
			//Check we are where we want
							 
			Assert.assertEquals(lp.title_LoginPage(driver),titleToCheck);
			
			lp.txtbx_UserName(driver).sendKeys(nameForm);
			lp.lnk_LostPassword(driver).click();
			
			lp.txtbx_CaptchaCode(driver).sendKeys(captchaValue);
			lp.btn_ResetPwd(driver).click();
			
			Thread.sleep(1000);
			
			Assert.assertTrue(driver.getPageSource().contains(errorCaptacha));
		}	
	    
	}	