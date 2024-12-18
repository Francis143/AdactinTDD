package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookedItinerary extends BookHotel{
	
	@FindBy(id="check_all")
	private WebElement checkAll;
	
	
	@FindBy(name="cancelall")
	private WebElement cancelAll;
	
	
	@FindBy(xpath="//a[normalize-space(text())='Booked Itinerary']")
	private WebElement bookedItinerary;

	@FindBy(xpath="//a[normalize-space(text())='Search Hotel']")
	private WebElement searchHotel;
	
	@FindBy(xpath="//a[normalize-space(text())='Logout']")
	private WebElement logOut;

	public WebElement getCheckAll() {
		return checkAll;
	}

	public WebElement getCancelAll() {
		return cancelAll;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	
	
	
	
	
	
	
	
	
	

}
