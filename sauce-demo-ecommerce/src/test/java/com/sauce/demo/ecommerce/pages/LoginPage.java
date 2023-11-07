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

	@Override
	public boolean isPageLoaded() {
		return usernameTxtBox.isDisplayed();
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
