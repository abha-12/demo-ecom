package com.sauce.demo.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public abstract class BasePage {
	public static WebDriver driver;

	public BasePage() {
		PageFactory.initElements(driver, this);
	}

	abstract boolean isPageLoaded();

}
