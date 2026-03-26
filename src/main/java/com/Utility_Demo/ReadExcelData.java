package com.Utility_Demo;

import java.io.File;
import java.util.zip.DataFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	
//	public static void getParticularCellData() {
//		//String data = null;
//		try {
//			File file = new File("C:\\Users\\abdul.saleem\\Downloads\\DataDriven_IPT.xlsx");
//			
//			Workbook book = new XSSFWorkbook(file);
//			Sheet sheet =book.getSheet("Sheet1");
//			Row row=sheet.getRow(2);
//			Cell cell =row.getCell(0);
//			
//			String data = cell.getStringCellValue();
//			System.out.println(data);
//			
//					} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	
//	}
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
	
	public static void getalldata() {
		try {
			File file = new File("C:\\Users\\abdul.saleem\\Downloads\\DataDriven_IPT.xlsx");
			
			Workbook book = new XSSFWorkbook(file);
			
			Sheet sheet =book.getSheet("Sheet1");
			
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("No of Rows: " +  lastRowNum);
		
		Short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("No of Columns: " +  lastCellNum);
			
			for (int i = 1; i <= lastRowNum; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < lastCellNum; j++) {
					Cell cell = row.getCell(j);
			//		String data = cell.getStringCellValue();
			// Format  -- DataFormater -- string		
					DataFormatter dataFormat = new DataFormatter();
					String data = dataFormat.formatCellValue(cell);					
					System.out.println(data);
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	
	public static void main (String[]args) {
	//	getParticularCellData();
		getalldata();
	}


}
