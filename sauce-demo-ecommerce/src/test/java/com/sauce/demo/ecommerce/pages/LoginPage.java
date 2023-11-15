package com.sauce.demo.ecommerce.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public static final Logger logger=LogManager.getLogger(LoginPage.class);

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement usernameTxtBox;

	@FindBy(id = "password")
	WebElement passwordTxtBox;

	@FindBy(name = "login-button")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[@class='error-button']")
	WebElement errorBtn;

	@Override
	public boolean isPageLoaded() {
		boolean isLoaded=usernameTxtBox.isDisplayed();
		logger.info("Login Page loaded : "+isLoaded);
		return isLoaded;
	}
	public void enterUsername(String user) {
		usernameTxtBox.clear();
		usernameTxtBox.sendKeys(user);
		logger.info("Logging in as "+user);
	}
	public void enterPassword(String pw) {
		passwordTxtBox.clear();
		passwordTxtBox.sendKeys(pw);
	}
	public ProductsPage clickLogin() {
		loginBtn.click();
		return new ProductsPage();
	}
	public boolean isErrorMessagePresent() {
		return errorBtn.isDisplayed();
	}
	
	public ProductsPage loginAsStandardUser() throws InterruptedException {
		usernameTxtBox.sendKeys("standard_user");
		Thread.sleep(3000);
		passwordTxtBox.sendKeys("secret_sauce");
		logger.info("Entered login details for standard user.");
		loginBtn.click();
		Thread.sleep(2000);
		return new ProductsPage();
	}

}
