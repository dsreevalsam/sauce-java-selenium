package main.java.sauce.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import main.java.sauce.pagebase.PageBase;

public class _2InventoryPage extends PageBase {

	@FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
	WebElement addBackPacktoCartButton;
	@FindBy(id = "react-burger-menu-btn")
	WebElement menuButton;
	@FindBy(css = "#logout_sidebar_link")
	WebElement logoutButton;
	@FindBy(css = "span.title")
	WebElement invTitle;
	@FindBy(css = ".inventory_item_name")
	List<WebElement> productElement;

	String productPrice = "//div[text()='productname']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']";

	public _2InventoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isInventoryLoaded() {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addBackPacktoCartButton));
		} catch (Exception e) {
			System.out.println("Inventory Page Load Timeout");
		}

		if (invTitle.getText().equalsIgnoreCase("products"))
			flag = true;
		return flag;

	}

	public _3ProductDetails openProduct(String prodName) {
		_3ProductDetails prodDetails = null;
		for (WebElement elem : productElement)
			if (elem.getText().equalsIgnoreCase(prodName)) {
				elem.click();
				prodDetails = new _3ProductDetails(driver);
				break;
			}

		return prodDetails;
	}

	public String getPriceOfProduct(String prodName) {
		String prod = productPrice.replace("productname", prodName);
		return driver.findElement(By.xpath(prod)).getText();
	}

	public void logout() {
		menuButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logoutButton);

	}

}
