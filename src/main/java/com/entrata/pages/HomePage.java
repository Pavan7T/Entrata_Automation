package com.entrata.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//section[@class='main-section hp']//a[@class='signin-button mb-full'][normalize-space()='Sign In']")
	WebElement SignInField;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	public String gotoSignin() {
		SignInField.click();
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

}
