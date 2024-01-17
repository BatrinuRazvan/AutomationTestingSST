package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AdminHomePage;
import pagefactory.AdminLoginPage;

public class CreateRoomsSuccessSteps {

	private WebDriver driver;
	private AdminHomePage adminHomePage;
	private AdminLoginPage loginPage;

	@Given("user is on admin rooms page")
	public void user_is_on_admin_rooms_page() {
		driver = StepDefHelper.initBrowser(driver);
		loginPage = new AdminLoginPage(driver);
		adminHomePage = new AdminHomePage(driver);
		StepDefHelper.loginAsAdmin(driver, loginPage);
	}

	@When("user inputs {int}, Single, accessible: true, {int} and TV,WiFi")
	public void user_inputs_single_accessible_true_and_tv_wi_fi(Integer roomNumber, Integer price) {

		adminHomePage.inputRoomNumber(roomNumber);
		adminHomePage.setType("Single");
		adminHomePage.setAccessible(true);
		adminHomePage.setPrice(price);
		String detail = "TV,WiFi";
		List<String> details = StepDefHelper.intarpretDetails(detail.split(","));
		adminHomePage.setDetails(details);
		adminHomePage.clickCreate();

	}

	@Then("a new room is created")
	public void a_new_room_is_created() {
		String waitForElement = "room" + StepDefHelper.getRoomCounter();
		StepDefHelper.waitForElementCreation(driver, By.id(waitForElement));
		driver.quit();
	}

	@When("user inputs {int}, Twin, accessible: true, {int} and TV,WiFi,Safe")
	public void user_inputs_twin_accessible_true_and_tv_wi_fi_safe(Integer roomNumber, Integer price) {
		adminHomePage.inputRoomNumber(roomNumber);
		adminHomePage.setType("Twin");
		adminHomePage.setAccessible(true);
		adminHomePage.setPrice(price);
		String detail = "TV,WiFi,Safe";
		List<String> details = StepDefHelper.intarpretDetails(detail.split(","));
		adminHomePage.setDetails(details);
		adminHomePage.clickCreate();
	}

	@When("user inputs {int}, Double, accessible: true, {int} and Safe,Views")
	public void user_inputs_double_accessible_true_and_safe_views(Integer roomNumber, Integer price) {
		adminHomePage.inputRoomNumber(roomNumber);
		adminHomePage.setType("Double");
		adminHomePage.setAccessible(true);
		adminHomePage.setPrice(price);
		String detail = "Safe,Views";
		List<String> details = StepDefHelper.intarpretDetails(detail.split(","));
		adminHomePage.setDetails(details);
		adminHomePage.clickCreate();
	}

	@When("user inputs {int}, Family, accessible: true, {int} and WiFi,Radio")
	public void user_inputs_family_accessible_true_and_wi_fi_radio(Integer roomNumber, Integer price) {
		adminHomePage.inputRoomNumber(roomNumber);
		adminHomePage.setType("Family");
		adminHomePage.setAccessible(true);
		adminHomePage.setPrice(price);
		String detail = "WiFi,Radio";
		List<String> details = StepDefHelper.intarpretDetails(detail.split(","));
		adminHomePage.setDetails(details);
		adminHomePage.clickCreate();
	}

	@When("user inputs {int}, Suite, accessible: true, {int} and Safe,Views,WiFi")
	public void user_inputs_suite_accessible_true_and_safe_views_wifi(Integer roomNumber, Integer price) {
		adminHomePage.inputRoomNumber(roomNumber);
		adminHomePage.setType("Single");
		adminHomePage.setAccessible(true);
		adminHomePage.setPrice(price);
		String detail = "Safe,Views,WiFi";
		List<String> details = StepDefHelper.intarpretDetails(detail.split(","));
		adminHomePage.setDetails(details);
		adminHomePage.clickCreate();
	}

}
