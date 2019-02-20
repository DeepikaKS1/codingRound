package com.codingRound.test;

import com.codingRound.common.CommonUtils;
import com.codingRound.pageobjects.SignInObjects;
import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {
	CommonUtils commonUtils;
	WebDriver driver;
	WebDriverWait wait;

	public SignInTest() {
		// TODO Auto-generated constructor stub
		commonUtils = new CommonUtils();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		commonUtils.setDriverPath();

		driver.get("https://www.cleartrip.com/");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your trips")));
		SignInObjects signinObjs = new SignInObjects(driver);
		signinObjs.yourTrips.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SignIn")));
		signinObjs.signIn.click();
		commonUtils.waitFor(2000);
		driver.switchTo().frame("modal_window");
		signinObjs.signInBtn.click();
		String errors1 = signinObjs.errors.getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		driver.quit();
	}

}
