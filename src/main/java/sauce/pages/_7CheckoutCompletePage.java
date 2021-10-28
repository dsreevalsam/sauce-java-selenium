package main.java.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.sauce.pagebase.PageBase;

public class _7CheckoutCompletePage extends PageBase{
	@FindBy(css=".complete-header")
	WebElement  completeHeader;
	
	public _7CheckoutCompletePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getSuccessMessage() {
		return completeHeader.getText();
	}

}
