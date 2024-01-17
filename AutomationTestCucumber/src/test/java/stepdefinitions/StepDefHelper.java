package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pagefactory.AdminLoginPage;
import pagefactory.ClientHomePage;

public class StepDefHelper {

	private static final String DRIVER_LOC = "src/test/resources/driver/chromedriver.exe";
	private static final String CHROME = "webdriver.chrome.driver";

	private static final String WIFI_DETAIL = "wifiCheckbox";
	private static final String TV_DETAIL = "tvCheckbox";
	private static final String RADIO_DETAIL = "radioCheckbox";
	private static final String REFRESH_DETAIL = "refreshCheckbox";
	private static final String SAFE_DETAIL = "safeCheckbox";
	private static final String VIEWS_DETAIL = "viewsCheckbox";

	private static int roomCounter = 1;

	public static WebDriver initBrowser(WebDriver driver) {
		System.setProperty(CHROME, DRIVER_LOC);
		driver = new ChromeDriver();
		System.out.println(" Browser accessed ");
		driver.manage().window().maximize();
		return driver;
	}

	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}

	public static List<String> intarpretDetails(String[] split) {
		return Arrays.asList(split);
	}

	public static String getIdFromDetail(String detail) {
		switch (detail) {
		case "WiFi":
			return WIFI_DETAIL;
		case "TV":
			return TV_DETAIL;
		case "Refreshments":
			return REFRESH_DETAIL;
		case "Radio":
			return RADIO_DETAIL;
		case "Safe":
			return SAFE_DETAIL;
		case "Views":
			return VIEWS_DETAIL;

		default:
			return null;
		}
	}

	public static String getRoomCounter() {
		roomCounter++;
		return "" + roomCounter;
	}

	public static WebElement waitForElementCreation(WebDriver driver, By bySelected) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(bySelected));
	}

	public static void loginAsAdmin(WebDriver driver, AdminLoginPage loginPage) {
		driver.navigate().to("https://automationintesting.online/#/admin");
		loginPage.inputUsername("admin");
		loginPage.inputPassword("password");
		loginPage.clickLogin();
	}

	public static void navigateTo(WebDriver driver, String link) {
		driver.navigate().to(link);
	}

	public static void compareToError(WebDriver driver, String error) {
		WebElement alertSection = waitForElementCreation(driver, By.className("alert"));

		List<WebElement> alertPhs = alertSection.findElements(By.tagName("p"));
		Optional<WebElement> alertPhName = null;
		alertPhName = alertPhs.stream().filter(p -> p.getText().equals(error)).findAny();
		assertNotEquals(alertPhName, Optional.empty());
	}

	public static void inputAllMessageFieldsButNotBlank(ClientHomePage clientPage, String blank) {
		if (!blank.equals("name")) {
			clientPage.inputMessageName("Razvan");
		}
		if (!blank.equals("email")) {
			clientPage.inputMessageEmail("email@fake.co");
		}
		if (!blank.equals("phone")) {
			clientPage.inputMessagePhone("072121221234");
		}
		if (!blank.equals("subject")) {
			clientPage.inputMessageSubject("no subject");
		}
		if (!blank.equals("message")) {
			clientPage.inputMessageText("I want to see if this message will be written in the form!");
		}
	}

	public static void selectNights(WebDriver driver, String from, String to) throws InterruptedException {
		WebElement calendarSection = waitForElementCreation(driver, By.cssSelector(".rbc-month-view"));
		Thread.sleep(1000);
		WebElement calendarMonth = calendarSection.findElements(By.cssSelector(".rbc-month-row")).get(4);
		WebElement weekContent = calendarMonth.findElement(By.cssSelector(".rbc-row"));
		WebElement firstnight = weekContent.findElements(By.cssSelector(".rbc-date-cell")).get(0);
		WebElement lastnight = weekContent.findElements(By.cssSelector(".rbc-date-cell")).get(2);

		Actions actions = new Actions(driver);
		actions.moveToElement(lastnight).pause(Duration.ofSeconds(1)).click().clickAndHold(lastnight)
				.pause(Duration.ofSeconds(1)).moveToElement(firstnight).clickAndHold().moveToElement(lastnight)
				.pause(Duration.ofSeconds(1)).release().build().perform();
	}

	public static void clientConfirmBooking(WebDriver driver, AdminLoginPage loginPage) {
		WebElement closePopup = waitForElementCreation(driver, By.className("ReactModal__Overlay"));
		WebElement closeButton = closePopup.findElement(By.tagName("button"));
		closeButton.click();
	}

}
