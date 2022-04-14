package com.demo.extentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demo.base.BaseTest;

public class extentManager {

	// Step#1 - Extent 4.0.9v classes
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setUpExtentReport() {

		// file path for generating the extent report in HTML format
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport\\MyReport"
				+ BaseTest.getCurrentTime() + ".html");

		//in *xml* file we have define the Extent-Report theme
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");

	/*
		 * // set the reports parameters
		 * htmlReporter.config().setDocumentTitle("Automation Test Report");
		 * htmlReporter.config().setReportName("Google Test Automation Report");
		 * htmlReporter.config().setTheme(Theme.DARK); // DARK or STANDARD
	 */
		
		
		// **step#2 (attached extent to test cases) but create object of ExtentReports
		// class ExtentReports object
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		// ** Set some more parameter for Environment
		extent.setSystemInfo("HostName", "Ali Waheed");
		extent.setSystemInfo("ProjectName", "Google Search");
		extent.setSystemInfo("QA Engineer", "Waheed");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}

}
