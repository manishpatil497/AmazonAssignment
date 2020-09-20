package com.test.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.google.common.collect.ImmutableMap;
import com.test.qa.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BuyNowPage extends TestBase{

	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo")
	MobileElement AmazonLogo;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout/android.widget.EditText")
	MobileElement SearchBox;
	
	@AndroidFindBy(id="rs_search_src_text")
	MobileElement SearchBar;
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_count")
	MobileElement cartIcon;
		
	
	//Initializing the Page Objects:
	public BuyNowPage(AppiumDriver<MobileElement> driver) throws IOException {
		  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  
		  // TODO Auto-generated constructor stub
	}
	
	//Actions:
	public void SearchTV() throws InterruptedException{
		Thread.sleep(3000);
		//home page refresh
		AmazonLogo.click();
		logger.debug("Refreshed home page");
		Thread.sleep(3000);
		
		//cicking on search button
		SearchBox.click();
		Thread.sleep(3000);
		
		//Entering search item
		SearchBar.sendKeys("65-inch TV");
		
		//Clicking on enter button
		((RemoteWebDriver) driver).executeScript("mobile: performEditorAction",
				ImmutableMap.of("action", "search"));
		System.out.println("Clicked on Enter button");
		
		Thread.sleep(6000);
		
		//scrolling to SonyX800H TV
		String SonyX800H = "Sony X800H";
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ SonyX800H + "\").instance(0))")
				.click();
		System.out.println("Sony X800H found <3 ");
		Thread.sleep(5000);
		
		//Getting product description from product page
		MobileElement PPDescription = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Sony X800H 65" + "\").instance(0))");
		String prdPageDrecription = PPDescription.getText();
		System.out.println("Product Description from product page : " + prdPageDrecription);
		Thread.sleep(5000);
		
		MobileElement PriceOnProductPage = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "998" + "\").instance(0))");
		String PriceOnProductPage1 = PriceOnProductPage.getText();
		System.out.println("Product price on Product page : " + PriceOnProductPage1);
		Thread.sleep(5000);

		String str = "Add to Cart";
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ str + "\").instance(0))")
				.click();
		System.out.println("TV added to cart");
		Thread.sleep(8000);
		
		cartIcon.click();
		Thread.sleep(8000);
		
		MobileElement Description_AtCart = driver.findElement(
				MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + "Sony X800H" + "\")"));
		String Description_Atcart1 = Description_AtCart.getText();
		System.out.println("ProductDescription_OncartPage1 : " + Description_Atcart1);

		List<MobileElement> List_ProductPrice_onCartPage = driver
				.findElements(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + "$" + "\")"));
		String ProductPrice_onCartPage = List_ProductPrice_onCartPage.get(1).getText();
		System.out.println(ProductPrice_onCartPage);

		Thread.sleep(10000);
		// Delete
		MobileElement DeleteItemsFromCart = driver
				.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + "Delete" + "\")"));
		DeleteItemsFromCart.click();
		
	}
	
	public void isHomebuttonDisplayed() {
		
	}
}
