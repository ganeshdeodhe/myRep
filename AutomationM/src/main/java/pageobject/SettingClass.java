package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SettingClass {
	WebDriver selenium;
	WebElement dropdownID;
	
	
	public SettingClass(WebDriver selenium){
		this.selenium = selenium;
	}
	
	public void updateSetting(){
		System.out.println("On Update setting Page");
		//selenium.findElement(By.cssSelector("a.wp-has-submenu.wp-not-current-submenu.menu-top div.wp-menu-name")).click();
		dropdownID = selenium.findElement(By.xpath("//*[@id='start_of_week']"));
		//*[@id="start_of_week"]
		Select dropdown = new Select(dropdownID);
		dropdown.selectByVisibleText("Friday");
		selenium.findElement(By.id("submit"));
	}
	

}
