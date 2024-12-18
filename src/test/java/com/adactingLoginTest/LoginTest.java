package com.adactingLoginTest;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.base.BaseClass;
import com.pages.*;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BookHotel {
	BaseClass bs;
	LoginPage loginPage;
	SearchHotel searchHotel;

	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		System.out.println("BeforeMethod");
		bs = new BaseClass();
		bs.launchBrowser(browser);
	}

	@Test(priority = 1, enabled = true)
	public void tc_001() {
		// verify the Login with valid username and valid password
		loginPage = new LoginPage();
		bs.enterText(loginPage.getUsername(), "Francis3535");
		bs.enterText(loginPage.getPassword(), "Francis@123");
		loginPage.getLoginBtn().click();

		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("SearchHotel");
		Assert.assertTrue(contains);

	}

	@Test(priority = 2, enabled = true)
	public void tc_002() {
		// verify the Login with valid username and valid password
		loginPage = new LoginPage();
		bs.enterText(loginPage.getUsername(), "Francis353");
		bs.enterText(loginPage.getPassword(), "Francis@123");
		loginPage.getLoginBtn().click();

		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("https://adactinhotelapp.com/");
		Assert.assertTrue(contains);

	}

	@Test(priority = 3, enabled = true)
	public void tc_003() {
		// verify the Login with valid username and valid password
		loginPage = new LoginPage();
		bs.enterText(loginPage.getUsername(), "Francis3535");
		bs.enterText(loginPage.getPassword(), "Francis@12");
		loginPage.getLoginBtn().click();

		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("https://adactinhotelapp.com/");
		Assert.assertTrue(contains);

	}

	@Test(priority = 4, enabled = true)
	public void tc_004() {
		// verify the Login with valid username and valid password
		loginPage = new LoginPage();
		bs.enterText(loginPage.getUsername(), "Francis353");
		bs.enterText(loginPage.getPassword(), "Francis@12");
		loginPage.getLoginBtn().click();

		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("https://adactinhotelapp.com/");
		Assert.assertTrue(contains);

	}

	@Test(priority = 5, enabled = true)
	public void tc_005() {
		// Booking a Hotel room
		searchHotel = new SearchHotel();
		bs.selectText(searchHotel.getLocation(), "Sydney");

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("AfterMethod");
		bs.closeBrowser();
	}

}
