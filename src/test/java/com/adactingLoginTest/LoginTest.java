package com.adactingLoginTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.base.BaseClass;
import com.pages.BookHotel;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BookHotel{
	BaseClass bs;
	LoginPage loginPage;
	
	
	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(String browser) {
		System.out.println("BeforeMethod");
		 bs=new BaseClass();
		bs.launchBrowser(browser);
	}
	
	@Test
	public void tc_001() {
		LoginPage loginPage=new LoginPage();
		bs.enterText(loginPage.getUsername(), "Francis3535");
		bs.enterText(loginPage.getPassword(), "Francis@123");
		loginPage.getLoginBtn().click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("AfterMethod");
		bs.closeBrowser();
	}
	

}

