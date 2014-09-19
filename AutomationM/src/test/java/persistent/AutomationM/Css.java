package persistent.AutomationM;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Css {
	WebDriver selenium;
  @Test
  public void loginWeb() throws InterruptedException {
	  selenium.get("https://wordpress.com/wp-login.php");
		selenium.findElement(By.cssSelector("input#user_login")).sendKeys("ganeshdeodhe");
		selenium.findElement(By.cssSelector("input#user_pass")).sendKeys("9049868029@me");
		selenium.findElement(By.id("wp-submit")).click();
		selenium.findElement(By.xpath("//*[text()='Posts']")).click();
		selenium.findElement(By.className("add-new-h2")).click();
		
		//selenium.findElement(By.cssSelector("a.add-new-h2"));
		//selenium.findElement(By.xpath("/head/body/div/div[3]/div/div/div[3]/h2/a[@class='add-new-h2']"));
		
		selenium.findElement(By.id("title")).sendKeys("My Second Post");
		selenium.switchTo().frame("content_ifr");
		selenium.findElement(By.id("tinymce")).sendKeys("Hello All");
		
		selenium.close();
		Alert alert = selenium.switchTo().alert();
		alert.dismiss();
		selenium.switchTo().defaultContent();
		
		selenium.findElement(By.id("publish")).click();
		
		Thread.sleep(3000);
		 		  
  }
  @BeforeTest
  public void beforeTest() {
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
