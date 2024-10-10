package com.entrata.test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RevisionClass {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void LoginTO() {
		driver.get("https://www.madisonlogic.com/");
		WebElement closeBtn = driver.findElement(By.xpath("(//button[@aria-label='Close'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(closeBtn));
		closeBtn.click();

		WebElement logo = driver.findElement(By.xpath("(//a[@class='logo'])[1]"));

		Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
		// Assert.assertTrue(false, null)

	}

	// @Test
	public void actions_task() throws InterruptedException {
		driver.get("https://www.madisonlogic.com/");
		WebElement closeBtn = driver.findElement(By.xpath("(//button[@aria-label='Close'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(closeBtn));
		closeBtn.click();
	

		Actions actions = new Actions(driver);
		WebElement company = driver.findElement(By.xpath("(//span[@class='a'])[4]"));
		actions.moveToElement(company).perform();
		actions.keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).perform();

		WebElement aboutus = driver.findElement(By.linkText("About Us"));
		wait.until(ExpectedConditions.visibilityOf(aboutus));
		actions.click(aboutus).perform();

		// actions.sendKeys(Keys.F5).perform();

		// Assert.assertFalse(logo.isDisplayed(), "Logo is not displayed");
		// Assert.assertTrue(false, null)

	}

	@Test
	public void Slider_task() {
		driver.get("https://demoqa.com/slider");
		WebElement slider = driver.findElement(By.cssSelector(".range-slider"));

		// Create an Actions object
		Actions actions = new Actions(driver);

		// Move to the slider and click-hold-drag-release to a new position
		actions.clickAndHold(slider) // Hold the slider handle
				.moveByOffset(100, 0) // Move the slider handle by 50px (adjust as needed)
				.release() // Release the handle to set the value
				.perform();
	}

	@Test
	public void windows_task() {
		driver.get("https://demoqa.com/browser-windows");
		String originalWindowHandle = driver.getWindowHandle();

		WebElement Tab1 = driver.findElement(By.xpath("//button[@id='tabButton']")); // h1[text()='This is a sample
		wait.until(ExpectedConditions.visibilityOf(Tab1)); // page']
		// WebElement Tab2 =
		// driver.findElement(By.xpath("//button[@id='windowButton']"));
		// wait.until(ExpectedConditions.visibilityOf(Tab2));
		WebElement Tab3 = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		wait.until(ExpectedConditions.visibilityOf(Tab3));

		Tab1.click();
		// Tab2.click();
		Tab3.click();

		Set<String> windowhandles = driver.getWindowHandles();

		for (String handle : windowhandles) {

			driver.switchTo().window(handle);
			String currenturl = driver.getCurrentUrl();

			if (!handle.contains(originalWindowHandle)) {
				if (currenturl.contains("sample")) {
					WebElement h1 = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
					wait.until(ExpectedConditions.visibilityOf(h1));
					String header = h1.getText();
					System.out.println("1st wibndow text : " + header);
				}

				else if (driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]")).isDisplayed()) {
					WebElement h2 = driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]"));
					wait.until(ExpectedConditions.visibilityOf(h2));
					String header = h2.getText();
					System.out.println("3rd wibndow text : " + header);
				}

			}

		}

		driver.switchTo().window(originalWindowHandle);
		System.out.println("Current window title: " + driver.getTitle());

		driver.quit();
	}

	@Test
	public void frameTask() {

		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame("frame1");
		String frameContent = driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Frame Conent: " + frameContent);
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.getTitle(), "DEMOQA");

	}

	@BeforeTest
	public void init() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//

	}
}
