package Pages_Package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Helper_Package.Commons;


public class Home_Lexus_Page {
	
	private WebDriver pageDriver;
	Commons commons;

	
	@FindBy(css="div[data-id='lbx-world-premiere'] .masthead__wrapper section h1")
	WebElement mainBannerContent;
	
	@FindBy(css="#index_tiles .tab__panels_main img[alt='UX']")
	WebElement uxLinkElementLocator;
	

	public Home_Lexus_Page(WebDriver ImportedDriver) {
		
		this.pageDriver=ImportedDriver;
		PageFactory.initElements(pageDriver,this);
		commons = new Commons(pageDriver);
		
	}
	
	
	public String getBannerName() {
		
		String BannerValue=mainBannerContent.getText();
		
		System.out.println(" ");
		
		
		return BannerValue;
	}
	
	
	public Ux_SUV_Page GoToUx_LexusPage(String x, String y) {
		
		
		System.out.println("Page scrolled ...");
		commons.Scroll(x,y);
	
		uxLinkElementLocator.click();
		System.out.println("Navigated to the ux page ");
		
		return new Ux_SUV_Page(pageDriver);
	}
	
	
	

}