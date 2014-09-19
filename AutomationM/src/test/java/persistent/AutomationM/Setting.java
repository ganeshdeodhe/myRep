package persistent.AutomationM;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Setting {
	WebDriver selenium;
  @Test
  public void loginWeb() throws InterruptedException {
	  selenium.get("https://wordpress.com/wp-login.php");
		selenium.findElement(By.cssSelector("input#user_login")).sendKeys("ganeshdeodhe");
		selenium.findElement(By.cssSelector("input#user_pass")).sendKeys("9049868029@me");
		selenium.findElement(By.id("wp-submit")).click();
				
		/*WebElement mouseoverelement = selenium.findElement(By.xpath("//*[text()='Appearance']"));
		
		
		Actions action = new Actions(selenium);
		
		action.moveToElement(mouseoverelement).build().perform();
		selenium.findElement(By.xpath("//*[text()='Widgets']")).click();
		Thread.sleep(3000);
		WebElement drag = selenium.findElement(By.xpath("//*[text()='Archives']"));
		//WebElement drag = selenium.findElement(By.cssSelector("div.widget-top div.widget-title h4"));
		Thread.sleep(4000);
		WebElement drop = selenium.findElement(By.id("sidebar-1"));
		action.dragAndDrop(drag, drop).build().perform();
		
		Thread.sleep(7000);*/
		//selenium.findElement(By.cssSelector("html.wp-toolbar body.wp-admin div#wpwrap div#adminmenuwrap ul#adminmenu li#menu-settings.wp-has-submenu ul.wp-submenu li.wp-first-item a.wp-first-item"));
		
		selenium.findElement(By.xpath("//*[text()='Settings']")).click();

		selenium.findElement(By.cssSelector("a.wp-has-submenu.wp-not-current-submenu.menu-top div.wp-menu-name")).click();
		
		WebElement dropdownID = selenium.findElement(By.xpath("//*[@id='start_of_week']"));
		Select dropdown = new Select(dropdownID);
		dropdown.selectByVisibleText("Friday");
		
		selenium.findElement(By.id("submit"));
		WebDriverWait wait = new WebDriverWait(selenium, 30);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p strong"))); 
			System.out.println(element.getText());	
		 		  System.out.println("Saved");
		
		
		
		 		  
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
