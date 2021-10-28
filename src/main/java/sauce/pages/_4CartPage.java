package main.java.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.sauce.pagebase.PageBase;

public class _4CartPage  extends PageBase{
	@FindBy(css=".inventory_item_name")
	WebElement  productName;
	@FindBy(css=".inventory_item_price")
	WebElement  productPrice;
	@FindBy(css = "[data-test='checkout']")
	WebElement checkout;
	
	public _4CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getName() {
		return productName.getText();
	}
	
	public String getPrice() {
		return productPrice.getText();
	}
	
	public _5UserInfoPage checkout() {
		checkout.click();
		return new _5UserInfoPage(driver);
	}

}
