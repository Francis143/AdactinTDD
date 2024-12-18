package com.adactingLoginTest;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
	SelectHotel selectHotel;
	BookHotel bookHotel;

	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeMethod(String browser) {
		System.out.println("BeforeMethod");
		bs = new BaseClass();
		bs.launchBrowser(browser);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("AfterMethod");
		bs.closeBrowser();
	}

	@Test(priority = 1, enabled = false)
	public void tc_001() {
		// verify the Login with valid username and valid password
		loginPage = new LoginPage();
//		bs.enterText(loginPage.getUsername(), "Francis3535");
//		bs.enterText(loginPage.getPassword(), "Francis@123");
//		loginPage.getLoginBtn().click();
		bs.LoginAdactin();
		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("SearchHotel");
		Assert.assertTrue(contains);

	}

	@Test(priority = 2, enabled = false)
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

	@Test(priority = 3, enabled = false)
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

	@Test(priority = 4, enabled = false)
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

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void tc_005() throws InterruptedException {
		// Booking a Hotel room
		searchHotel = new SearchHotel();
		bs.LoginAdactin();
		bs.selectText(searchHotel.getLocation(), "Sydney");
		bs.selectText(searchHotel.getHotels(), "Hotel Creek");
		bs.selectText(searchHotel.getRoom_type(), "Double");
		bs.selectText(searchHotel.getRoom_nos(), "2 - Two");
		bs.enterText(searchHotel.getDatepick_in(), "21/12/2024");
		bs.enterText(searchHotel.getDatepick_out(), "22/12/2024");
		bs.selectText(searchHotel.getAdult_room(), "2 - Two");
		bs.selectText(searchHotel.getChild_room(), "2 - Two");
		searchHotel.getSubmit().click();

		selectHotel = new SelectHotel();
		selectHotel.getRadiobutton().click();
		selectHotel.getContinueBtn().click();
		bookHotel = new BookHotel();
		bs.enterText(bookHotel.getFirstname(), "Francis");
		bs.enterText(bookHotel.getLastName(), "Sanjon");
		bs.enterText(bookHotel.getAddress(), "Chennai");
		bs.enterText(bookHotel.getCcNum(), "1234567890123456");
		bs.selectText(bookHotel.getCcType(), "VISA");
		bs.selectText(bookHotel.getExpMonth(), "May");
		bs.selectText(bookHotel.getExpYear(), "2030");
		bs.enterText(bookHotel.getCcCVV(), "123");
		bookHotel.getBookNow().click();
		Thread.sleep(10000);

		WebElement orderNo = bookHotel.getOrderNo();
		String orderId = orderNo.getAttribute("value");
		boolean empty = orderId.isEmpty();
		
		Assert.assertEquals(empty, false);

	}

}
