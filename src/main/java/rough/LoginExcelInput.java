package rough;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;
import com.test.qa.util.ExcelUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginExcelInput extends TestBase{

	//Page Factory
		@AndroidFindBy(id="sign_in_button")
		MobileElement signinBtn;
		
		@AndroidFindBy(xpath="//android.widget.EditText[1]")
		MobileElement EmailId;
		
		@AndroidFindBy(xpath="//android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")
		MobileElement Signin_ContinueBtn;
		
		@AndroidFindBy(xpath="//android.view.View[5]/android.view.View[2]/android.widget.EditText")
		MobileElement password;
		
		@AndroidFindBy(xpath="//android.view.View[5]/android.view.View[6]/android.widget.Button")
		MobileElement Signin_submitBtn;
		
		@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo")
		MobileElement amazonLogo;
		
		@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Home']")
		MobileElement amazonLogoXpath;

		@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon")
		MobileElement MenuBtn;
		
		@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Navigation panel, button, double tap to open side panel\"]")
		MobileElement MenuBtnXpath;
		
		
		
		//Initializing the Page Objects:
		public LoginExcelInput(AppiumDriver<MobileElement> driver) throws IOException {
			  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			  
			  // TODO Auto-generated constructor stub
		}
		
		//Actions:
		public void login() throws Exception{
			
			String sUserName = ExcelUtils.getCellData(1, 1);
			String sPassword = ExcelUtils.getCellData(1, 2);
			System.out.println("username : "+ sUserName);
			
			Thread.sleep(3000);
			signinBtn.click();
			Thread.sleep(3000);
			
			EmailId.sendKeys(sUserName);
			Thread.sleep(3000);
			Signin_ContinueBtn.click();
			Thread.sleep(3000);
			
			password.sendKeys(sPassword);
			Thread.sleep(3000);
			
			Signin_submitBtn.click();
			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_home")).click();
			
			Thread.sleep(25000);
		}
}
