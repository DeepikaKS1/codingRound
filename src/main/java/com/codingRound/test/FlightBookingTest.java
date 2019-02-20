package com.codingRound.test;

import com.codingRound.common.CommonUtils;
import com.codingRound.pageobjects.FlightBookingObjects;
import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest {

	WebDriver driver;
	CommonUtils commonUtils;

	public FlightBookingTest() {
		driver = new ChromeDriver();
		commonUtils = new CommonUtils();
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		commonUtils.setDriverPath();
		driver.get("https://www.cleartrip.com/");
		commonUtils.waitFor(2000);
		FlightBookingObjects flightobjs = new FlightBookingObjects(driver);
		flightobjs.oneWay.click();
		flightobjs.fromTag.clear();
		flightobjs.fromTag.sendKeys("Bangalore");
		// wait for the auto complete options to appear for the origin
		commonUtils.waitFor(2000);
		List<WebElement> originOptions = flightobjs.fromDropDown.findElements(By.tagName("li"));
		commonUtils.waitFor(2000);
		originOptions.get(0).click();

		flightobjs.toTag.clear();
		
		flightobjs.toTag.sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination

		commonUtils.waitFor(2000);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = flightobjs.toDropDown.findElements(By.tagName("li"));
		commonUtils.waitFor(3000);
		destinationOptions.get(0).click();
		commonUtils.waitFor(2000);
		flightobjs.datePicker.click();
		commonUtils.waitFor(2000);
		// all fields filled in. Now click on search
		flightobjs.searchBtn.click();

		commonUtils.waitFor(2000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));

		// close the browser
		driver.quit();

	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
