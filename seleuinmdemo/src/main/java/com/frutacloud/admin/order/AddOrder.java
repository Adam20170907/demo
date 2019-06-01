package com.frutacloud.admin.order;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frutacloud.admin.login.Loginadmin;

public class AddOrder{
	
	public WebDriver driver = null;
	
  @Test
  public void AddOrder() {
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
	  
	   
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/ul/li[6]/div/div/span[2]")));
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/ul/li[6]/div/div/span[2]")).click();

	  //是否可以点击订单管理
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/ul/li[6]/ul/li[1]")));
	  //点击左侧菜单栏的订单管理
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/ul/li[6]/ul/li[1]")).click();
	  //跳转到订单管理页面
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/iframe")));
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/iframe")));
	  //点击添加渠道订单按钮
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"searchForm\"]/div[1]/div[2]/button[3]")));
	  driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div[1]/div[2]/button[3]")).click();
	  // 返回第一个iframe
	  driver.switchTo().defaultContent();
	  //跳转添加订单的详情页面
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[4]/iframe")));
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[4]/iframe")));
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("shopName")));
	  driver.findElement(By.id("shopName")).click();
	  //跳转到选择公司页面
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[contains(@src,'/admin/popUpWindowMemberList')]")));
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/admin/popUpWindowMemberList')]")));
	  driver.findElement(By.name("colligateSearch")).clear();
	  driver.findElement(By.name("colligateSearch")).sendKeys("广州盒马");
	  driver.findElement(By.id("submitBtn")).click();
	  //调用js,进行元素点击
	  JavascriptExecutor jse = (JavascriptExecutor) driver;
	  WebElement element = driver.findElement(By.xpath("//td[contains(.,'12635')]"));
	  jse.executeScript("arguments[0].click()", element);
	  driver.findElement(By.xpath("//button[contains(.,'确定')]")).click();
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/order/toAddChannelOrder')]")));
	  //选择项目
	  element = driver.findElement(By.id("projectId"));
	  jse.executeScript("arguments[0].click()", element);
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/admin/popUpWindowProjectListByKacompanyId')]")));
	  element = driver.findElement(By.xpath("//td[contains(.,'广州盒马_特定')]"));
	  System.out.println("element = "+element.getText());
	  jse.executeScript("arguments[0].click()", element);
	  element = driver.findElement(By.xpath("//button[contains(.,'确定')]"));
	  jse.executeScript("arguments[0].click()", element);
	  //选择地区
	  driver.switchTo().defaultContent();
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[contains(@src,'/order/toAddChannelOrder')]"))));
	  Select select = new Select(driver.findElement(By.id("region")));
	  select.selectByVisibleText("广州");
	  //选择预计发货日期
	  select = new Select(driver.findElement(By.id("h")));
	  select.selectByVisibleText("23");
	  select = new Select(driver.findElement(By.id("f")));
	  select.selectByVisibleText("45");
	  element = driver.findElement(By.id("preDeliverTime"));
	  jse.executeScript("arguments[0].removeAttribute('readonly')", element);
	  Date date = new Date();
	  Calendar calendar = new GregorianCalendar();
	  calendar.setTime(date);
	  calendar.add(calendar.DATE, 1);
	  date = calendar.getTime();
	  SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
	  driver.findElement(By.id("preDeliverTime")).sendKeys(ft.format(date));
	  //设置客户单号
	  driver.findElement(By.xpath("//input[contains(@placeholder,'客户单号')]")).sendKeys("客户单号.adm测试0012138");
	  //选择收货地址
	  element = driver.findElement(By.xpath("//button[contains(.,'选择地址薄')]"));
	  jse.executeScript("arguments[0].click()", element);
//	  driver.switchTo().defaultContent();
//	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[contains(@src,'popUpWindowDelivery')]"))));
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,/order/popUpWindowDelivery)]")));
	  element = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]"));
	  jse.executeScript("arguments[0].click()", element);
	  element = driver.findElement(By.xpath("//button[contains(.,'确定')]"));
	  jse.executeScript("arguments[0].click()", element);
	  
	  //  填写收货地址
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/order/toAddChannelOrder')]")));
	  select = new Select(driver.findElement(By.xpath("//select[contains(@name,\"deliveryProvince\")]")));
	  select.selectByVisibleText("广东省");
	  select = new Select(driver.findElement(By.xpath("//select[contains(@name,\"deliveryCity\")]")));
	  select.selectByVisibleText("广州市");
	  select = new Select(driver.findElement(By.xpath("//select[contains(@name,\"deliveryRegion\")]")));
	  select.selectByVisibleText("天河区");
	  driver.findElement(By.xpath("//input[contains(@name,\"address\")]")).clear();
	  driver.findElement(By.xpath("//input[contains(@name,\"address\")]")).sendKeys("天河北路天河北路719号2楼1单元210房 adm 测试");
	  driver.findElement(By.xpath("//input[contains(@name,\"receiver\")]")).clear();
	  driver.findElement(By.xpath("//input[contains(@name,\"receiver\")]")).sendKeys("adm测试");
	  driver.findElement(By.xpath("//input[contains(@name,\"receiverPhone\")]")).clear();
	  driver.findElement(By.xpath("//input[contains(@name,\"receiverPhone\")]")).sendKeys("12345678");
	  
	  
	  
	  
	  //增加小包
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/order/toAddChannelOrder')]")));
	  element = driver.findElement(By.id("addPacket"));
	  jse.executeScript("arguments[0].click()", element);
//	  driver.switchTo().defaultContent();
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[contains(@src,'Packet')]"))));
//	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'Packet')]")));
//	  driver.findElement(By.xpath("//td[comtains(.,'10022')]"));
	  driver.findElement(By.id("number0")).sendKeys("202");
	  driver.findElement(By.id("number1")).sendKeys("202");
	  driver.findElement(By.id("number2")).sendKeys("202");
	  driver.findElement(By.xpath("//button[contains(.,'确定')]")).click();
	  // 增加货品
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/order/toAddChannelOrder')]")));
	  element = driver.findElement(By.id("addProduct"));
	  jse.executeScript("arguments[0].click()", element);
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[contains(@src,/order/popUpWindowProduct)]"))));
//	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/order/popUpWindowProduct')]")));
	  driver.findElement(By.id("number0")).sendKeys("202");
	  driver.findElement(By.id("number1")).sendKeys("202");
	  driver.findElement(By.id("number2")).sendKeys("202");
	  driver.findElement(By.xpath("//button[contains(.,'确定')]")).click();
	  // 选择价格类型
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/order/toAddChannelOrder')]")));
	  element = driver.findElement(By.xpath("//*[@id=\"checkbox10022\" and @value=\"1\" and last()]"));
	  jse.executeScript("arguments[0].click()", element);
	  element = driver.findElement(By.xpath("//*[@id=\"checkbox10023\" and @value=\"2\" and last()]"));
	  jse.executeScript("arguments[0].click()", element);
	  element = driver.findElement(By.xpath("//*[@id=\"checkbox10042\" and @value=\"2\" and last()]"));
	  jse.executeScript("arguments[0].click()", element);
	  element = driver.findElement(By.xpath("//*[@id=\"checkboxCAAA006\" and @value=\"2\" and last()]"));
	  jse.executeScript("arguments[0].click()", element);
	  element = driver.findElement(By.xpath("//*[@id=\"checkboxCLZA004\" and @value=\"2\" and last()]"));
	  jse.executeScript("arguments[0].click()", element);
	  element = driver.findElement(By.xpath("//*[@id=\"checkboxCLZA006\" and @value=\"1\" and last()]"));
	  jse.executeScript("arguments[0].click()", element);
	  
	  // 填写货品备注
	  driver.findElement(By.id("remarks10022")).sendKeys("12635, 广州盒马曜一城店, 广州盒马网络科技有限公司(广州盒马), 10022 暂定价 ");
	  driver.findElement(By.id("remarks10023")).sendKeys("12635, 广州盒马曜一城店, 广州盒马网络科技有限公司(广州盒马), 10022 暂定价 ");
	  driver.findElement(By.id("remarks10042")).sendKeys("12635, 广州盒马曜一城店, 广州盒马网络科技有限公司(广州盒马), 10022 暂定价 ");
	  driver.findElement(By.id("remarksCAAA006")).sendKeys("12635, 广州盒马曜一城店, 广州盒马网络科技有限公司(广州盒马), 10022 暂定价 ");
	  driver.findElement(By.id("remarksCLZA004")).sendKeys("12635, 广州盒马曜一城店, 广州盒马网络科技有限公司(广州盒马), 10022 暂定价 ");
	  driver.findElement(By.id("remarksCLZA006")).sendKeys("12635, 广州盒马曜一城店, 广州盒马网络科技有限公司(广州盒马), 10022 暂定价 ");
	  //  填写订单备注
	  driver.findElement(By.id("remarks")).sendKeys("12635, 广州盒马曜一城店, 广州盒马网络科技有限公司(广州盒马), 订单备注.");
	  //  填写物流费用
	  driver.findElement(By.id("logisticsPrice")).sendKeys("500.05");
	  //  填写折扣费用
	  driver.findElement(By.id("discount")).sendKeys("500.05");
	  element = driver.findElement(By.xpath("//input[contains(@value,'确认提交')]"));
	  jse.executeScript("arguments[0].click()", element);	  
	  
	  
	  
		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
	  File file = new File("D:\\software\\selenium\\drive\\chromedriver.exe") ;
	  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }
}
