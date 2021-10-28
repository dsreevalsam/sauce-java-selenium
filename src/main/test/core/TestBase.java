package main.test.core;

import java.util.Collections;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver;
	private static final String CONFIG_FILENAME="config";
	private static final String INPUT_FILENAME="input";
	protected ResourceBundle configPropObj = ResourceBundle.getBundle(CONFIG_FILENAME);
	protected ResourceBundle inputPropObj = ResourceBundle.getBundle(INPUT_FILENAME);
	

	public void initWebDriver(String browser) {
		try {
		switch (browser.toUpperCase()) {
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			TestBase.driver = new FirefoxDriver();
			break;
		case "CHROME":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			options.addArguments("disable-infobars");
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			WebDriverManager.chromedriver().setup();
			TestBase.driver = new ChromeDriver(options);
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			TestBase.driver = new InternetExplorerDriver();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			TestBase.driver = new EdgeDriver();
			break;
		default:
			throw (new Exception("Browser Not Found"));
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		TestBase.driver = driver;
	}

	public String getConfigProperty(String Key) {
		String res = null;
		try {
			res = configPropObj.getString(Key);
		} catch (Exception Ex) {
			System.out.println("[ERROR] Expected Key " + Key + " does not exist in the properties file, returning null!");
		}
		return res;
	}
	public String getInputProperty(String Key) {
		String res = null;
		try {
			res = inputPropObj.getString(Key);
		} catch (Exception Ex) {
			System.out.println("[ERROR] Expected Key " + Key + " does not exist in the properties file, returning null!");
		}
		return res;
	}

}
