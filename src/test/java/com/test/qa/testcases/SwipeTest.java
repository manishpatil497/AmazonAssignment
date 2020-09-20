package com.test.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.BuyNowPage;
import com.test.qa.pages.SwipePage;

public class SwipeTest  extends TestBase{
	SwipePage swipeHome;
	
	
	public SwipeTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		swipeHome = new SwipePage(driver);
		
	}		
	
	@Test
	public void buyTV() throws InterruptedException{
		//Swipe on home page
		swipeHome.SwipeImage();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
}
