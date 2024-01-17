package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AdminLoginPage;
import pagefactory.ClientHomePage;

public class ClientBookingSuccess {

	WebDriver driver;
	AdminLoginPage loginPage;
	ClientHomePage clientPage;

	@Given("client is on home page")
	public void client_is_on_home_page() {
		driver = StepDefHelper.initBrowser(driver);
		loginPage = new AdminLoginPage(driver);
		clientPage = new ClientHomePage(driver);
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/");
	}

	@And("client clicks book now button")
	public void client_clicks_book_now_button() {
		clientPage.clickBookThisRoom();
	}

	@When("client inputs correct firstname {string}, lastname {string}, email {string}, phone {string}")
	public void client_inputs_correct_firstname_lastname_email_phone(String firstname, String lastname, String email,
			String phone) {
		clientPage.inputBookFirstname(firstname);
		clientPage.inputBookLastname(lastname);
		clientPage.inputBookEmail(email);
		clientPage.inputBookPhone(phone);
	}

	@And("client selects nights")
	public void client_selects_nights() throws InterruptedException {
		StepDefHelper.selectNights(driver, "07", "09");
	}

	@And("user clicks book button")
	public void user_clicks_book_button() {
		clientPage.clickBookAfterSelection();
	}

	@Then("a new booking is visible on admin report page")
	public void a_new_booking_is_visible_on_admin_report_page() {
		StepDefHelper.clientConfirmBooking(driver, loginPage);
		driver.close();
	}

}
