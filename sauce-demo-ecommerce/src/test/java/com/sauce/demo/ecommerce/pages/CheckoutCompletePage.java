package com.sauce.demo.ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Complete')]")
	WebElement completeHeader;

	@Override
	public boolean isPageLoaded() {
		return completeHeader.isDisplayed();
	}

}
