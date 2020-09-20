package com.test.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.google.common.collect.ImmutableMap;
import com.test.qa.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class SwipePage extends TestBase{

	//Click here to visit image landing page
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo")
	MobileElement AmazonLogo;
	
	
	public SwipePage(AppiumDriver<MobileElement> driver) throws IOException {
		  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
		  // TODO Auto-generated constructor stub
	}
	

	public void SwipeImage() throws InterruptedException{
		Thread.sleep(3000);
		AmazonLogo.click();
		Thread.sleep(3000);
		
		Dimension size = driver.manage().window().getSize();
		int startX = (int) (size.width / 0.85);
		int endX = (int) (size.height * 0.25);
		int startY = (int) (size.height * 0.25);
		
		for(int i = 1; i<=4; i++) {
		  TouchAction swipe = new TouchAction(driver)
		            .press(PointOption.point(endX,startY))
		            .moveTo(PointOption.point(startX,startY))
		            .waitAction()
		            .release()
		            .perform();
		System.out.println("Swipe : "+ i);
		}
		
		Thread.sleep(8000);
	}
	
	
	
}
