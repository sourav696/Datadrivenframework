package com.TCS.testCase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.TCS.base.testbase;

public class SearchInGoogle extends testbase{
	
	@Test
	public  void searchGoogle() {
		driver.findElement(By.xpath(OR.getProperty("searchbox"))).sendKeys("Selenium");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
