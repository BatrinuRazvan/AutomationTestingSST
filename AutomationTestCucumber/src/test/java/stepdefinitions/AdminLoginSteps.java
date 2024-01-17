package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AdminLoginPage;

public class AdminLoginSteps {

	WebDriver driver;
	AdminLoginPage loginPage;

	@Given("user is on admin login page")
	public void user_is_on_admin_login_page() {
		driver = StepDefHelper.initBrowser(driver);
		loginPage = new AdminLoginPage(driver);
		driver.navigate().to("https://automationintesting.online/#/admin");
	}

	@When("user enters username and password both valid")
	public void user_enters_username_and_password_both_valid() throws InterruptedException {
		loginPage.inputUsername("admin");
		loginPage.inputPassword("password");

		Thread.sleep(2000);
	}

	@And("user clicks login")
	public void user_clicks_login() {
		loginPage.clickLogin();
	}

	@Then("admin home page opens")
	public void admin_home_page_opens() throws InterruptedException {
		driver.findElement(By.className("navbar"));
		Thread.sleep(3000);
		driver.quit();
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		loginPage.inputUsername("admin");
		loginPage.inputPassword("passinvalid");

	}

	@Then("input fields turn red")
	public void input_fields_turn_red() throws InterruptedException {
		WebElement loginButton = loginPage.getLoginButton();
		loginButton.getAttribute("style").contains("red");
		Thread.sleep(3000);
		driver.quit();
	}

	@When("user enters username and valid password")
	public void user_enters_username_and_valid_password() {
		loginPage.inputUsername("user1");
		loginPage.inputPassword("password");

	}

	@When("user enters invalid username password")
	public void user_enters_invalid_username_password() {
		loginPage.inputUsername("user1");
		loginPage.inputPassword("user1");

	}

}
