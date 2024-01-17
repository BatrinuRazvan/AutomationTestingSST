package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.StepDefHelper;

public class AdminBrandingPage {

	@FindBy(id = "updateBranding")
	WebElement submitButton;

	@FindBy(id = "name")
	WebElement nameField;

	@FindBy(id = "logoUrl")
	WebElement logoField;

	@FindBy(id = "description")
	WebElement descriptionField;

	@FindBy(id = "contactName")
	WebElement contactNameField;

	@FindBy(id = "contactAddress")
	WebElement contactAddressField;

	@FindBy(id = "contactPhone")
	WebElement contactPhoneField;

	@FindBy(id = "contactEmail")
	WebElement contactEmailField;

	WebDriver driver;

	public AdminBrandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSubmit() {
		this.submitButton.click();
	}

	public void inputName(String name) {
		this.nameField.clear();
		this.nameField.sendKeys(name);
	}

	public void inputLogoUrl(String logoUrl) {
		this.logoField.clear();
		this.logoField.sendKeys(logoUrl);
	}

	public void inputDescription(String desc) {
		StepDefHelper.waitForElementCreation(driver, By.id("description"));
		this.descriptionField.clear();
		this.descriptionField.sendKeys(desc);
	}

	public void clickClose() {
		WebElement closeButton = StepDefHelper.waitForElementCreation(driver, By.cssSelector(".btn-outline-primary"));
		closeButton.click();
	}

	public void inputContactName(String contactName) {
		StepDefHelper.waitForElementCreation(driver, By.id("contactName"));
		contactNameField.clear();
		contactNameField.sendKeys(contactName);
	}

	public void inputContactAddress(String contactAddress) {
		StepDefHelper.waitForElementCreation(driver, By.id("contactAddress"));
		contactAddressField.clear();
		contactAddressField.sendKeys(contactAddress);
	}

	public void inputContactPhone(Integer contactPhone) {
		StepDefHelper.waitForElementCreation(driver, By.id("contactPhone"));
		String contactPhoneAsStr = "" + contactPhone;
		contactPhoneField.clear();
		contactPhoneField.sendKeys(contactPhoneAsStr);
	}

	public void inputContactEmail(String contactEmail) {
		StepDefHelper.waitForElementCreation(driver, By.id("contactEmail"));
		contactEmailField.clear();
		contactEmailField.sendKeys(contactEmail);
	}

}
