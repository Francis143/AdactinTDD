package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookHotel extends SelectHotel{
	
	
	
	@FindBy(id="first_name")
	private WebElement firstname;
	
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement ccNum;
	
	@FindBy(id="cc_type")
	private WebElement ccType;
	
	@FindBy(id="cc_exp_month")
	private WebElement expMonth;
	
	
	@FindBy(id="cc_exp_year")
	private WebElement expYear;
	
	
	@FindBy(id="cc_cvv")
	private WebElement ccCVV;
	
	
	@FindBy(id="book_now")
	private WebElement bookNow;
	
	
	@FindBy(id="order_no")
	private WebElement orderNo;

	
	
	
	

	public WebElement getCcType() {
		return ccType;
	}


	public WebElement getFirstname() {
		return firstname;
	}


	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getAddress() {
		return address;
	}


	public WebElement getCcNum() {
		return ccNum;
	}


	public WebElement getExpMonth() {
		return expMonth;
	}


	public WebElement getExpYear() {
		return expYear;
	}


	public WebElement getCcCVV() {
		return ccCVV;
	}


	public WebElement getBookNow() {
		return bookNow;
	}


	public WebElement getOrderNo() {
		return orderNo;
	}
	
	
	
	
	

}
