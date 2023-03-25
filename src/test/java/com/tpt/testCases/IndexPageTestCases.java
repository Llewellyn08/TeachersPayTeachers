package com.tpt.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tpt.base.BaseClassTpT;
import com.tpt.pageObjects.IndexPageTpT;

public class IndexPageTestCases extends BaseClassTpT {
	
	IndexPageTpT index;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
		index = new IndexPageTpT();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 0,description = "Check if the logo is present", enabled=true)
	public void INDEX_verifyLogo() {
		index = new IndexPageTpT();
		index.validateLogo();
	}
	
	@Test(priority = 0, description = "Check Title of the Page", enabled=true)
	public void INDEX_verifyTitle() {
		index = new IndexPageTpT();
		index.getTitle();
	}
	
	
	

	

}
