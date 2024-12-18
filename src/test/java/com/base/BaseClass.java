package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public void launchBrowser(String browser) {

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://adactinhotelapp.com/");
		}
		else if (browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://adactinhotelapp.com/");
		}
		else if (browser.equals("edge")) {
			
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
	
	public void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	

}
