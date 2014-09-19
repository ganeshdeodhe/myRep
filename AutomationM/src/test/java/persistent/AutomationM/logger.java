package persistent.AutomationM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Date;
import java.util.Properties;

public class logger {
	WebDriver selenium;
	
	public static Logger log = Logger.getLogger(logger.class);
	
	
  @Test
  public void loginWeb() throws InterruptedException, IOException {
	  
	  DOMConfigurator.configure("log4j.xml");
	  
	  
	  selenium.get("https://wordpress.com/wp-login.php");
	  log.info("Page Loaded");
	  selenium.findElement(By.id("user_login")).sendKeys("ganeshdeodhe");
	  selenium.findElement(By.id("user_pass")).sendKeys("9049868029@me");
	  selenium.findElement(By.id("wp-submit")).click();
	  log.info("Submitted Crendential");
	  log.debug("my Debgug - Submitted Crendential");
		File scr= ((TakesScreenshot)selenium).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./scrshot.png"));
		
		log.info("Screen shot taken");
		log.debug("my Debgug - Screen shot taken");
		
		selenium.findElement(By.xpath("//*[text()='Posts']")).click();
		selenium.findElement(By.className("add-new-h2")).click();
		
		selenium.findElement(By.id("title")).sendKeys("My Third Post");
		
		scr= ((TakesScreenshot)selenium).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./scrshot1.png"));
		
		selenium.switchTo().frame("content_ifr");
		selenium.findElement(By.id("tinymce")).sendKeys("Hello All");
		selenium.switchTo().defaultContent();
		selenium.findElement(By.id("publish")).click();
		scr= ((TakesScreenshot)selenium).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./scrshot2.png"));
		
				
		 		  
  }
  
  
@Test
public String getmyid(String sr){
  String s1="";
	int i = sr.indexOf('.');
	s1=sr.substring(i+1);
	System.out.println(s1);
  return s1;
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
