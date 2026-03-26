package com.PageObjectModel;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility_Demo.FileReadManager_demo;
import com.interfaceElements_Demo.LoginPageElements;
import com.reusableclass.BaseClass;

public class LoginPageElementsPOM extends BaseClass implements LoginPageElements{
	
	@FindBy(id = login_id)
	private WebElement clicklogin;
	
	@FindBy(id = username_id)
	private WebElement username;
	
	@FindBy(id = password_id)
	private WebElement password;
	
	@FindBy(xpath = loginbtn_xpath)
	private WebElement loginbutton;
	
	@FindBy(xpath = welcomemsg_xpath)
	private WebElement verifywelcomeMsg;
	
	public LoginPageElementsPOM() {   // construtor
		PageFactory.initElements(driver, this);
	}
	
	//action method
	
	FileReadManager_demo reader = new FileReadManager_demo();
	
	public void getloginpage() throws InterruptedException {
		
		click(clicklogin);
		implicitWait(3000);
		inputvalue(username, reader.getDataProperty("demousername"));
		inputvalue(password, reader.getDataProperty("demopassword1"));
		click(loginbutton);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(verifywelcomeMsg));
//		Assert.assertEquals(getElementText(verifywelcomeMsg), reader.getDataProperty("userlogin_Ecepwelcomemsg"));
		String elementText = getElementText(verifywelcomeMsg);
		explicitwait(verifywelcomeMsg,20,"visible");
		System.out.println(elementText);
		validation(getElementText(verifywelcomeMsg),reader.getDataProperty("userlogin_Ecepwelcomemsg"));
		
	
	
	
	}
	

}
