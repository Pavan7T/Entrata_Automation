package com.entrata.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
<<<<<<< HEAD
=======
import org.openqa.selenium.support.ui.ExpectedConditions;
>>>>>>> 7f6bd8822b970dcfc49683370e2324558f1ef76c
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.entrata.resources.Constants;

public class DemoPage {

	WebDriver driver;
<<<<<<< HEAD
=======
	WebDriverWait wait;
>>>>>>> 7f6bd8822b970dcfc49683370e2324558f1ef76c

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameField;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailField;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyField;

	@FindBy(xpath = "//input[@id='Phone']")
	WebElement phoneField;

	@FindBy(xpath = "//select[@id='Unit_Count__c']")
	WebElement unitCountField;

	@FindBy(xpath = "//input[@placeholder='Job Title']")
	WebElement jobtitleField;

	@FindBy(xpath = "//select[@id='demoRequest']")
	WebElement demoreqField;

	@FindBy(xpath = "//h1[text()='Optimize Property Management with One Platform']")
	WebElement headerField;

	public DemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
<<<<<<< HEAD
	}

	public String fillform() {

=======
		this.wait=wait;
	}

	public String fillform() {
		
		wait.until(ExpectedConditions.visibilityOf(firstNameField));
>>>>>>> 7f6bd8822b970dcfc49683370e2324558f1ef76c
		firstNameField.sendKeys(Constants.firstName);
		lastNameField.sendKeys(Constants.lastName);
		emailField.sendKeys(Constants.email);
		companyField.sendKeys(Constants.company);
		phoneField.sendKeys(Constants.phone);
		jobtitleField.sendKeys(Constants.jobtitle);

		Select select = new Select(unitCountField);
		select.selectByIndex(1);
		Select select2 = new Select(demoreqField);
		select.selectByIndex(1);

		String header = headerField.getText();
		return header;

	}

}
