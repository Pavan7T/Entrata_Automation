package com.entrata.test;

<<<<<<< HEAD
=======
import org.openqa.selenium.support.ui.ExpectedConditions;
>>>>>>> 7f6bd8822b970dcfc49683370e2324558f1ef76c
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
<<<<<<< HEAD
		String header=page.fillform();
		Assert.assertEquals(header, expectedTitle, "Demo page header does not match!");
		
		System.out.println("TC03: Demo Form fill test case passed !");
		System.out.println("--------------------------------------");
=======
		String header = page.fillform();
		Assert.assertEquals(header, expectedTitle, "Demo page header does not match!");

		System.out.println("TC03: Demo Form fill test case passed !");
		System.out.println("--------------------------------------");

	}

	public void fillOutDemoRequestForm2() throws InterruptedException {
		page = new DemoPage(driver);
		String expectedTitle = "Optimize Property Management with One Platform";
		acceptcookies();
		driver.navigate().to("https://go.entrata.com/watch-demo.html");
		String header = page.fillform();
		Assert.assertEquals(header, expectedTitle, "Demo page header does not match!");

		System.out.println("TC03: Demo Form fill test case passed !");
		System.out.println("--------------------------------------");

>>>>>>> 7f6bd8822b970dcfc49683370e2324558f1ef76c
	}
}
