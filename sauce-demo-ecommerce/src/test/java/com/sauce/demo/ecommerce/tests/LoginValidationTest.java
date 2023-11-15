package com.sauce.demo.ecommerce.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sauce.demo.ecommerce.pages.LoginPage;
import com.sauce.demo.ecommerce.pages.ProductsPage;
import com.sauce.demo.ecommerce.utils.ExcelReader;
import com.sauce.demo.ecommerce.utils.PropertyReader;

public class LoginValidationTest extends BaseTest {
	
	//Validating login functionality with different user credentials saved in excel file using dataprovider
	//-------------------------------------------
	
	public static Logger logger = LogManager.getLogger(LoginValidationTest.class);
	LoginPage loginPage;
	ProductsPage productsPage;

	@Test
	public void launchTest() {
		driver.get(PropertyReader.retrieveProperty("url"));
		loginPage = new LoginPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("-----New Test started.-----");
		driver.manage().window().maximize();
		Assert.assertTrue(loginPage.isPageLoaded(), "Page not loaded");

	}

	@DataProvider(name = "credentials")
	public Object[][] loginData() {
		Object[][] data = ExcelReader.getTableArray(PropertyReader.retrieveProperty("excelPath"),
				PropertyReader.retrieveProperty("sheetName"));
		return data;
	}

	@Test(dependsOnMethods = "launchTest", dataProvider = "credentials")
	public void validateLogin(String user, String pw) throws InterruptedException {
		loginPage.enterUsername(user);
		loginPage.enterPassword(pw);
		loginPage.clickLogin();
		Thread.sleep(2000);
		
		//Checking which page driver is currently in
		int n=driver.findElements(By.id("react-burger-menu-btn")).size();
		if(n>0) {
			productsPage=new ProductsPage();
			logger.info("Login successful as "+user);
			productsPage.clickMenu();
			loginPage=productsPage.clickLogout();
		}else {
			logger.info("Login failed as "+user);
			driver.navigate().refresh();
		}
	}

}
