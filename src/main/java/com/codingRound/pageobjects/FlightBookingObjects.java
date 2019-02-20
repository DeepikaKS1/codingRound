package com.codingRound.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingObjects {

	public FlightBookingObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="OneWay")
	public WebElement oneWay;
	
	@FindBy(id="FromTag")
	public WebElement fromTag;
	
	@FindBy(id="ui-id-1")
	public WebElement fromDropDown;
	
	@FindBy(id="ToTag")
	public WebElement toTag;
	
	@FindBy(id="ui-id-2")
	public WebElement toDropDown;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]/a")
	public WebElement datePicker;
	
	@FindBy(id="SearchBtn")
	public WebElement searchBtn;
	
}
