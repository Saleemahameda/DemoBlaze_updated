package com.Utility_Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReadManager_demo {
	
	private static Properties property;
	
	private static void setupProperty() {
		
		File file  = new File("C:\\Users\\abdul.saleem\\OneDrive - HTC Global Services, Inc\\Selenium Java\\SeleniumJavaClass\\DemoBlaze\\src\\main\\resource\\DemoTestData.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			property = new Properties();
			property.load(fis);
			
		} catch (FileNotFoundException e) {
			Assert.fail("Error: Occur During the FileNotFound check the location of the file");
		
		} catch (IOException e) {
			Assert.fail("Error: Occur During the file reading");
	
		}
	}
	
	public static String getDataProperty(String key) {
		setupProperty();
		
		String value = property.getProperty(key);
		return value;
		
	}
	public static void main(String[]args) {
		System.out.println(getDataProperty("userpassword"));
	}

}
