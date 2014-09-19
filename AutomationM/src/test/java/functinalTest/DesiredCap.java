package functinalTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DesiredCap {
  
	
	@Test
  public void SendToRemote() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		WebDriver selenium = new RemoteWebDriver(new URL("http://10.44.204.232:4444/wd/hub"), dc);
		
		selenium.get("https://wordpress.com/wp-login.php");
		  selenium.findElement(By.id("user_login")).sendKeys("ganeshdeodhe");
		  selenium.findElement(By.id("user_pass")).sendKeys("9049868029@me");
		  selenium.findElement(By.id("wp-submit")).click();
		  
		  Thread.sleep(9000);
		  
		  selenium.quit();
		  
	  
  }
}
