package com.sauce.demo.ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Overview')]")
	WebElement overviewHeader;

	@FindBy(id = "finish")
	WebElement finishBtn;

	@Override
	public boolean isPageLoaded() {
		return overviewHeader.isDisplayed();
	}

	public CheckoutCompletePage clickFinish() throws InterruptedException {
		finishBtn.click();
		Thread.sleep(2000);
		return new CheckoutCompletePage();
	}

}
