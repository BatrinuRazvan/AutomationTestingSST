package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AdminBrandingPage;
import pagefactory.AdminLoginPage;
import pagefactory.ClientHomePage;

public class AdminContactSteps {

	WebDriver driver;
	AdminLoginPage loginPage;
	AdminBrandingPage brandingPage;
	ClientHomePage clientPage;
	WebElement contactSection;

	@Given("user is on branding page")
	public void user_is_on_branding_page() {
		driver = StepDefHelper.initBrowser(driver);
		loginPage = new AdminLoginPage(driver);
		brandingPage = new AdminBrandingPage(driver);
		clientPage = new ClientHomePage(driver);

		StepDefHelper.loginAsAdmin(driver, loginPage);
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/#/admin/branding");
	}

	@When("user changes name to {string} in contact details")
	public void user_changes_name_to_in_contact_details(String contactName) {
		brandingPage.inputContactName(contactName);
	}

	@And("user navigates to client page")
	public void user_navigates_to_client_page() throws InterruptedException {
		Thread.sleep(500);
		brandingPage.clickSubmit();
		Thread.sleep(500);
		WebElement closeSction = StepDefHelper.waitForElementCreation(driver, By.className("ReactModal__Overlay"));
		WebElement closeButton = closeSction.findElement(By.cssSelector(".btn"));
		closeButton.click();
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/#");
		contactSection = StepDefHelper.waitForElementCreation(driver, By.cssSelector(".contact"));
	}

	@Then("new name is displayed in contact section")
	public void new_name_is_displayed_in_contact_section() {
		WebElement pName = contactSection.findElements(By.tagName("p")).get(0);
		assertEquals(pName.getText(), "Happy Bed&Breakfast");
		driver.quit();
	}

	@When("user changes address to {string} in contact details")
	public void user_changes_address_to_in_contact_details(String contactAddress) {
		brandingPage.inputContactAddress(contactAddress);
	}

	@Then("new address is displayed in contact section")
	public void new_address_is_displayed_in_contact_section() {
		WebElement pAddress = contactSection.findElements(By.tagName("p")).get(1);
		assertEquals(pAddress.getText(), "Str. Pestalozzi 20");
		driver.quit();
	}

	@When("user changes phone to {int} in contact details")
	public void user_changes_phone_to_in_contact_details(Integer contactPhone) {
		brandingPage.inputContactPhone(contactPhone);
	}

	@Then("new phone is displayed in contact section")
	public void new_phone_is_displayed_in_contact_section() {
		WebElement pPhone = contactSection.findElements(By.tagName("p")).get(2);
		assertEquals(pPhone.getText(), "" + 07232134256);
		driver.quit();
	}

	@When("user changes email to {string} in contact details")
	public void user_changes_email_to_in_contact_details(String contactEmail) {
		brandingPage.inputContactEmail(contactEmail);
	}

	@Then("new email is displayed in contact section")
	public void new_email_is_displayed_in_contact_section() {
		WebElement pEmail = contactSection.findElements(By.tagName("p")).get(3);
		assertEquals(pEmail.getText(), "uvtProject@e-uvt.ro");
		driver.quit();
	}

}
