package com.TCS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
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
	public static WebDriver driver;// reference
	public static Properties config = new Properties();//Object
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log =Logger.getLogger("devpinoyLogger");
			
	
	@BeforeSuite
	
	public void setUp() {
		if(driver==null) {
			// OR file load
			try {
				fis= new FileInputStream(System.getProperty("C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\properties\\config.properties"));
				} 
			catch(FileNotFoundException e) {
					e.printStackTrace();}
			try {
				OR.load(fis);
				log.debug("OR file loaded successfully");
			}
			catch(IOException e){
				e.printStackTrace();}
			//config file load
			
			try {
				fis= new FileInputStream(System.getProperty("C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\properties\\config.properties"));
				} 
			catch(FileNotFoundException e) {
					e.printStackTrace();}
			try {
				config.load(fis);
				log.debug("Config file loaded successfully");
			}
			catch(IOException e){
				e.printStackTrace();}
			
			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\executables\\chromedriver.exe");
				driver= new ChromeDriver();
				log.debug("ChromeDriver file loaded successfully");
			}
			else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\executables\\geckodriver.exe");
				driver =new FirefoxDriver();
				log.debug("FirefoxDriver file loaded successfully");
			}
			else
			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver =new InternetExplorerDriver();
				log.debug("InternetExplorerDriver file loaded successfully");
			}
			
			driver.get(config.getProperty("testSiteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitely.wait")),TimeUnit.SECONDS);
			
			
		}
	}

@AfterSuite
	
	public void tearDown() {
	if(driver!=null)
	{driver.quit();
	}
		
	}

}
