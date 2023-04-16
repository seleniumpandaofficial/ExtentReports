package extentlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

import extentreporter.ExtentReporter;

public class MyListener implements ITestListener{
	
	
	@Override
	public void onStart(ITestContext context) {
	System.out.println("Operation Started");	
	try {
		ExtentReports extentReport = ExtentReporter.generateExtentReport();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	

	@Override
	public void onTestStart(ITestResult result) {
	String testName = result.getName();
	System.out.println(testName + "-> started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + "-> passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + "-> skipped");	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Operation Finished");		
	}

}
