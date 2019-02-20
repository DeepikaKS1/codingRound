package com.codingRound.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInObjects {
	public SignInObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Your trips")
	public WebElement yourTrips;
	
	@FindBy(id="SignIn")
	public WebElement signIn;
	
	@FindBy(id="signInButton")
	public WebElement signInBtn;
	
	@FindBy(id="errors1")
	public WebElement errors;
}
