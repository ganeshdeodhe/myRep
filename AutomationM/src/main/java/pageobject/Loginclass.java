package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginclass {
	WebDriver selenium;
	
	@FindBy(id="user_login")
	@CacheLookup
	WebElement user;
	
	@FindBy(id="user_pass")
	@CacheLookup
	WebElement userPass;
	
	@FindBy(id="wp-submit")
	@CacheLookup
	WebElement submit;
	
	public Loginclass(WebDriver selenium){
		this.selenium=selenium;
		System.out.println("Login Initialized");
		
	}
	
	public DashboardClass Login(String userID, String userP){
		selenium.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		// user = selenium.findElement(By.id("user_login"));
		System.out.println("In Log In Method");
		user.sendKeys(userID);
		System.out.println("Login Name Entered");
		
		//userPass = selenium.findElement(By.id("user_pass"));

		userPass.sendKeys(userP);
		//submit = selenium.findElement(By.id("wp-submit"));
		
		submit.click();
		System.out.println("Clicked On Login");
		return PageFactory.initElements(selenium, DashboardClass.class);
		//return new DashboardClass(selenium); 
	}
}
