package com.entrata.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.entrata.pages.HomePage;

public class NavigationTests extends BaseTest {

	@Test
	public void verifyHomePageTitle() {

		acceptcookies();
		String expectedTitle = "Property Management Software | Entrata";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Home page title does not match!");
		
		System.out.println("TC01: Home page Test passed !");
		System.out.println("--------------------------------------");
	}

	@Test
	public void navigateToSignInPage() {
		acceptcookies();
		HomePage page = new HomePage(driver);
		String actualTitle = page.gotoSignin();
		System.out.println(actualTitle);
		
		Assert.assertTrue(actualTitle.contains("Entrata Sign In"), "Failed to navigate to Signin page!");
		System.out.println("TC02: Navigation to sign in page Test passed !");
		System.out.println("--------------------------------------");
	}
}
