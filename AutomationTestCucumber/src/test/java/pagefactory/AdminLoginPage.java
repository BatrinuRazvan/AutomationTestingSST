package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "doLogin")
	WebElement loginButton;

	WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void inputUsername(String username) {
		this.username.sendKeys(username);
	}

	public void inputPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLogin() {
		this.getLoginButton().click();
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
