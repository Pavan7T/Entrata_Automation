package com.entrata.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.entrata.pages.IDS_loginPage;
import com.entrata.resources.ReadExcelUtils;

public class IDS_loginTest {

	IDS_loginPage IDS_loginPage;
	WebDriver driver;

	@BeforeTest
	public void init() {
		driver = new FirefoxDriver();

	}

	// @AfterTest
	public void teardown() {
		driver.close();
	}

	@Test(dataProvider = "data-provider")
	public void loginToIDS(String username, String password) {
		driver.get("http://localhost/Add_Annex_his");
		IDS_loginPage = new IDS_loginPage(driver);
		IDS_loginPage.enterUserId(username);
		IDS_loginPage.enterPassword(password);
		IDS_loginPage.submitt();
	}

	@DataProvider(name = "data-provider")
	public Object[][] data() throws IOException {
		return ReadExcelUtils.getExcelData("src/test/resources/loginData.xlsx", "Sheet1");
	}

	/*
	 * @DataProvider(name = "data-provider") public Object[][] data() { return new
	 * Object[][] { { "test.n", "test123" }, { "super", "super123" }, { "admin",
	 * "edpsoftlink" } }; }
	 */

}
