package persistent.AutomationM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Wait {
	WebDriver selenium;
  @Test
  public void loginWeb() throws InterruptedException {
	  selenium.get("https://wordpress.com/wp-login.php");
		selenium.findElement(By.id("user_login")).sendKeys("ganeshdeodhe");
		selenium.findElement(By.id("user_pass")).sendKeys("9049868029@me");
		selenium.findElement(By.id("wp-submit")).click();
		selenium.findElement(By.xpath("//*[text()='Posts']")).click();
		selenium.findElement(By.className("add-new-h2")).click();
		selenium.findElement(By.id("title")).sendKeys("My Sixth Post");
		selenium.switchTo().frame("content_ifr");
		selenium.findElement(By.id("tinymce")).sendKeys("Hello All");
		selenium.switchTo().defaultContent();
		selenium.findElement(By.id("publish")).click();
		
		System.out.println("Post Published");
		
		WebDriverWait wait = new WebDriverWait(selenium, 30);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.entry-title"))); 
			System.out.println(element.getText());	
		 		  
  }
  @BeforeTest
  public void beforeTest() {
	 // System.setProperty("webdriver.ie.driver", "c:/driver/IEDriverServer.exe");
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