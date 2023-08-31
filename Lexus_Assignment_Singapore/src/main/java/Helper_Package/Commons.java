package Helper_Package;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Commons {
	
	private WebDriver pageDriver;
	
	public Commons(WebDriver importedDriver) {
		
		this.pageDriver=importedDriver;
	}
	
	public void Scroll(String x, String y) {
		
		JavascriptExecutor js = (JavascriptExecutor)pageDriver;
		js.executeScript("window.scrollBy(" +x+ "," +y+ ")", "");
	}

}
