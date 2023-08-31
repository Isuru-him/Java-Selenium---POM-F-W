package Pages_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper_Package.Commons;

public class Test_Drive_Booking_Page {

	private WebDriver pageDriver;
	Commons commons;

	@FindBy(css = "#input_first_name")
	WebElement fNameLoctor;

	@FindBy(css = "#input_last_name")
	WebElement lNameLoctor;

	@FindBy(css = "#input_email_address")
	WebElement emailLoctor;

	@FindBy(css = "#input_phone_number")
	WebElement phoneLoctor;

	@FindBy(css = ".iti__flag-container div[role=\"combobox\"]")
	WebElement phoneComboBox;

	@FindBy(css = ".iti__country-list li[data-dial-code=\"65\"]")
	WebElement singaCountryCode;

	@FindBy(css = "#datepicker_preferred_date")
	WebElement dateLoctor;

	@FindBy(css = ".choices__inner div[data-value=\"Preferred time\"]")
	WebElement timeLoctor;

	@FindBy(css = ".choices__inner div[data-value=\"Number of pax\"]")
	WebElement noOfPaxLocator;

	@FindBy(css = "span[aria-label=\"August 3, 2023\"]")
	WebElement datePickerLocator;

	@FindBy(css = "div[data-value=\"18:00\"]")
	WebElement timePickerLocator;

	@FindBy(css = "div[data-value=\"1\"]")
	WebElement paxPickerLocator;

	@FindBy(css = "div[data-value=\"UX 250h\"]")
	WebElement modelLocator;

	@FindBy(css = ".is_disabled")
	WebElement loginBtn_DisableModeLocator;

	@FindBy(css = "#checkbox_privacy_policy")
	WebElement privacyPolicyCheckBox;

	@FindBy(css = "#checkbox_marketing")
	WebElement markettingNotesCheckBox;

	public Test_Drive_Booking_Page(WebDriver importedDriver) {

		this.pageDriver = importedDriver;
		PageFactory.initElements(pageDriver, this);
		commons = new Commons(pageDriver);
	}

	public Boolean fillTheForm_BookTestDrive(String firstName, String LastName, String emailID, String phoneNumber) {

		fNameLoctor.sendKeys(firstName);
		lNameLoctor.sendKeys(LastName);
		emailLoctor.sendKeys(emailID);
		phoneComboBox.click();
		singaCountryCode.click();
		phoneLoctor.sendKeys(phoneNumber);
		commons.Scroll("0", "500");
		dateLoctor.click();
		datePickerLocator.click();
		timeLoctor.click();
		timePickerLocator.click();
		noOfPaxLocator.click();
		paxPickerLocator.click();
		commons.Scroll("0", "500");

		if (modelLocator.isDisplayed())
			System.out.println("Yes prefered model presents");

		try {

			// before clicking check the disbled attrtibute presents
			if (loginBtn_DisableModeLocator.isDisplayed()) {

				commons.Scroll("0", "500");

				// clicking on checkboxes
				privacyPolicyCheckBox.click();
				markettingNotesCheckBox.click();

				if (loginBtn_DisableModeLocator.isDisplayed()) {

					return false;
				}

			}

		} catch (Exception e) {

			return true;
		}

		return false;

	}

}
