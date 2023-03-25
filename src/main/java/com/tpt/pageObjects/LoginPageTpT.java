package com.tpt.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tpt.actionDriver.ActionTpT;
import com.tpt.base.BaseClassTpT;

/**
 *	Author : Llewellyn Thattazhi
 *	Date : 18 March 2023
 **/

public class LoginPageTpT extends BaseClassTpT {
	
	// TpT Login Page Web Elements
	
	@FindBy(id = "UserUsername")
	WebElement usernameField;
	
	@FindBy(id = "UserPassword")
	WebElement passwordField;
	
	@FindBy(css = "input[value='LOG IN']")
	WebElement loginButton;
	
	@FindBy(css = "div[for='UserUsername']")
	WebElement usernameErrorMessage;
	
	@FindBy(css = "div[for='UserPassword']")
	WebElement passwordErrorMessage;
	
	@FindBy(id = "authMessage")
	WebElement usernameEmailCombinationError;
	
	public LoginPageTpT() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePageTpT doLogin(String username, String password) {
		ActionTpT.type(usernameField, username);
		ActionTpT.type(passwordField, password);
		ActionTpT.pressEnter(driver, loginButton);
		return new HomePageTpT();
	}
	
	public String getBlankUsernameErrorMessage() {
		return usernameErrorMessage.getText();
	}
	
	public String getBlankPasswordErrorMessage() {
		return passwordErrorMessage.getText();
	}
	
	public String getUsernameEmailCombinationErrorMessage() {
		return usernameEmailCombinationError.getText();
	}
}
