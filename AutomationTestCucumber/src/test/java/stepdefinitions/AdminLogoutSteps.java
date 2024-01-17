package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AdminHomePage;
import pagefactory.AdminLoginPage;

public class AdminLogoutSteps {

	WebDriver driver;
	AdminHomePage adminHomePage;
	AdminLoginPage loginPage;

	@Given("user is logged in as admin")
	public void user_is_logged_in_as_admin() {
		driver = StepDefHelper.initBrowser(driver);
		loginPage = new AdminLoginPage(driver);
		adminHomePage = new AdminHomePage(driver);

		StepDefHelper.loginAsAdmin(driver, loginPage);

	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() {
		adminHomePage.clickLogout();
	}

	@Then("user is navigated to login page")
	public void user_is_navigated_to_login_page() {
		loginPage.getLoginButton();
		driver.quit();
	}

}
