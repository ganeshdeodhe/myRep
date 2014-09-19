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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class multiplepost {
	WebDriver selenium;
  @Test
  public void loginWeb() throws InterruptedException, IOException, BiffException {
	  selenium.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  selenium.get("https://wordpress.com/wp-login.php");
	  selenium.findElement(By.id("user_login")).sendKeys("ganeshdeodhe");
	  selenium.findElement(By.id("user_pass")).sendKeys("9049868029@me");
	  selenium.findElement(By.id("wp-submit")).click();
	
			
		
		 Workbook book = Workbook.getWorkbook(new File("./src/test/java/Book3.xls"));
		 Sheet s1 = book.getSheet("master");
		 System.out.println(s1.getColumns());
		 System.out.println(s1.getRows());
		 String data;
		  
		  System.out.println("======Prinitng .xls File Data=========");
		  
		  int i=0,j;
		  String tt="",post="";
		  		
		  WebDriverWait wait;
		  for(j=1;j<s1.getRows();j++){
		   			  
				 
				  tt = s1.getCell(i, j).getContents();
				  post = s1.getCell(i+1, j).getContents();
				  System.out.print(tt);
				  System.out.print(post);
				  Thread.sleep(3000);
			  
				selenium.findElement(By.xpath("//*[text()='Posts']")).click();
				selenium.findElement(By.className("add-new-h2")).click();  
				selenium.findElement(By.id("title")).sendKeys(tt);
				selenium.switchTo().frame("content_ifr");
				selenium.findElement(By.id("tinymce")).sendKeys(post);
				Thread.sleep(3000);
				selenium.switchTo().defaultContent();
				selenium.findElement(By.id("publish")).click();
				 System.out.println("Published");
			//
								  
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
