package com.interfaceElements_Demo;

public interface AddtoCartpageElements {
	
	String Addtocart_xpath = "//a[normalize-space(text())='Cart']";
	String verifyphone_xpath = "//td[normalize-space(text())='Samsung galaxy s6']";
	String clickPlaceOrder_xpath = "//button[@class='btn btn-success']";
	String fillName_xpath ="(//label[normalize-space(text())='Name:']/following::input)[1]";
	String fillCountry_xpath ="//label[@for='country']";
	String fillCity_xpath ="(//label[normalize-space(text())='City:']/following::input)[1]";
	String fillCreditcard_xpath ="(//label[normalize-space(text())='Credit card:']/following::input)[1]";
	String fillMonth_xpath ="(//label[normalize-space(text())='Month:']/following::input)[1]";
	String fillYear_xapth = "(//label[normalize-space(text())='Year:']/following::input)[1]";
	String clickPurchase_xpath ="(//button[@class='btn btn-primary'])[3]";
	String verifyPurchase_xpath ="//h2[normalize-space(text())='Thank you for your purchase!']";
	
	
	

}
