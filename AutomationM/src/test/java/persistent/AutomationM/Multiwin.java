package persistent.AutomationM;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class Multiwin {
	WebDriver selenium;
  @Test
  public void loginWeb() throws InterruptedException {
	  selenium.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  
	  selenium.get("https://wordpress.com/wp-login.php");
		selenium.findElement(By.id("user_login")).sendKeys("ganeshdeodhe");
		selenium.findElement(By.id("user_pass")).sendKeys("9049868029@me");
		selenium.findElement(By.id("wp-submit")).click();
		selenium.findElement(By.cssSelector("span.ab-display-name")).click();
		selenium.findElement(By.cssSelector("li.my-sites a")).click();
		//selenium.findElement(By.xpath("html.js body.logged-in div#page.hfeed div#main.main div#tab-content.in div#my-blogs-plus.tab ul.blogs li div.blog-head div.blog-title h3 a")).click();
		selenium.findElement(By.xpath("//*[text()='Dashboard']"));
		Set <String> handles = selenium.getWindowHandles();
		 		  for (String s :handles){
		 			  System.out.println(s);
		 		  }
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
