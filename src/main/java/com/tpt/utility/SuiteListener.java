package com.tpt.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tpt.actionDriver.ActionTpT;
import com.tpt.base.BaseClassTpT;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class SuiteListener extends ExtentManager implements ITestListener{

	ActionTpT action= new ActionTpT();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is : " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Failed Test case is : "+result.getName(), ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Test Case Failed : "+result.getThrowable(), ExtentColor.RED));

			String imgPath = action.screenShot(BaseClassTpT.driver, result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is : " + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}