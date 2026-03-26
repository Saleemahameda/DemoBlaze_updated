package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility_Demo.ReadExcelData;
import com.reusableclass.BaseClass;

public class TestRunnerClass extends BaseClass{
	
public static void main(String[] args)  {
		
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/");
		
		
		String username = ReadExcelData.getParticularCellData(7,0);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(username);
		
		//String password = ReadExcelData.getParticularCellData(1,1);
		driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]")).click();
		
		terminateBrowser();
		
		
	}

}
