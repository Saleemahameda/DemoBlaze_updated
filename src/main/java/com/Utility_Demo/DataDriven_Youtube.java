package com.Utility_Demo;

import java.io.File;

import java.sql.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DataDriven_Youtube {

	public static String getParticularCellData(int rowValue, int columnValue) {
		String data = null;
		try {
			File file = new File("C:\\Users\\abdul.saleem\\Downloads\\DataDriven_IPT.xlsx");
			
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet =book.getSheet("Sheet1");
			Row row=sheet.getRow(rowValue);
			Cell cell =row.getCell(columnValue);
			
			DataFormatter dataFormat = new DataFormatter();
			data = dataFormat.formatCellValue(cell);					
			System.out.println(data);
			
					} 
		catch (Exception e) {
			e.printStackTrace();
		}
	return data;
	}
}