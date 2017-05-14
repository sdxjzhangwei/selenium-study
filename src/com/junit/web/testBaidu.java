package com.junit.web;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testBaidu {

	WebDriver driver=null;
	@Before
	public void Before() {
		String fullpath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.bin", fullpath);
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	@Test
	public void test() {
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys(new String[] { "sample" });
		driver.findElement(By.id("su")).click();
		String title=driver.getTitle();
		//System.out.println(title);
		assertEquals("百度一下，你就知道",title);
	}
	
	@After
	public void after() {
		driver.quit();
	}

}
