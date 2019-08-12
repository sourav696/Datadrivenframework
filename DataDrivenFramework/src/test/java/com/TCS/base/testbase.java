package com.TCS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testbase {

	/*
	 * WebDriver
	 * Properties
	 * Logs
	 * Extent Report
	 * DB Connection
	 * Excel Reading
	 * Mail
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger applog= Logger.getLogger("devpinoyLogger");
	
	
	
	@BeforeSuite
	public void setUp() {
		if (driver==null) {
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				config.load(fis);
				applog.debug("config file loaded succssfuly");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			/*
			 * Invoking and loading OR property 
			 */
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				applog.debug("OR loaded successfuly");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			/*
			 * Starting CHROME driver
			 */
			
			if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\git\\Datadrivenframework\\DataDrivenFramework\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				applog.debug("CHROME driver loaded successfuly");
			}
			
			/*
			 * Starting GECKO driver
			 */
			
			else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\SONY\\git\\Datadrivenframework\\DataDrivenFramework\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				applog.debug("Gecko driver loaded successfuly");
			}
			
			/*
			 * Starting IE driver
			 */
			
			else {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\rima\\git\\dataDrivenFramework\\dataDrivenFramework\\src\\test\\resources\\executable\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				applog.debug("IE driver loaded successfuly");
			}
			
			driver.get(config.getProperty("testSiteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitely.wait")), TimeUnit.SECONDS);
			
		}
	}
		
public boolean isDisplay(By by) {
	try {   
	driver.findElement(by);
	return true;
	}catch(Exception e){
		return false;
	}
}

public void hardWait(int a) {
	try {
		Thread.sleep(1000*a);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
		
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
	
