package com.sauce.demo.ecommerce.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class SauceDemoListener extends TestListenerAdapter{
	public static WebDriver driver;
	public void onTestSuccess(ITestResult tr) {
		ITestNGMethod m=tr.getMethod();
		String methodName=m.getMethodName();
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot,new File("Screenshots/"+methodName+"-successful.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
