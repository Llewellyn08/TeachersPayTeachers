package com.tpt.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tpt.actionDriver.ActionTpT;
import com.tpt.base.BaseClassTpT;


public class IndexPageTpT extends BaseClassTpT {

	@FindBy(css = "div[class='PrimaryHeaderLayout__Logo--rebrand'] a[title='TPT']")
	WebElement tptLogo;
	
	@FindBy(xpath = "//a[normalize-space()='Log In']")
	WebElement loginLink;
	
	public IndexPageTpT() {
		PageFactory.initElements(driver , this);
	}
	
	public void getTitle() {
		String actualResult = driver.getTitle();
		String expectedResult = "Teaching Resources & Lesson Plans | TPT";
		
		//Printing data on report
		extentInfoLog("Actual Title : ", actualResult);
		extentInfoLog("Expected Title : ", expectedResult);

		//Assertion
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	public void validateLogo() {
		boolean result = ActionTpT.isDisplayed(driver, tptLogo);
		
		//Printing data on report
		extentInfoLog("Is logo displayed : ", result);

		//Assertion
		Assert.assertTrue(result);
	}
	
	public LoginPageTpT clickOnLogin() {
		ActionTpT.explicitWaitForElementTobeclickable(loginLink, 5);
		ActionTpT.mouseOverElement(driver, loginLink);
		ActionTpT.click(driver, loginLink);
		return new LoginPageTpT();
	}
	
}
