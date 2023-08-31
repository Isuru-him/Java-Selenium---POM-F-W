package TestClasses;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Package.TestBase;
import Pages_Package.Home_Lexus_Page;
import Pages_Package.Test_Drive_Booking_Page;
import Pages_Package.Ux_SUV_Page;

public class Home_Lexus_Test extends TestBase {

	Home_Lexus_Page home_Lexus_Page;
	Ux_SUV_Page ux_SUV_Page;
	Test_Drive_Booking_Page test_Drive_Booking_Page;

	@BeforeMethod
	public void tearUp() {

		initiateDriver();
		navigateTo("https://www.lexus.com.sg");
		home_Lexus_Page = new Home_Lexus_Page(getDriver());
		ux_SUV_Page = new Ux_SUV_Page(getDriver());
		test_Drive_Booking_Page = new Test_Drive_Booking_Page(getDriver());
		
		/*
		 * This method is used to do the initial page loads and object initialization
		 */

	}

	@AfterMethod
	public void tearDown() {

		testClosure();
		
		/*
		 * This method is used to do the Test closures after running each test method
		 */
	}

	@Test
	public void validateMainBannerName() {

		System.out.println("1.) This testcase is used to validate the main banner text");
		String ActualValue = home_Lexus_Page.getBannerName();
		String ExpectedValue = "ALL-NEW\n" + "LEXUS LBX\n" + "WORLD\n" + "PREMIERE";
		assertEquals(ActualValue, ExpectedValue);
		
		/*
		 * This method is used to answer section "a" question 1,  part 1 and 2
		 */

	}

	@Test
	public void Verify_NavigatingToUx_LexusPage_And_VideoLoad() {

		System.out.println(" ");
		System.out.println("*****************");
		System.out.println(
				"2.) This testcase is used to validate UX_Lexus page navigation and video on the image scroller");

		ux_SUV_Page = home_Lexus_Page.GoToUx_LexusPage("0", "1000");
		String actualValue = ux_SUV_Page.getVideoAttributeName();
		Assert.assertTrue(actualValue.contains("https://www.youtube.com/watch?v=L2QWO27sdQM&feature=youtu.be"));
		
		/*
		 * This method is used to answer section "a" question 2,  part 1, 2 and 3
		 */


	}

	@Test
	public void fill_BookTestDrive_Form() {

		ux_SUV_Page = home_Lexus_Page.GoToUx_LexusPage("0", "500");
		test_Drive_Booking_Page = ux_SUV_Page.goTo_TestDriveBookingPage("0", "4500");
		Boolean actualValue = test_Drive_Booking_Page.fillTheForm_BookTestDrive("CPL", "Test", "qa@convertium.com",
				"91234567");
		Assert.assertEquals(actualValue, true);

		/*
		 * This method is used to answer section "a" question 3,  part 1, 2 and 3
		 */
		
	}

}
