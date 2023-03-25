package com.tpt.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.tpt.base.BaseClassTpT;

public class HomePageTpT extends BaseClassTpT {
	
	public HomePageTpT() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();	
	}
}
