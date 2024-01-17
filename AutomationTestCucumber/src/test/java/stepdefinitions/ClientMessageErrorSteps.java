package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.ClientHomePage;

public class ClientMessageErrorSteps {

	private WebDriver driver;
	private ClientHomePage clientPage;

	@Given("the user is on client home page")
	public void the_user_is_on_client_home_page() {
		driver = StepDefHelper.initBrowser(driver);
		clientPage = new ClientHomePage(driver);
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/");
	}

	@When("user inputs incorrect name {string}")
	public void user_inputs_incorrect_name(String blankName) {
		StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "name");
	}

	@When("user inputs incorrect email {string}")
	public void user_inputs_incorrect_email(String emailNotOk) {
		if (emailNotOk.equals("")) {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "email");
		} else {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getEmailField().clear();
			clientPage.inputMessageEmail(emailNotOk);
		}
	}

	@When("user inputs incorrect phone {string}")
	public void user_inputs_incorrect_phone(String phoneNotOk) {
		if (phoneNotOk.equals("")) {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "phone");
		} else {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getPhoneField().clear();
			clientPage.inputMessagePhone(phoneNotOk);
		}
	}

	@When("user inputs incorrect subject {string}")
	public void user_inputs_incorrect_subject(String subjectNotOk) {
		if (subjectNotOk.equals("")) {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "subject");
		} else {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getSubjectField().clear();
			clientPage.inputMessageSubject(subjectNotOk);
		}
	}

	@When("user inputs incorrect message {string}")
	public void user_inputs_incorrect_message(String messageNotOk) {
		if (messageNotOk.equals("")) {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "message");
		} else {
			StepDefHelper.inputAllMessageFieldsButNotBlank(clientPage, "noneExcluded");
			clientPage.getMessagField().clear();
			clientPage.inputMessageText(messageNotOk);
		}
	}

	@And("the user clicks submit")
	public void the_user_clicks_submit() {
		clientPage.clickSubmit();
	}

	@Then("the error nameIsBlank is expected")
	public void the_error_name_is_blank_is_expected() {
		StepDefHelper.compareToError(driver, "Name may not be blank");
		driver.quit();
	}

	@Then("the error emailIsBlank is expected")
	public void the_error_email_is_blank_is_expected() {
		StepDefHelper.compareToError(driver, "Email may not be blank");
		driver.quit();
	}

	@Then("the error emailWrong is expected")
	public void the_error_email_wrong_is_expected() {
		StepDefHelper.compareToError(driver, "must be a well-formed email address");
		driver.quit();
	}

	@Then("the error phoneIsBlank is expected")
	public void the_error_phone_is_blank_is_expected() {
		StepDefHelper.compareToError(driver, "Phone may not be blank");
		driver.quit();
	}

	@Then("the error phoneShort is expected")
	public void the_error_phone_short_is_expected() {
		StepDefHelper.compareToError(driver, "Phone must be between 11 and 21 characters.");
		driver.quit();
	}

	@Then("the error subjectIsBlank is expected")
	public void the_error_subject_is_blank_is_expected() {
		StepDefHelper.compareToError(driver, "Subject may not be blank");
		driver.quit();
	}

	@Then("the error subjectShort is expected")
	public void the_error_subject_short_is_expected() {
		StepDefHelper.compareToError(driver, "Subject must be between 5 and 100 characters.");
		driver.quit();
	}

	@Then("the error messageIsBlank is expected")
	public void the_error_message_is_blank_is_expected() {
		StepDefHelper.compareToError(driver, "Message may not be blank");
		driver.quit();
	}

	@Then("the error messagetShort is expected")
	public void the_error_messaget_short_is_expected() {
		StepDefHelper.compareToError(driver, "Message must be between 20 and 2000 characters.");
		driver.quit();
	}

}
