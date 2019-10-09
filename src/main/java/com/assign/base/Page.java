package com.assign.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import com.assign.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	

	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	//Setting up Drivers for the test
	public static void initConfiguration(){
		
		
			if(Constants.browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--start-maximized");
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver = new ChromeDriver(options);
			log.debug("Launching Chrome");
		}else if(Constants.browser.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			ProfilesIni profileIni = new ProfilesIni();
			FirefoxProfile profile = profileIni.getProfile("default");
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new FirefoxDriver(option);

		}
		
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
	
	}
	
	
	public static void wait(String elementID)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));
	}
	

	
	public static void tearDown(){
		
		driver.quit();
		
	}
	

}
