package com.demo.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.BaseTest;
import com.demo.extentManager.extentManager;
import com.demo.utils.Log;

public class TestCase1 extends BaseTest {

	@BeforeMethod
	public void beforeMethod() {
		// calling the browser launch method
		BaseTest.setUp();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// **Some Test case here

	@Test
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");

		// that we will be mentioning in Listener class instead putting in each test
		// case
		// test = extent.createTest("verifyTitle"); // **test** is in base class
		// *ExtentTest test*

		Log.info("Getting the title of the page");
		String actualTitle = driver.getTitle();

		Log.info("Print page title");
		System.out.println("Actual Title:" + actualTitle);

		Log.info("Validate the page title");
		Assert.assertEquals(actualTitle, driver.getTitle());
		Log.info("Page title is validated correctly");
		Log.endTestCase("verifyTitle");
	}

	@Test
	public void googleSearch() {
		// that we will be mentioning in Listener class instead putting in each test
		// test = extent.createTest("googleSearch");

		extentManager.test.createNode("Searching the google"); // add steps to Extent Report
		extentManager.test.createNode("Enter some text to search");
		driver.findElement(By.name("qy")).sendKeys("Extent Reports");

	}

	@Test
	public void verifyURL() {

		// that we will be mentioning in Listener class instead putting in each test
		// test = extent.createTest("verifyURL");

		extentManager.test.createNode("Getting the page title"); // add steps to Extent Report
		String actualURL = driver.getCurrentUrl();

		extentManager.test.createNode("Print the page title"); // For steps Listener don't support we can use like that
		System.out.println("Current page url: " + actualURL);

		extentManager.test.createNode("Validate the page title");
		Assert.assertEquals(actualURL, driver.getCurrentUrl());

	}

}
