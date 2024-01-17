package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.StepDefHelper;

public class ClientHomePage {

	@FindBy(id = "submitContact")
	WebElement submitButton;

	@FindBy(id = "name")
	WebElement nameField;

	WebElement logoUrl;

	@FindBy(id = "description")
	WebElement messageField;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "phone")
	WebElement phoneField;

	@FindBy(id = "subject")
	WebElement subjectField;

	WebElement bookRoomButton;
	@FindBy(name = "firstname")
	WebElement bookFirstnameField;
	@FindBy(name = "lastname")
	WebElement bookLastnameField;
	@FindBy(name = "email")
	WebElement bookEmailField;
	@FindBy(name = "phone")
	WebElement bookPhoneField;
	@FindBy(linkText = "Book")
	WebElement bookAfterSelectButton;

	WebDriver driver;

	public ClientHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setLogoUrl() {
		logoUrl = StepDefHelper.waitForElementCreation(driver, By.className("hotel-logoUrl"));
	}

	public String getLogoUrl() {
		return this.logoUrl.getAttribute("src");
	}

	public void inputMessageName(String name) {
		StepDefHelper.waitForElementCreation(driver, By.id("name"));
		getNameField().sendKeys(name);
	}

	public void inputMessageEmail(String email) {
		emailField.sendKeys(email);
	}

	public void inputMessagePhone(String phone) {
		phoneField.sendKeys(phone);
	}

	public void inputMessageSubject(String subject) {
		subjectField.sendKeys(subject);
	}

	public void inputMessageText(String message) {
		messageField.sendKeys(message);
	}

	public void clickSubmit() {
		submitButton.click();
	}

	public WebElement getNameField() {
		return nameField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getSubjectField() {
		return subjectField;
	}

	public WebElement getMessagField() {
		return messageField;
	}

	public void clickBookThisRoom() {
		bookRoomButton = StepDefHelper.waitForElementCreation(driver, By.cssSelector(".openBooking"));
		bookRoomButton.click();
	}

	public void inputBookFirstname(String firstname) {
		StepDefHelper.waitForElementCreation(driver, By.name("firstname"));
		bookFirstnameField.sendKeys(firstname);
	}

	public void inputBookLastname(String lastname) {
		bookLastnameField.sendKeys(lastname);
	}

	public void inputBookEmail(String email) {
		bookEmailField.sendKeys(email);
	}

	public void inputBookPhone(String phone) {
		bookPhoneField.sendKeys(phone);
	}

	public void clickBookAfterSelection() {
		WebElement section = driver.findElement(By.cssSelector(".col-sm-4"));
		bookAfterSelectButton = section.findElements(By.tagName("button")).get(1);
		bookAfterSelectButton.click();
	}

}
