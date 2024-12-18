package com.adactingLoginTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.base.BaseClass;
import com.pages.*;
import com.pages.LoginPage;

public class LoginTest extends BookHotel {
	BaseClass bs;
	LoginPage loginPage;
	SearchHotel searchHotel;
	SelectHotel selectHotel;
	BookHotel bookHotel;
	BookedItinerary bookings;

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

	@Test(priority = 1, enabled = true,invocationCount=3,groups="smoke")
	public void tc_001() {
		// verify the Login with valid username and valid password

		loginPage = new LoginPage();
		bs.LoginAdactin();
		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("SearchHotel");
		Assert.assertTrue(contains);
//		Assert.assertTrue(false);
		
	}

	@Test(priority = 2, enabled = true,groups="Reqression")
	public void tc_002() {
		// verify the Login with invalid username and valid password
		loginPage = new LoginPage();
		bs.LoginAdactin();
		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("https://adactinhotelapp.com/");
		Assert.assertTrue(contains);

	}

	@Test(priority = 3, enabled = true,groups="Regression")
	public void tc_003() {
		// verify the Login with valid username and invalid password
		
		bs.LoginAdactin();
		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("https://adactinhotelapp.com/");
		Assert.assertTrue(contains);

	}

	@Test(priority = 4, enabled = true,groups="Regression")
	public void tc_004() {
		// verify the Login with invalid username and invalid password
		
		loginPage = new LoginPage();
		bs.enterText(loginPage.getUsername(), "Francis353");
		bs.enterText(loginPage.getPassword(), "Francis@12");
		loginPage.getLoginBtn().click();

		String currentUrl = driver.getCurrentUrl();
		boolean contains = currentUrl.contains("https://adactinhotelapp.com/");
		Assert.assertTrue(contains);

	}

	@Test(priority = 5, enabled = true, invocationCount = 1,groups="Regression")
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
	
	@Test(priority = 6, enabled = true, invocationCount = 1,groups="Regression")
	public void tc_006() {
		// Canceling the bookings
		bookings=new BookedItinerary();
		bs.LoginAdactin();
		bookings.getBookedItinerary().click();
		bookings.getCheckAll().click();
		bookings.getCancelAll().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		bookings.getSearchHotel().click();
				
	}
	@Test(priority = 7, enabled = true, invocationCount = 1,groups="smoke")
	public void tc_007() {
		// Canceling the bookings
		bookings=new BookedItinerary();
		bs.LoginAdactin();
		bookings.getLogOut().click();
		
		
	}
	
	

}
