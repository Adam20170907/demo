package com.frutacloud.sca.production;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class production {
    DesiredCapabilities cap = null;
    AndroidDriver driver = null;

    @BeforeTest
    public void setup() {
        cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Galaxy Note4");//启动哪种设备，模拟器或者真机
        cap.setCapability("udid", "85c8daec");
        cap.setCapability("automationName", "Appium");//使用哪种自动化
        cap.setCapability("platformName", "Android");//测试哪种平台，Android或者IOS
        cap.setCapability("platformVersion", "6.0.1");//系统的版本，这里是Android4.4.2
        cap.setCapability("appPackage", "com.rn_sca");//测试的app包
        cap.setCapability("appActivity", "com.rn_sca.MainActivity");//测试的app的Activity名字
        //        cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
        //        cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
        //        cap.setCapability("noSign", "True"); //不重新签名apk
        cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement e = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return
                        d.findElement(By.xpath("//*[contains(@text,\"请输入账号\")]"));
            }
        });
        e.sendKeys("10064");
//        driver.findElementByXPath("//*[contains(@text,\"请输入账号\")]").sendKeys("10064");
        driver.hideKeyboard();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText").sendKeys("123456");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[contains(@text, \"登录\")]").click();
    }

    @Test
    public void production() {
        login();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement e = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return
                        d.findElement(By.xpath("//*[contains(@text,\"生产\")]"));
            }
        });
        e.click();
//        driver.findElementByXPath("//*[contains(@text,\"生产\")]").click();
        driver.findElementByXPath("//*[contains(@text,\"新建生产\")]").click();
        driver.findElementByXPath("//*[contains(@text,\"公司名称\")]");
        driver.findElementByXPath("//*[contains(@text,\"请选择\")]").click();
        driver.findElementByXPath("//*[contains(@text,\"公司名称\")]");
        e = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return
                        d.findElement(By.xpath("/*[contains(@text,\"请输入\")]"));
            }
        });
        e.sendKeys("广州盒马");
//        driver.findElementByXPath("//*[contains(@text,\"请输入\")]").sendKeys("广州盒马");
        driver.findElementByXPath("//*[contains(@text,\"搜索\")]").click();
        e = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return
                        d.findElement(By.xpath("//*[contains(@text,\"广州盒马网络科技有限公司\")]"));
            }
        });
        e.click();
//        driver.findElementByXPath("//*[contains(@text,\"广州盒马网络科技有限公司\")]").click();
        driver.findElementByXPath("//*[contains(@text,\"生产仓库\")]");
        TouchAction tou = new TouchAction(driver);
        driver.findElementByXPath("//*[contains(@text,\"134_广州盒马仓\")]").click();
        tou.press(PointOption.point(752, 2009)).moveTo(PointOption.point(752, 2400)).release().perform();
        tou.tap(PointOption.point(1342, 1819)).perform();
        driver.findElementByXPath("//*[contains(@text,\"选择小包\")]").click();
        driver.findElementByXPath("//*[contains(@text,\"10023\")]").click();
        driver.findElementByXPath("//*[contains(@text,\"请输入\")]").sendKeys("5555");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[contains(@text,\"请输入\")]").click();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
