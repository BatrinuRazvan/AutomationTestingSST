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

public class AdminBrandingDetailsSteps {

	WebDriver driver;
	AdminBrandingPage brandingPage;
	AdminLoginPage loginPage;
	ClientHomePage clientPage;
	private String logoUrl = "https://play-lh.googleusercontent.com/ahJtMe0vfOlAu1XJVQ6rcaGrQBgtrEZQefHy7SXB7jpijKhu1Kkox90XDuH8RmcBOXNn";

	@Given("user is on admin branding page")
	public void user_is_on_admin_branding_page() {
		driver = StepDefHelper.initBrowser(driver);
		loginPage = new AdminLoginPage(driver);
		brandingPage = new AdminBrandingPage(driver);
		clientPage = new ClientHomePage(driver);

		StepDefHelper.loginAsAdmin(driver, loginPage);
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/#/admin/branding");
	}

	@When("user changes name")
	public void user_changes_name() {
		StepDefHelper.waitForElementCreation(driver, By.id("name"));
		brandingPage.inputName("Any B&B");
	}

	@And("user changes logo link")
	public void user_changes_logo_link() {
		brandingPage.inputLogoUrl(logoUrl);
	}

	@When("user changes description")
	public void user_changes_description() {
		brandingPage.inputDescription("This is the new description");
	}

	@And("user navigates to front page")
	public void user_navigates_to_front_page() throws InterruptedException {
		Thread.sleep(500);
		brandingPage.clickSubmit();
		Thread.sleep(500);
		WebElement closeSction = StepDefHelper.waitForElementCreation(driver, By.className("ReactModal__Overlay"));
		WebElement closeButton = closeSction.findElement(By.cssSelector(".btn"));
		closeButton.click();
		StepDefHelper.navigateTo(driver, "https://automationintesting.online/#");
		clientPage.setLogoUrl();
	}

	@Then("new logo is visible on front page")
	public void new_logo_is_visible_on_front_page() {
		assertEquals(clientPage.getLogoUrl(), logoUrl);
		driver.quit();
	}

	@Then("new description is visible on front page")
	public void new_description_is_visible_on_front_page() {
		WebElement hotelDesc = StepDefHelper.waitForElementCreation(driver, By.cssSelector(".hotel-description"));
		WebElement pElement = hotelDesc.findElement(By.tagName("p"));
		assertEquals(pElement.getText(), "This is the new description");
		driver.quit();
	}

}
