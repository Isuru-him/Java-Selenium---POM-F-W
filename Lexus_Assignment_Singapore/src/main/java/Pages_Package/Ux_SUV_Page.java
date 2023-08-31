package Pages_Package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper_Package.Commons;

public class Ux_SUV_Page {
	
	
	private WebDriver pageDriver;
	Commons commons;
	
	
	@FindBy(css="li[style=\"width: 1200px;\"]:nth-of-type(20) div")
	WebElement videoAttributeLocator;
	
	@FindBy(css=".list__explore li[data-id=\"ux-250h\"] .list__explore_cont div:nth-of-type(4) p:nth-of-type(1) a")
	WebElement bookTestDriveLocator;
	
	
	
	public Ux_SUV_Page(WebDriver importedDriver) {

		this.pageDriver = importedDriver;
		PageFactory.initElements(pageDriver, this);
		commons = new Commons(pageDriver);
		
		
	}

	
	public String getVideoAttributeName() {
		
		System.out.println(" ");
		System.out.println("I am in the UX page now ");
		
		
		
		String attributeName = videoAttributeLocator.getAttribute("data-src");
		
		System.out.println(" ");
		System.out.println("Attribute name is ");
		System.out.println(attributeName);
		
		return attributeName;
	}
	
	
	public Test_Drive_Booking_Page goTo_TestDriveBookingPage(String x, String y) {
		
		
		commons.Scroll(x,y);
		
		bookTestDriveLocator.click();
		
		return new Test_Drive_Booking_Page(pageDriver);
		
	}
}
