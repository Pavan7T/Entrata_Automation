package com.entrata.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
<<<<<<< HEAD
import org.testng.annotations.Parameters;
=======
>>>>>>> 7f6bd8822b970dcfc49683370e2324558f1ef76c

import com.entrata.resources.Constants;

public class BaseTest {
	protected WebDriver driver;
	WebDriverWait wait;
	Properties prop;

<<<<<<< HEAD
	/*
	 * @Parameters({"browser"})
	 * 
	 * @BeforeMethod public void setup() { // ChromeOptions options = new
	 * ChromeOptions(); // options.addArguments("--incognito"); // driver = new
	 * FirefoxDriver(); // driver.manage().window().maximize(); //
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //
	 * driver.get(Constants.url);
	 * 
	 * browserInit(String browser); }
	 */

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Constants.url);
	}
	

	/*
	 * public void browserInit(String browser) {
	 * 
	 * String browserName = Constants.browser; if
	 * (browserName.equalsIgnoreCase("chrome")) {
	 * 
	 * driver = new ChromeDriver(); } else if (browserName.equalsIgnoreCase("FF")) {
	 * 
	 * driver = new FirefoxDriver(); }
	 * 
	 * driver.manage().deleteAllCookies();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * driver.get(Constants.url);
	 * 
	 * }
	 */
	
	
=======
	@BeforeMethod
	public void setup() {
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--incognito");
		//driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//driver.get(Constants.url);
		browserInit();
	}

	public void browserInit() {

		String browserName = Constants.browser;
		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FF")) {

			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(Constants.url);

	}

>>>>>>> 7f6bd8822b970dcfc49683370e2324558f1ef76c
	public void acceptcookies() {

		WebElement acceptCookiesButton = driver.findElement(By.id("cookie-accept"));
		acceptCookiesButton.click();
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
