package functinalTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.DashboardClass;
import pageobject.Loginclass;
import pageobject.SettingClass;

public class UpdateSettingTest {
	
	WebDriver selenium;
	Loginclass l;
	DashboardClass d;
	SettingClass s;
	
  @Test
  public void updateSettings() throws InterruptedException {
	  selenium.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  
	  selenium.get("https://wordpress.com/wp-login.php");
	 
	  l = PageFactory.initElements(selenium, Loginclass.class);
	  d = l.Login("ganeshdeodhe", "9049868029@me");
	
			
	  s = d.clickSetting();
	  s.updateSetting();
	  Thread.sleep(4000);
  }
  
  @BeforeTest
  public void beforeTest() {
	  //System.setProperty("webdriver.ie.driver", "c:/driver/IEDriverServer.exe");
	selenium=new FirefoxDriver();
	System.out.println("FireFox object created");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Closing FireFox");
	  selenium.close();
	  selenium.quit();
  }

}
