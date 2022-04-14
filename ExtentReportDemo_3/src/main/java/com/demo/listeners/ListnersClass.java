package com.demo.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demo.base.BaseTest;
import com.demo.extentManager.extentManager;

public class ListnersClass extends extentManager implements ITestListener {

	public void onTestStart(ITestResult result) {
		// test = extent.createTest("googleSearch");
		test = extent.createTest(result.getName()); // Getting the Test-Case name
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " +result.getName());
		}

	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +" - Test Case Failed", ExtentColor.RED));

			String pathString = BaseTest.screenShot(BaseTest.driver, result.getName());
			try {
				test.addScreenCaptureFromPath(pathString);
			} catch (IOException e) {

				e.getMessage();
			}
		}

	}

	public void onTestSkipped(ITestResult result) {

		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " +result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
