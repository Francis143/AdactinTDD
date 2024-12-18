package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectHotel extends SearchHotel{

	
	@FindBy(id="radiobutton_0")
	private WebElement radiobutton;
	
	
	@FindBy(id="continue")
	private WebElement continueBtn;


	public WebElement getRadiobutton() {
		return radiobutton;
	}


	public WebElement getContinueBtn() {
		return continueBtn;
	}
	
	
	
	
}
