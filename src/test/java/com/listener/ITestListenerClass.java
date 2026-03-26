package com.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.reusableclass.BaseClass;


public class ITestListenerClass extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	    try {
	        String path = BaseClass.takeScreenshot(result.getMethod().getMethodName());

	        ExtentReport_Test.extentTest.pass(result.getMethod().getMethodName() + " : Test Passed",
	            MediaEntityBuilder.createScreenCaptureFromPath(path).build()
	        );

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    try {
	        String path = BaseClass.takeScreenshot(result.getMethod().getMethodName());

	        ExtentReport_Test.extentTest.fail(
	            result.getMethod().getMethodName() + " : Test Failed",
	            MediaEntityBuilder.createScreenCaptureFromPath(path).build()
	        );

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	
}
