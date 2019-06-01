package com.frutacloud.admin.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class OrderDelivery  {

	WebDriver driver = null;

			
  @Test
  public void orderDelivery() {

	  JavascriptExecutor jse = (JavascriptExecutor) driver;
	  WebElement element = null;
	  // 打开网址
	  driver.get("http://tadmin.frutacloud.com/index.html");
	  
	  // 显示等待 
	  WebDriverWait wait = new WebDriverWait(driver, 10,1);
	  driver.manage().window().maximize();
	  // 隐式等待
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  String title = "好果云订单管理系统" ;
	  if (!title.contentEquals(driver.getTitle())) {
		  loginadmin();
	  }
	  driver.switchTo().defaultContent();

	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/ul/li[6]/div[1]/div")));
	  element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/ul/li[6]/div[1]/div"));
	  jse.executeScript("arguments[0].click()",element);

	  // 打开订单发货页面
	  element = driver.findElement(By.xpath("//li[contains(@url,\"/order/orderBatchForSCAAPI\")]"));
	  jse.executeScript("arguments[0].click()",element);
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,\"/order/orderBatchForSCAAPI\")]")));
	  driver.findElement(By.xpath("//input[@type=\"text\"]")).clear();
	  driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("10064");
	  driver.findElement(By.xpath("//input[@type=\"password\"]")).clear();
	  driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("123456");
	  element = driver.findElement(By.xpath("//button/span[contains(.,\"登 录\")]"));
	  jse.executeScript("arguments[0].click()",element);
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span/div/div/div/div[2]"))));
	  element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span/div/div/div/div[2]"));
	  jse.executeScript("arguments[0].click()",element);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role=\"option\"]")));
	  element = driver.findElement(By.xpath("//li[@role=\"option\" and contains(.,\"广州盒马仓\")]"));
	  jse.executeScript("arguments[0].click()",element);

	  try {
		  Thread.sleep(5000);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }
  	  
	  public void loginadmin() {
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
  		  String text01 = driver.findElement(By.xpath("//*[@id='root']/div[1]/div[1]/div[1]/div/span")).getText() ;
  		  System.out.println("title = " + driver.getTitle());
  		  System.out.println("获取的文字 = " + text01);
	}
  
  @BeforeTest
  public void beforeTest() {
	  File file = new File("C:\\Adm\\Software\\Browser_driver\\chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }

}
