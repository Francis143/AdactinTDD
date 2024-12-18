package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
LoginPage loginPage;
	public static WebDriver driver;

	public void launchBrowser(String browser) {

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://adactinhotelapp.com/");
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://adactinhotelapp.com/");
		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://adactinhotelapp.com/");
		}

	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void selectText(WebElement element, String text) {
		// TODO Auto-generated method stub
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void LoginAdactin() {
		BaseClass bs=new BaseClass();
	loginPage=new LoginPage();
	loginPage.getUsername().sendKeys("Francis3535");
	bs.enterText(loginPage.getPassword(), "Francis@123");
	loginPage.getLoginBtn().click();
	}

}
