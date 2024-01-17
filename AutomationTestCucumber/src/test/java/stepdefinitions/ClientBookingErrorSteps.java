package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.ClientHomePage;

public class ClientBookingErrorSteps {

	private WebDriver driver;
	private ClientHomePage clientPage;

	@Given("client is on client front page")
	public void client_is_on_client_front_page() {
		driver = StepDefHelper.initBrowser(driver);
		clientPage = new ClientHomePage(driver);
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/");
	}

	@And("client clicks book button")
	public void client_clicks_book_button() {
		clientPage.clickBookThisRoom();
	}

	@When("client inputs incorrect firstname {string}")
	public void client_inputs_incorrect_firstname(String firstname) {
		if (firstname.equals("")) {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "firstname");
		} else {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getBookFirstnameField().clear();
			clientPage.inputBookFirstname(firstname);
		}
	}

	@And("client clicks submit")
	public void client_clicks_submit() {
		clientPage.clickBookAfterSelection();
	}

	@Then("the error firstnameBlank is shown")
	public void the_error_firstname_blank_is_shown() {
		StepDefHelper.compareToError(driver, "Firstname should not be blank");
		driver.quit();
	}

	@Then("the error firstnameTooShort is shown")
	public void the_error_firstname_too_short_is_shown() {
		StepDefHelper.compareToError(driver, "size must be between 3 and 18");
		driver.quit();
	}

	@Then("the error firstnameTooLong is shown")
	public void the_error_firstname_too_long_is_shown() {
		StepDefHelper.compareToError(driver, "size must be between 3 and 18");
		driver.quit();
	}

	@When("client inputs incorrect lastname {string}")
	public void client_inputs_incorrect_lastname(String lastname) {
		if (lastname.equals("")) {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "lastname");
		} else {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getBookLastnameField().clear();
			clientPage.inputBookLastname(lastname);
		}
	}

	@Then("the error lastnameIsBlank is shown")
	public void the_error_lastname_is_blank_is_shown() {
		StepDefHelper.compareToError(driver, "Lastname should not be blank");
		driver.quit();
	}

	@Then("the error lastnameTooShort is shown")
	public void the_error_lastname_too_short_is_shown() {
		StepDefHelper.compareToError(driver, "size must be between 3 and 30");
		driver.quit();
	}

	@Then("the error lastnameTooLong is shown")
	public void the_error_lastname_too_long_is_shown() {
		StepDefHelper.compareToError(driver, "size must be between 3 and 30");
		driver.quit();
	}

	@When("client inputs incorrect email {string}")
	public void client_inputs_incorrect_email(String email) {
		if (email.equals("")) {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "email");
		} else {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getBookEmailField().clear();
			clientPage.inputBookEmail(email);
		}
	}

	@Then("the error emailIsBlank is shown")
	public void the_error_email_is_blank_is_shown() {
		StepDefHelper.compareToError(driver, "must not be empty");
		driver.quit();
	}

	@Then("the error emailNotCorrect is shown")
	public void the_error_email_not_correct_is_shown() {
		StepDefHelper.compareToError(driver, "must be a well-formed email address");
		driver.quit();
	}

	@When("client inputs incorrect phone {string}")
	public void client_inputs_incorrect_phone(String phone) {
		if (phone.equals("")) {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "phone");
		} else {
			StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getBookPhoneField().clear();
			clientPage.inputBookPhone(phone);
		}
	}

	@Then("the error phoneIsBlank is shown")
	public void the_error_phone_is_blank_is_shown() {
		StepDefHelper.compareToError(driver, "must not be empty");
		driver.quit();
	}

	@Then("the error phoneTooShort is shown")
	public void the_error_phone_too_short_is_shown() {
		StepDefHelper.compareToError(driver, "size must be between 11 and 21");
		driver.quit();
	}

	@When("client does not select days")
	public void client_does_not_select_days() {
		driver.findElement(By.cssSelector(".rbc-month-view"));
	}

	@Then("the error daysIsNull is shown")
	public void the_error_days_is_null_is_shown() {
		StepDefHelper.inputAllBookingFieldsButNotBlank(clientPage, "days");
		StepDefHelper.compareToError(driver, "must not be null");
		driver.quit();
	}

}
