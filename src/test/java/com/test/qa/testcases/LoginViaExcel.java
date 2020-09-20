package com.test.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.LoginExcelInput;
import com.test.qa.pages.LoginPage;

public class LoginViaExcel extends TestBase{
	
	LoginExcelInput LoginExcelInput;
	

	public LoginViaExcel(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		LoginExcelInput = new LoginExcelInput(driver);
		
	}
	
	/*
	 * @Test(priority=1) public void loginPageTitleTest(){ String title =
	 * loginPage.validateLoginPageTitle(); Assert.assertEquals(title,
	 * "#1 Free CRM for Any Business: Online Customer Relationship Software"); }
	 * 
	 */
	
	@Test
	public void amazonLogin() throws Exception{
		LoginExcelInput.login();
		Thread.sleep(10000);
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
