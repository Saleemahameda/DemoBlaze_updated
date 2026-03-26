package com.runner;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectManager.PageObjectManager;
import com.listener.ExtentReport_Test;
import com.listener.ITestListenerClass;
import com.reusableclass.BaseClass;


@Listeners(ITestListenerClass.class)
public class TestRunner extends BaseClass {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        browserlaunch(PageObjectManager.getPageObjectManager().getFileReadManager_demo().getDataProperty("browser"));

        urlLaunch(PageObjectManager.getPageObjectManager().getFileReadManager_demo().getDataProperty("demourl"));
    }

    @Test
    public void verifyLoginPageFlow() throws InterruptedException {
    	ExtentReport_Test.extentTest = extentReports.createTest("LoginTest" + " : " + Thread.currentThread()
        .getStackTrace()[1].getMethodName().toString()).info("Demo Web Application Testing");
        PageObjectManager.getPageObjectManager().getLoginPageElementsPOM().getloginpage();
        PageObjectManager.getPageObjectManager().getProductpageElementsPOM().getProductPage();
        PageObjectManager.getPageObjectManager().getAddtoCartpageElementsPOM().getAddtoCartPage();
    }

    @AfterMethod
    public void tearDown() {
        terminateBrowser();
    }
    
    @BeforeSuite
    public void extentReportStartUp() {
        extentReportStart(PageObjectManager.getPageObjectManager().getFileReadManager_demo().getDataProperty("extendstart"));
    }

    @AfterSuite
    public void extendReportEnd() throws IOException {
        extentReportTearDown(PageObjectManager.getPageObjectManager().getFileReadManager_demo().getDataProperty("extendend"));
    }
}