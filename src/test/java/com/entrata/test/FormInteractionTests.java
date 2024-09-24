package com.entrata.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.entrata.pages.DemoPage;

public class FormInteractionTests extends BaseTest {
	DemoPage page;

	@Test
	public void fillOutDemoRequestForm() throws InterruptedException {
		page = new DemoPage(driver);
		String expectedTitle = "Optimize Property Management with One Platform";
		acceptcookies();
		driver.navigate().to("https://go.entrata.com/watch-demo.html");
		String header = page.fillform();
		Assert.assertEquals(header, expectedTitle, "Demo page header does not match!");

		System.out.println("TC03: Demo Form fill test case passed !");
		System.out.println("--------------------------------------");

	}

	public void fillOutDemoRequestForm() throws InterruptedException {
		page = new DemoPage(driver);
		String expectedTitle = "Optimize Property Management with One Platform";
		acceptcookies();
		driver.navigate().to("https://go.entrata.com/watch-demo.html");
		String header = page.fillform();
		Assert.assertEquals(header, expectedTitle, "Demo page header does not match!");

		System.out.println("TC03: Demo Form fill test case passed !");
		System.out.println("--------------------------------------");

	}
}
