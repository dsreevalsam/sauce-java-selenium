package main.java.sauce.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.java.sauce.pagebase.PageBase;

public class _1LoginPage extends PageBase {

	@FindBy(css = "[data-test='username']")
	WebElement usernameInput;
	@FindBy(css = "[data-test='password']")
	WebElement passwordInput;
	@FindBy(css = "[data-test='login-button']")
	WebElement loginButton;
	@FindBy(css = "[data-test='error']")
	WebElement errorMessage;

	public _1LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void gotoLoginPage(String url) {
		driver.get(url);
	}

	public _2InventoryPage login(String username, String password) {
		usernameInput.clear();
		usernameInput.sendKeys(username);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginButton);
		} catch (Exception e) {
			Assert.assertFalse(true,"Page Timeout");
		}
		return new _2InventoryPage(driver);
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

}
