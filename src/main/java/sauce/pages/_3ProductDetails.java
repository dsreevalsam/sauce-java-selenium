package main.java.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.sauce.pagebase.PageBase;

public class _3ProductDetails extends PageBase{

	@FindBy(css=".inventory_details_name")
	WebElement  productName;
	@FindBy(css=".inventory_details_price")
	WebElement  productPrice;
	@FindBy(css=".btn_inventory")
	WebElement  addRemoveCart;
	@FindBy(css = ".shopping_cart_badge")
	WebElement shoppingCart;
	
	
	
	public _3ProductDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public String getName() {
		return productName.getText();
	}
	
	public String getPrice() {
		return productPrice.getText();
	}
	
	public void addOrRemoveCart() {
		addRemoveCart.click();
	}
	
	public String getCartItems() {
		return shoppingCart.getText();
	}

	public _4CartPage gotoCart() {
		shoppingCart.click();
		return new _4CartPage(driver);
	}

}
