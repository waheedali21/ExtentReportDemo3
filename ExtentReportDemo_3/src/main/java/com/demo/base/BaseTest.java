package com.demo.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.demo.extentManager.extentManager;
import com.demo.utils.Log;

public class BaseTest {

	public static WebDriver driver;

	@BeforeSuite
	public static void beforeSuite() {
 
		extentManager.setUpExtentReport();

		// DOMConfigurator.configure(System.getProperty("user.dir") + "\\log4j.xml");
		// //log4j.xml file path
		DOMConfigurator.configure("log4j.xml");
		Log.info("This is beforeSuite method");

	}

	@AfterSuite
	public void afterSuite() {
		extentManager.endReport();
		Log.info("This is afterSuite method");
	
	}

	// Method for Launch the browser(s)
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://google.com");
	}

	// ScreentShot utility
	public static String screenShot(WebDriver driver, String filename) { 
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" +filename+ "_" +BaseTest.getCurrentTime()+ ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

	
	// Utility that helps to current time while taking snapshot
	// public static void getCurrentTime() {
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		return currentDate;
	}
}
