package Base_Package;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	WebDriver driver;
	
	public void initiateDriver(){
		

		driver = WebDriverManager.chromedriver().create();
		
		
	}
	
	public WebDriver getDriver() {
	
	
	return driver;	
		
	}
	
	public void navigateTo(String url){
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("consent_prompt_submit")).click();
		
	}
	

	public void testClosure() {
		
		driver.quit();
	}

}
