package com.PageObjectModel;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility_Demo.FileReadManager_demo;
import com.interfaceElements_Demo.ProductpageElements;
import com.reusableclass.BaseClass;

public class ProductpageElementsPOM extends BaseClass implements ProductpageElements{
	
	@FindBy(xpath = phone_xpath)
	private WebElement phone;
	
	@FindBy(xpath = samsungphone_xpath)
	private WebElement selectSamsungphone;
	
	@FindBy(xpath = AddCart_xpath)
	private WebElement clickaddtocart;
	
	public ProductpageElementsPOM() {   // construtor
		PageFactory.initElements(driver, this);
	}
	
	//action method	
		FileReadManager_demo reader = new FileReadManager_demo();
		
	public void getProductPage() {
		
		click(phone);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		click(selectSamsungphone);
		click(clickaddtocart);
		 // wait for alert
	    explicitwait(null, 10, "alert");
	    // accept alert
	    alertAccept("Accept");
		
		
		
		
	}

}
