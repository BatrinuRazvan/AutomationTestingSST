package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AdminLoginPage;
import pagefactory.ClientHomePage;

public class ClientMessageSuccessSteps {

	private WebDriver driver;
	private AdminLoginPage loginPage;
	private ClientHomePage clientPage;

	@Given("user is on client home page")
	public void user_is_on_client_home_page() {
		driver = StepDefHelper.initBrowser(driver);
		loginPage = new AdminLoginPage(driver);
		clientPage = new ClientHomePage(driver);
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/");
	}

	@When("user inputs correct {string}, {string}, {string}, {string} and {string}")
	public void user_inputs_correct_and(String name, String email, String phone, String subject, String message) {
		clientPage.inputMessageName(name);
		clientPage.inputMessageEmail(email);
		clientPage.inputMessagePhone(phone);
		clientPage.inputMessageSubject(subject);
		clientPage.inputMessageText(message);
	}

	@When("user clicks submit")
	public void user_clicks_submit() {
		clientPage.clickSubmit();
	}

	@Then("a new message is visible on the admin page")
	public void a_new_message_is_visible_on_the_admin_page() {
		StepDefHelper.loginAsAdmin(driver, loginPage);
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/#/admin/messages");
		StepDefHelper.waitForElementCreation(driver, By.id("message1"));
		driver.close();
	}

}
