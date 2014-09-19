package persistent.AutomationM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.util.Date;
import java.util.Properties;

public class login {
	WebDriver selenium;
  @Test
  public void loginWeb() throws InterruptedException, IOException {
	  
	  FirefoxProfile p1= new FirefoxProfile();
	  p1.setPreference("network.http.phisy-userpass-length", 255);
	  selenium = new FirefoxDriver(p1);
	  //selenium.get("http://ganesh_deodhe:pass@wordpress.com/wp-login.php");
	 selenium.get("https://wordpress.com/wp-login.php");
	  selenium.findElement(By.id("user_login")).sendKeys("ganeshdeodhe");
	  selenium.findElement(By.id("user_pass")).sendKeys("9049868029@me");
	  selenium.findElement(By.id("wp-submit")).click();
	  /*Properties pr = new Properties();
	  pr.load(new FileInputStream("./src/test/java/repository.properties"));
	  
	  String url = pr.getProperty("URL");
	  String l= pr.getProperty("login_id");
	  String p = pr.getProperty("login_pass");
	  selenium.get(url);
	  	if (l.contains("id")){
	  			String login=getmyid(l);
	  		  	selenium.findElement(By.id(login)).sendKeys("ganeshdeodhe");
	  	}
		if (l.contains("css")){
			String login=getmyid(l);
  		  	selenium.findElement(By.cssSelector("input#user_login.input")).sendKeys("ganeshdeodhe");
		}
		if (l.contains("xpath")){
  			String login=getmyid(l);
  			System.out.println(login);
  		  	selenium.findElement(By.xpath(login)).sendKeys("ganeshdeodhe");
		}	  	

	  	if (p.contains("id")){
  			String pass=getmyid(p);
  		  	selenium.findElement(By.id(pass)).sendKeys("ganeshdeodhe");
	  	}
	  	
	  	if (p.contains("css")){
  			String pass=getmyid(p);
  		  	selenium.findElement(By.cssSelector("input#user_pass.input")).sendKeys("ganeshdeodhe");
	  	}
	  	if (p.contains("xpath")){
  			String pass=getmyid(p);
  			System.out.println(pass);
  		  	selenium.findElement(By.xpath(pass)).sendKeys("ganeshdeodhe");
	  	}
	  	*/
		/*Date dt = new Date();
		String sr = dt.toString();
		String path = "./srcshot_";
		String ext = ".png";
		*/
		/*File scr= ((TakesScreenshot)selenium).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./scrshot.png"));
		
		
		
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
		
				*/
		 		  
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
//	selenium=new FirefoxDriver();
	System.out.println("FireFox object created");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Closing FireFox");
	  selenium.close();
	  selenium.quit();
  }

}
