package com.TCS.rough;

import java.io.FileInputStream;
import java.util.Properties;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static void main(String[] args) throws Exception {
		
		Properties config= new Properties();
		//FileInputStream fis= new FileInputStream("C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\properties\\config.properties");
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		System.out.println(config.getProperty("browser"));
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\executables\\geckodriver.exe");
		//WebDriver driver =new FirefoxDriver();
		//driver.get("https://www.google.com");
		//driver.findElement(By.xpath("//input[@name='q']"));
		
		/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\SONY\\DataDrivenFramework\\DataDrivenFramework\\src\\test\\resources\\executables\\geckodriver.exe");		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.quit();*/
	}

}
