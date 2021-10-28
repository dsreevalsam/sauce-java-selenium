package main.java.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.sauce.pagebase.PageBase;

public class _6CheckoutOverview extends PageBase{
	@FindBy(css=".inventory_item_name")
	WebElement  productName;
	@FindBy(css=".inventory_item_price")
	WebElement  productPrice;
	
	@FindBy(css=".summary_total_label")
	WebElement  totalPrice;
	@FindBy(css="[data-test='finish']")
	WebElement  finish;
	public _6CheckoutOverview(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public String getName() {
		return productName.getText();
	}
	
	public String getPrice() {
		return productPrice.getText();
	}
	
	public String getTotal() {
		return totalPrice.getText();
	}
	public _7CheckoutCompletePage finish() {
		finish.click();
		return new _7CheckoutCompletePage(driver);
	}

}
