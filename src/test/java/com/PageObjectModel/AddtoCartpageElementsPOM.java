package com.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility_Demo.FileReadManager_demo;
import com.interfaceElements_Demo.AddtoCartpageElements;
import com.reusableclass.BaseClass;

public class AddtoCartpageElementsPOM extends BaseClass implements AddtoCartpageElements{
	
	@FindBy(xpath =Addtocart_xpath)
	private WebElement clickAddtoCart;
	
	@FindBy(xpath =verifyphone_xpath)
	private WebElement verifyphone;
	
	@FindBy(xpath =clickPlaceOrder_xpath)
	private WebElement clickPlaceorder;
	
	@FindBy(xpath = fillName_xpath)
	private WebElement fillName;
	
	@FindBy(xpath = fillCountry_xpath)
	private WebElement fillCountry;
	
	@FindBy(xpath = fillCity_xpath)
	private WebElement fillCity;
	
	@FindBy(xpath =fillCreditcard_xpath)
	private WebElement fillCreditcard;
	
	@FindBy(xpath = fillMonth_xpath)
	private WebElement fillMonth;
	
	@FindBy(xpath =fillYear_xapth)
	private WebElement fillYear;
	
	@FindBy(xpath =clickPurchase_xpath)
	private WebElement clickPurchase;
	
	@FindBy(xpath =verifyPurchase_xpath)
	private WebElement verifyPurchase;
	
	public AddtoCartpageElementsPOM() {   // construtor
		PageFactory.initElements(driver, this);
	}
	
	//action method	
		FileReadManager_demo reader = new FileReadManager_demo();
	
	
	public void getAddtoCartPage() {
		
		click(clickAddtoCart);
		String elementText = getElementText(verifyphone);
		explicitwait(verifyphone,20,"visible");
		System.out.println(elementText);
		click(clickPlaceorder);
		inputvalue(fillName,reader.getDataProperty("fillname"));
		inputvalue(fillCountry, reader.getDataProperty("country"));
		inputvalue(fillCity, reader.getDataProperty("city"));
		inputvalue(fillCreditcard, reader.getDataProperty("creditcard"));
		inputvalue(fillMonth,reader.getDataProperty("month"));
		inputvalue(fillYear, reader.getDataProperty("year"));
		click(clickPurchase);
		String elementText1 = getElementText(verifyPurchase);
		explicitwait(verifyPurchase,20,"visible");
		System.out.println(elementText1);
		
		
		
		
	}
}
