package com.hrm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRM_EX {
	
	WebDriver driver;
	@BeforeMethod
	public void browserlaunch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Veerendra\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.testingmasters.com/hrm");
		
	}
	
	@Test(priority=1)
	
	public void pagetitleverify() throws InterruptedException
	{
		String s=driver.getTitle();
		System.out.println("The page title is:" + s);
		Assert.assertEquals(s, "OrangeHRM");
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	
	public void verifylogin() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("user02");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("TM1234");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(2000);
	}
	
	
@Test(priority=3)
	
	public void verifylogin12() throws InterruptedException
	{
		System.out.println("Change code");
	}

	
	@AfterMethod
	public void quitbrowser()
	{
		driver.quit();
	}
	
}



