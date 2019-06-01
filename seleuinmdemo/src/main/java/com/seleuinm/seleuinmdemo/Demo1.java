package com.seleuinm.seleuinmdemo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		login();
	}
	
	public static void login() {
		File file = new File("D:\\software\\selenium\\drive\\chromedriver.exe") ;
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("http://tpassport.frutacloud.com/?url=http%3A%2F%2Ftadmin.frutacloud.com%2Findex.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("keyword")).clear();
		driver.findElement(By.id("keyword")).sendKeys("10064");
		driver.findElement(By.id("passwordText")).clear();
		driver.findElement(By.id("passwordText")).sendKeys("123456");
		driver.findElement(By.className("login__submit")).click();
		driver.getCurrentUrl();
//		assertEquals(true, "Adm, 欢迎使用 好果云订单系统".equals(driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[1]/div/span"))));
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
	}
}
