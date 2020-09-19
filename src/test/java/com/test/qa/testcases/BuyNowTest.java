package com.test.qa.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.BuyNowPage;

public class BuyNowTest extends TestBase{
	BuyNowPage buyNowPage;
	
	
	public BuyNowTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		buyNowPage = new BuyNowPage(driver);
		
	}		

	@Test
	public void buyTV() throws InterruptedException{
		buyNowPage.SearchTV();
		buyNowPage.isHomebuttonDisplayed();		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}