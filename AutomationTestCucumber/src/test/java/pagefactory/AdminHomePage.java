package pagefactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefinitions.StepDefHelper;

public class AdminHomePage {

	@FindBy(tagName = "li")
	WebElement logoutButton;

	@FindBy(id = "createRoom")
	WebElement createButton;

	@FindBy(id = "roomPrice")
	WebElement roomPrice;

	Select type;
	Select accessible;
	WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		this.logoutButton.click();
	}

	public void inputRoomNumber(Integer room) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement roomNumber = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("roomName")));
		roomNumber.sendKeys("" + room);
	}

	public void setType(String string) {
		this.type = new Select(driver.findElement(By.id("type")));
		type.selectByVisibleText(string);
	}

	public void setAccessible(boolean b) {
		this.accessible = new Select(driver.findElement(By.id("accessible")));
		accessible.selectByVisibleText("" + b);
	}

	public void setPrice(Integer price) {
		this.roomPrice.sendKeys("" + price);
	}

	public void setDetails(List<String> details) {
		for (String detail : details) {
			String currentId = StepDefHelper.getIdFromDetail(detail);
			driver.findElement(By.id(currentId)).click();
		}
	}

	public void clickCreate() {
		this.createButton.click();
	}

}
