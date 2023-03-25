package com.tpt.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tpt.base.BaseClassTpT;
import com.tpt.dataProvider.DataProvidersTpT;
import com.tpt.pageObjects.HomePageTpT;
import com.tpt.pageObjects.IndexPageTpT;
import com.tpt.pageObjects.LoginPageTpT;

public class LoginPageTestCases extends BaseClassTpT {
	
	IndexPageTpT index;
	LoginPageTpT login;
	HomePageTpT home;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
		index = new IndexPageTpT();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1, description = "Check the functionality of Login Page", dataProvider = "Credentials", 
			dataProviderClass = DataProvidersTpT.class)
	public void LOGIN_verifyLoginPage(String flag, String testcase, String username, String password) {
		if(flag.contains("1")) {
		    // Blank Login
		    login = index.clickOnLogin();
		    home = login.doLogin(username, password);

		    // Printing Data on the report
		    extentInfoLog("Test-case name = ", testcase);
		    extentInfoLog("Actual Email entered = ", username);
		    extentInfoLog("Actual Password entered = ", password);

		    // Initializing the username/email values
		    String actualBlankUsernameErrorMessage = login.getBlankUsernameErrorMessage();
		    String expectedBlankUsernameErrorMessage = "* The email or username is missing!";

		    //Assertion for username/email
		    Assert.assertEquals(actualBlankUsernameErrorMessage, expectedBlankUsernameErrorMessage);

		    //Printing Data on the report
		    extentInfoLog("Actual Error Message for Email = ", actualBlankUsernameErrorMessage);
		    extentInfoLog("Expected Error Message for Email = ", expectedBlankUsernameErrorMessage);

		    //Initializing the password values
		    String actualBlankPasswordErrorMessage = login.getBlankPasswordErrorMessage();
		    String expectedBlankPasswordErrorMessage = "* The password is missing!";

		    //Assertion for password
		    Assert.assertEquals(actualBlankPasswordErrorMessage, expectedBlankPasswordErrorMessage);

		    //Printing Data on the report
		    extentInfoLog("Actual Error Message for Password", actualBlankPasswordErrorMessage);
		    extentInfoLog("Expected Error Message for Password", expectedBlankPasswordErrorMessage);
		}
		else if(flag.contains("2")) {
		    // Invalid Email ID
		    login = index.clickOnLogin();
		    home = login.doLogin(username, password);

		    extentInfoLog("Test-case name = ", testcase);
		    extentInfoLog("Actual Email entered = ", username);
		    extentInfoLog("Actual Password entered = ", password);

		    String actualInvalidErrorMessage = login.getBlankUsernameErrorMessage();
		    String expectedInvalidErrorMessage = "* Please enter a valid email address.";
		    Assert.assertEquals(actualInvalidErrorMessage, expectedInvalidErrorMessage);

		    extentInfoLog("Actual Error Message = ", actualInvalidErrorMessage);
		    extentInfoLog("Expected Error Message = ", expectedInvalidErrorMessage);
		}
		else if(flag.contains("3")) {
		    // Username not registered in system
		    login = index.clickOnLogin();
		    home = login.doLogin(username, password);

		    extentInfoLog("Test-case name = ", testcase);
		    extentInfoLog("Actual Email entered = ", username);
		    extentInfoLog("Actual Password entered = ", password);

		    String actualInvalidUsernameErrorMessage = login.getUsernameEmailCombinationErrorMessage();
		    String expectedInvalidUsernameErrorMessage = "The username/password combination doesn't match.";
		    Assert.assertEquals(actualInvalidUsernameErrorMessage, expectedInvalidUsernameErrorMessage);

		    extentInfoLog("Actual Error Message = ", actualInvalidUsernameErrorMessage);
		    extentInfoLog("Expected Error Message = ", expectedInvalidUsernameErrorMessage);
		}
		else if(flag.contains("4")) {
		    // Email ID not registered in system
		    login = index.clickOnLogin();
		    home = login.doLogin(username, password);

		    extentInfoLog("Test-case name = ", testcase);
		    extentInfoLog("Actual Email entered = ", username);
		    extentInfoLog("Actual Password entered = ", password);

		    String actualInvalidEmailErrorMessage = login.getUsernameEmailCombinationErrorMessage();
		    String expectedInvalidEmailErrorMessage = "The email/password combination doesn't match.";
		    Assert.assertEquals(actualInvalidEmailErrorMessage, expectedInvalidEmailErrorMessage);

		    extentInfoLog("Actual Error Message = ", actualInvalidEmailErrorMessage);
		    extentInfoLog("Expected Error Message = ", expectedInvalidEmailErrorMessage);
	    
		    if (flag.equals("5")) {
		        // Valid Username Test
		        login = index.clickOnLogin();
		        home = login.doLogin(username, password);

		        //Printing data on report
		        extentInfoLog("Test-case name = ", testcase);
		        extentInfoLog("Actual Username entered = ", username);
		        extentInfoLog("Actual Password entered = ", password);

		        String actualURLUsername = home.getCurrentURL();
		        String expectedURLUsername = "https://www.example.com/";

		        //Assertion
		        Assert.assertEquals(actualURLUsername, expectedURLUsername);

		        //Printing data on report
		        extentInfoLog("Actual URL = ", actualURLUsername);
		        extentInfoLog("Expected URL = ", expectedURLUsername);
		    }
		    else if (flag.contains("6")) {
		        // Valid Email ID Test
		        login = index.clickOnLogin();
		        home = login.doLogin(username, password);

		        //Printing data on report
		        extentInfoLog("Test-case name = ", testcase);
		        extentInfoLog("Actual Email entered = ", username);
		        extentInfoLog("Actual Password entered = ", password);

		        String actualURLEmail = home.getCurrentURL();
		        String expectedURLEmail = "https://www.example.com/";

		        //Assertion
		        Assert.assertEquals(actualURLEmail, expectedURLEmail);

		        //Printing data on report
		        extentInfoLog("Actual URL = ", actualURLEmail);
		        extentInfoLog("Expected URL = ", expectedURLEmail);
		    }
	    
		}
	}
	

}
