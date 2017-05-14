package com.cn.common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	public static void main(String[] args){
		String fullpath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
		//System.out.println(fullpath);
		System.setProperty("webdriver.chrome.bin", fullpath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys(new String[] { "sample" });
		driver.findElement(By.id("su")).click();
		
		//设置窗口大小
		driver.manage().window().setSize(new Dimension(80, 120));
		//窗口最大化
		driver.manage().window().maximize();
		//控制浏览器前进 后退
		driver.navigate().forward();
		driver.navigate().back();
		//模拟浏览器刷新
		driver.navigate().refresh();
		
		//submit()方法用于提交表单。例如，在搜索框输入关键字之后的“回车”操作，就可以通过submit()方法模拟。
		driver.findElement(By.id("su")).submit();
		
		//返回元素的尺寸
		driver.findElement(By.id("su")).getSize();
		//获取元素的文本
		driver.findElement(By.id("su")).getText();
		//获取元素的属性值
		driver.findElement(By.id("su")).getAttribute("name");
		//返回该元素是否用户可见
		driver.findElement(By.id("su")).isDisplayed();
		
		//右键点击指定的元素
		Actions action=new Actions(driver);
		action.contextClick(driver.findElement(By.id("su"))).perform();
		//鼠标悬停
		action.clickAndHold(driver.findElement(By.id("su"))).perform();
		//双击
		action.doubleClick(driver.findElement(By.id("su"))).perform();
		//移到某个元素
		action.moveToElement(driver.findElement(By.id("su"))).perform();
		//拖动\释放
		WebElement element1=driver.findElement(By.id("kw"));
		WebElement element2=driver.findElement(By.id("kw"));
		action.dragAndDrop(element1, element2).perform();
		
		//释放鼠标
		action.release().perform();


		element1.sendKeys(new String[] { "sample" });
		//模拟键盘操作
		element1.sendKeys(new String[]{Keys.BACK_SPACE.toString()});
		element1.sendKeys(new String[]{Keys.SPACE.toString()});
		element1.sendKeys(new String[]{Keys.CONTROL.toString(),"A"});
		
		//获得当前页面的title
		driver.getTitle();
		//获得当前页面的URL
		driver.getCurrentUrl();
		
		
		/*
		 * 设置元素等待
		 * */
		//页面加载时间超时时间设置为5s
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		
		//定为对象时给10s的时间,如果10s内还定为不到则抛出异常
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("kw")).sendKeys(new String[] { "sample" });
		
		//异步脚本的超时时间设置为3s
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		
		/*
		 * 设置元素休眠*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//定位一组元素(需要批量操作元素时)
		List<WebElement> list=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement checkbox:list){
			checkbox.click();
		}
		//指定元素的最后一个,进行点击操作
		list.get(list.size()-1).click();
		
		
		
		
		//多表单切换(Frame  id="if")
		driver.switchTo().frame("if");
		driver.findElement(By.id("kw")).sendKeys(new String[] { "sample" });
		
		/*
		 * switchTo().frame()默认可以直接取表单的id 或name属性。如果iframe没有可用的id和name属性，则可以通过下面的方式进行定位。
		 * //先通过xpth定位到iframe  
		 * WebElement xf = driver.findElement(By.xpath("//iframe[@id='if']")); 
		 * driver.switchTo().frame(xf);
		 * 
		 * 
		 * 如果完成了在当前表单上的操作，则可以通过switchTo().defaultContent()方法跳出表单
		 * */
		
		//返回上一级表单
		driver.switchTo().defaultContent();
		
		//多窗口切换
		
	}

}
