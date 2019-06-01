package com.frutacloud.admin.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;


public class Loginadmin {
    WebDriver driver = null;
		@Test
		public  void loginadmin () {

			// 打开登录页面
			driver.get("http://tpassport.frutacloud.com/?url=http%3A%2F%2Ftadmin.frutacloud.com%2Findex.html");
			// 最大化窗口
			driver.manage().window().maximize();
			// 删除所有cookie
			driver.manage().deleteAllCookies();
			// 显示等待
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// 元素是否加载完毕
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("keyword")));
			// 清空用户名输入框
			driver.findElement(By.id("keyword")).clear();
			// 输入用户名
			driver.findElement(By.id("keyword")).sendKeys("10064");
			driver.findElement(By.id("passwordText")).clear();
			driver.findElement(By.id("passwordText")).sendKeys("123456");
			// 点击登录
			driver.findElement(By.className("login__submit")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div[1]/div[1]/div[1]/div/span")));
			String text01 = driver.findElement(By.xpath("//*[@id='root']/div[1]/div[1]/div[1]/div/span")).getText();
			System.out.println("title = " + driver.getTitle());
			System.out.println("获取的文字 = " + text01);

		}
		@BeforeTest
		public void beforeTest(){
			File file = new File("D:\\software\\selenium\\drive\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		}
		@AfterTest
		public  void afterTest(){
			driver.close();
			driver.quit();
		}
}
