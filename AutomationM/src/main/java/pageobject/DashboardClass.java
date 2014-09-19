package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardClass {
	WebDriver selenium;
	WebElement st_link;
	
	public DashboardClass(WebDriver selenium){
		this.selenium = selenium;
		}
	
	public SettingClass clickSetting() throws InterruptedException{
		selenium.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		System.out.println("On dashboad page");
		
		WebDriverWait wait = new WebDriverWait(selenium, 30);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Settings']"))); 
		System.out.println(element.getText());	
		
		st_link = selenium.findElement(By.xpath("//*[text()='Settings']"));
		st_link.click();
		
		System.out.println("Clicked on Setting");
		return new SettingClass(selenium);
	}

}
