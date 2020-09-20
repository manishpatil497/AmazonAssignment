package com.test.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.qa.util.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class TestBase {
	
	public static Properties prop;
	public static AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/test"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() throws MalformedURLException{
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName",prop.getProperty("deviceName"));
			caps.setCapability("udid", prop.getProperty("udid")); 
			caps.setCapability("platformName",prop.getProperty("Android"));
			caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
			
			caps.setCapability("skipUnlock",  prop.getProperty("skipUnlock"));
			caps.setCapability("appPackage", prop.getProperty("appPackage"));
			caps.setCapability("appActivity", prop.getProperty("appActivity"));
			caps.setCapability("noReset", prop.getProperty("noReset"));
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		}
	}	