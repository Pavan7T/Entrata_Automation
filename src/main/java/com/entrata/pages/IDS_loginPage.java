package com.entrata.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IDS_loginPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@id='txtLoginname']")
	WebElement userid;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='btnSubmit']")
	WebElement submit;

	public IDS_loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void enterUserId(String username) {
		wait.until(ExpectedConditions.visibilityOf(userid));
		userid.sendKeys(username);
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}

	public void submitt() {
		wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();
	}
}
