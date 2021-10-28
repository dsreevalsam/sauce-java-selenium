package main.java.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.sauce.pagebase.PageBase;

public class _5UserInfoPage extends PageBase{

	@FindBy(css = "[data-test='firstName']")
	WebElement firstName;
	@FindBy(css = "[data-test='lastName']")
	WebElement lastName;
	@FindBy(css = "[data-test='postalCode']")
	WebElement postalCode;
	@FindBy(css = "[data-test='continue']")
	WebElement continueToCheck;
	
	public _5UserInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void addUserinfo(String fname, String lname, String pin) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCode.sendKeys(pin);
	}
	
	public _6CheckoutOverview continueToCheckout() {
		continueToCheck.click();
		return new _6CheckoutOverview(driver);
	}

}
