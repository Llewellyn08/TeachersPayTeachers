package com.tpt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.tpt.actionDriver.ActionTpT;
import com.tpt.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Author : Llewellyn Thattazhi 
 * Date : 06-02-2023
 **/

public class BaseClassTpT {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentTest test;
    public ExtentReports exprep;

    public BaseClassTpT() {
        try {
            exprep = ExtentManager.setExtent();
            test = exprep.createTest("Test Case");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

	public static void launchApplication() {
		String browserName = prop.getProperty("browser");

			switch(browserName) {
			case "Chrome":
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--remote-allow-origins=*");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(co);
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "Safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			default:
				driver = new ChromeDriver();
				break;
			}
		

		driver.manage().window().maximize();
		ActionTpT.implicitWait(driver, 10);
		driver.get(prop.getProperty("url"));
	}

	public static void extentInfoLog(String text, Object object) {
		test.log(Status.INFO, text+""+object);
	}

	public static void extentPassLog(String text, Object object) {
		test.log(Status.PASS, text+""+object);
	}

	public static void extentFailLog(String text, Object object) {
		test.log(Status.FAIL, text+""+object);
	}

	public static void extentSkipLog(String text, Object object) {
		test.log(Status.SKIP, text+""+object);
	}
}
