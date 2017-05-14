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
		
		//���ô��ڴ�С
		driver.manage().window().setSize(new Dimension(80, 120));
		//�������
		driver.manage().window().maximize();
		//���������ǰ�� ����
		driver.navigate().forward();
		driver.navigate().back();
		//ģ�������ˢ��
		driver.navigate().refresh();
		
		//submit()���������ύ�������磬������������ؼ���֮��ġ��س����������Ϳ���ͨ��submit()����ģ�⡣
		driver.findElement(By.id("su")).submit();
		
		//����Ԫ�صĳߴ�
		driver.findElement(By.id("su")).getSize();
		//��ȡԪ�ص��ı�
		driver.findElement(By.id("su")).getText();
		//��ȡԪ�ص�����ֵ
		driver.findElement(By.id("su")).getAttribute("name");
		//���ظ�Ԫ���Ƿ��û��ɼ�
		driver.findElement(By.id("su")).isDisplayed();
		
		//�Ҽ����ָ����Ԫ��
		Actions action=new Actions(driver);
		action.contextClick(driver.findElement(By.id("su"))).perform();
		//�����ͣ
		action.clickAndHold(driver.findElement(By.id("su"))).perform();
		//˫��
		action.doubleClick(driver.findElement(By.id("su"))).perform();
		//�Ƶ�ĳ��Ԫ��
		action.moveToElement(driver.findElement(By.id("su"))).perform();
		//�϶�\�ͷ�
		WebElement element1=driver.findElement(By.id("kw"));
		WebElement element2=driver.findElement(By.id("kw"));
		action.dragAndDrop(element1, element2).perform();
		
		//�ͷ����
		action.release().perform();


		element1.sendKeys(new String[] { "sample" });
		//ģ����̲���
		element1.sendKeys(new String[]{Keys.BACK_SPACE.toString()});
		element1.sendKeys(new String[]{Keys.SPACE.toString()});
		element1.sendKeys(new String[]{Keys.CONTROL.toString(),"A"});
		
		//��õ�ǰҳ���title
		driver.getTitle();
		//��õ�ǰҳ���URL
		driver.getCurrentUrl();
		
		
		/*
		 * ����Ԫ�صȴ�
		 * */
		//ҳ�����ʱ�䳬ʱʱ������Ϊ5s
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get("http://www.baidu.com");
		
		//��Ϊ����ʱ��10s��ʱ��,���10s�ڻ���Ϊ�������׳��쳣
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("kw")).sendKeys(new String[] { "sample" });
		
		//�첽�ű��ĳ�ʱʱ������Ϊ3s
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		
		/*
		 * ����Ԫ������*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//��λһ��Ԫ��(��Ҫ��������Ԫ��ʱ)
		List<WebElement> list=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement checkbox:list){
			checkbox.click();
		}
		//ָ��Ԫ�ص����һ��,���е������
		list.get(list.size()-1).click();
		
		
		
		
		//����л�(Frame  id="if")
		driver.switchTo().frame("if");
		driver.findElement(By.id("kw")).sendKeys(new String[] { "sample" });
		
		/*
		 * switchTo().frame()Ĭ�Ͽ���ֱ��ȡ����id ��name���ԡ����iframeû�п��õ�id��name���ԣ������ͨ������ķ�ʽ���ж�λ��
		 * //��ͨ��xpth��λ��iframe  
		 * WebElement xf = driver.findElement(By.xpath("//iframe[@id='if']")); 
		 * driver.switchTo().frame(xf);
		 * 
		 * 
		 * ���������ڵ�ǰ���ϵĲ����������ͨ��switchTo().defaultContent()����������
		 * */
		
		//������һ����
		driver.switchTo().defaultContent();
		
		//�ര���л�
		
	}

}
