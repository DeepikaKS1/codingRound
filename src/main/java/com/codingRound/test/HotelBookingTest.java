package com.codingRound.test;

import com.codingRound.common.CommonUtils;
import com.codingRound.pageobjects.HotelsBookingObjects;
import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {
	WebDriver driver;
	CommonUtils commonUtils;

	public HotelBookingTest() {
		driver = new ChromeDriver();
		commonUtils = new CommonUtils();

	}

	@Test
	public void shouldBeAbleToSearchForHotels() {

		commonUtils.setDriverPath();
		HotelsBookingObjects hotelObjs = new HotelsBookingObjects(driver);

		driver.get("https://www.cleartrip.com/");
		commonUtils.waitFor(5000);

		hotelObjs.hotelLink.click();
		hotelObjs.localityTextBox.sendKeys("Indiranagar, Bangalore");

		new Select(hotelObjs.travellerSelection).selectByVisibleText("1 room, 2 adults");
		commonUtils.waitFor(2000);
		hotelObjs.searchButton.click();

		driver.quit();

	}

}
