package com.sauce.demo.ecommerce.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.sauce.demo.ecommerce.listener.SauceDemoListener;
import com.sauce.demo.ecommerce.pages.BasePage;
import com.sauce.demo.ecommerce.utils.PropertyReader;
@Listeners(SauceDemoListener.class)
public class BaseTest {
	protected WebDriver driver;
	@BeforeSuite(alwaysRun = true)
	public void init() {
	String browser=PropertyReader.retrieveProperty("browser");
	if(browser.equals("chrome")) {
		String path=PropertyReader.retrieveProperty("chromePath");
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
	}
	BasePage.driver=driver;
	SauceDemoListener.driver=driver;
	}
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
	

}
