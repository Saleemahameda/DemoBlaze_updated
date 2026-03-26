package com.reusableclass;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseClass {

	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	public static File file;

	// 1. Browser launch()
	protected static void browserlaunch(String browserName) {

	    try {
	        if (browserName.equalsIgnoreCase("chrome")) {

	            ChromeOptions options = new ChromeOptions();

	            // Disable password manager popup
	            options.addArguments("--disable-notifications");
	            options.addArguments("--disable-save-password-bubble");

	            options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
	                put("credentials_enable_service", false);
	                put("profile.password_manager_enabled", false);
	            }});

	            driver = new ChromeDriver(options);

	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();

	        } else if (browserName.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        }

	        driver.manage().window().maximize();

	    } catch (Exception e) {
	        Assert.fail("Error: Occur while the Browser launch");
	    }
	}

	// 2. Close
	protected static void closeCurrentpage() {

		try {
			driver.close();
		} catch (Exception e) {
			

		}
	}

	// 3. Quit()
	protected static void terminateBrowser() {

		try {
			driver.quit();
		} catch (Exception e) {

		}
	}

	// 4. Navigate to()
	protected static void navigateTo(String navigateUrl) {

		try {
			driver.navigate().to(navigateUrl);
		} catch (Exception e) {

		}
	}

	// 5.6.7 Navigate back(), Navigate forward (), Navigate refresh()
	protected static void navigatemethods(String type) {

		if (type.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (type.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (type.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
	}

	// 8. Get()
	protected static void urlLaunch(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("Error: Occur while the URL lanuching");

		}
	}

	// 9. Alert - accept
	protected static void alertAccept(String value) {

		Alert alert = driver.switchTo().alert();
		if (value.equalsIgnoreCase("Accept")) {
			alert.accept();
		}

	}

	protected static void confirmalert(String value) {

		Alert alert = driver.switchTo().alert();
		if (value.equalsIgnoreCase("confirm")) {
			alert.accept();
		} else if (value.equalsIgnoreCase("Dismiss")) {
			alert.dismiss();
		}

	}

// 10. Action
	protected static void mousehower(WebElement element) {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).perform();
		} catch (Exception e) {
		}

	}

	protected static void doubleclk(WebElement element) {
		try {
			Actions ac = new Actions(driver);
			ac.doubleClick(element).perform();
		} catch (Exception e) {

		}
	}

	protected static void dragAndDrop(WebElement source, WebElement target) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target).perform();
		} catch (Exception e) {

		}
	}

	// 11. switchToFrame
	protected static void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	protected static void switchToFrameByNameOrId(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	protected static void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	protected static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// 12. Robot
	protected void robotMethod(String action) {
		try {
			Robot robot = new Robot();
			if (action.equalsIgnoreCase("enter")) {
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} else if (action.equalsIgnoreCase("tab")) {
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
		} catch (Exception e) {

		}
	}

	// 13.Window handles()
	protected static void switchToWindow(String title) {

		for (String windowId : driver.getWindowHandles()) {

			String currentTitle = driver.switchTo().window(windowId).getTitle();

			if (currentTitle.equalsIgnoreCase(title)) {
				break;
			}
		}
	}

	// 14.Drop down ()
	protected static void selectByVisibleText(WebElement element, String text) {

		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 15.checkbox
	protected static void selectCheckBox(WebElement element) {

		if (!element.isSelected()) {
			element.click();
		}
	}

	// 16. Is Enabled()
	protected static boolean isEnable(WebElement element) {
		return element.isEnabled();
	}

	// 17. Is Displayed()
	protected static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// 18. Is Selected()
	protected static boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	// 19. Get Options()
	protected static void getAllOptions(WebElement element) {

		Select select = new Select(element);

		for (WebElement option : select.getOptions()) {
			System.out.println(option.getText());
		}
	}

	// 20. Get Title()
	protected static String getTitle() {
		return driver.getTitle();
	}

	// 21. Get Current URL()
	protected static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// 22. Get Text()
	protected static String getElementText(WebElement element) {
		return element.getText();
	}

	// 23. Get Attribute()
	protected static String getAttribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	// 24. Wait()
	protected static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// 25.Take screenshot()
//	protected static void takeScreenShots() {
//		try {
//			Date currentDate = new Date();
//			String replace = currentDate.toString().replace(" ", "_").replace(":", "_");
//			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(source, new File("./Screenshots/testautomationpractice_" + replace + ".png"));
//		} catch (Exception e) {
//
//		}
//	}

	// 26.Scroll Up and Down()
	protected static void scrollDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	protected static void scrollUp(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	// 27.sendkeys
	protected static void inputvalue(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {

		}
	}

	// 28. Get First Selected Option()
	protected static String getFirstSelectedOption(WebElement element) {

		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	// 29. Get All Selected Options()
	protected static void getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		for (WebElement option : select.getAllSelectedOptions()) {
			System.out.println(option.getText());
		}
	}

	// 30. Is Multiple()
	protected static boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	protected static void elementclick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {

		}

	}

	// 31.click
	protected static void click(WebElement element) {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 32. RadioButton()
	protected static void selectRadioButton(WebElement element) {
		try {
			if (!element.isSelected()) {
				element.click();
			}
		} catch (Exception e) {

		}
	}

	// 33.Java Script Executor
	protected static void selectmethods(WebElement element, String type, String value) {

		try {
			Select select = new Select(element);

			if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			} else if (type.equalsIgnoreCase("visibletext")) {
				select.selectByVisibleText(value);
			}

		} catch (NumberFormatException e) {

		}
	}

	protected static void staticWait(int miliSec) {

		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {

		}
	}

	protected static void javaScriptExecutor(WebElement element, String type) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (type.equalsIgnoreCase("scroll into view")) {
				js.executeScript("arguments[0].scrollIntoView(true);", element);
			} else if (type.equalsIgnoreCase("scroll down")) {
				js.executeScript("window.scrollBy(0,1000)");
			} else if (type.equalsIgnoreCase("scroll up")) {
				js.executeScript("window.scrollBy(0,-2000)");
			} else if (type.equalsIgnoreCase("sendKeys")) {
				js.executeScript("arguments[0].setAttribute('value','saleem');", element);
			} else if (type.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click()", element);
			}
		} catch (Exception e) {

		}

	}
	//validation 
	// Title Validation
	protected static void validateTitle(String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			
			if (actualTitle.equals(expectedTitle)) {
				System.out.println("Title Matched");
			} else {
				System.out.println("Title Not Matched");
			}
		} catch (Exception e) {

		}
	}
	// URL Validation
	protected static void validateURL(String expectedURL) {
		try {
			String actualURL = driver.getCurrentUrl();
			
			if (actualURL.equals(expectedURL)) {
				System.out.println("URL Matched");
			} else {
				System.out.println("URL Not Matched");
			}
		} catch (Exception e) {

		}
	}
	// Text Validation
	protected static void validation(String actual, String expected) {
	    try {
	        Assert.assertEquals(actual, expected);
	    } catch (Exception e) {
	        Assert.fail("ERROR : OCCUR DURING VALIDATION");
	    }
	}
	protected static void explicitwait(WebElement element, int time, String condition) {

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			
			if (condition.equalsIgnoreCase("visible")) {
				
				wait.until(ExpectedConditions.visibilityOf(element));
				
			} 
			else if (condition.equalsIgnoreCase("clickable")) {
				
				wait.until(ExpectedConditions.elementToBeClickable(element));
				
			} 
			else if (condition.equalsIgnoreCase("alert")) {
				
				wait.until(ExpectedConditions.alertIsPresent());
			}

		} catch (Exception e) {

			Assert.fail("Error : Explicit wait failed");

		}
	}
	
	public static void extentReportStart(String location) {
	    extentReports = new ExtentReports();
	    file = new File(location);
	    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	    extentReports.attachReporter(sparkReporter);
	    extentReports.setSystemInfo("OS", System.getProperty("os.name"));
	    extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void extentReportTearDown(String location) throws IOException {
	    extentReports.flush();
	    file = new File(location);
	    Desktop.getDesktop().browse((file).toURI());
	}

	public static String takeScreenshot(String testName) throws IOException {

	    TakesScreenshot screenshot = (TakesScreenshot) driver;

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

	    String path = "./screenshots/" + testName + "_" + timeStamp + ".png";

	    File destFile = new File(path);

	    FileHandler.copy(srcFile, destFile);

	    return path;
	}
}
