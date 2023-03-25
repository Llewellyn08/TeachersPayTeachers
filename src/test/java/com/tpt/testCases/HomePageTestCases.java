package com.tpt.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tpt.base.BaseClassTpT;
import com.tpt.pageObjects.HomePageTpT;
import com.tpt.pageObjects.IndexPageTpT;
import com.tpt.pageObjects.LoginPageTpT;

public class HomePageTestCases extends BaseClassTpT {
	
	HomePageTpT home;
	LoginPageTpT login;
	IndexPageTpT index;
	
	@BeforeMethod
	public void setup() {
		launchApplication();
		index = new IndexPageTpT();
		login = new LoginPageTpT();
		home = new HomePageTpT();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
