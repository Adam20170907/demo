package com.frutacloud.sca.login;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ScaLogin {
    DesiredCapabilities cap = null;
    AndroidDriver driver = null;


    @BeforeTest
    public void setup() {
              cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Galaxy Note4");//启动哪种设备，模拟器或者真机
        cap.setCapability("udid","85c8daec");
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

    @Test
    public void testlogin() {
        System.out.println("clown.......................");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
        driver.findElementByXPath("//*[contains(@text,\"请输入账号\")]").sendKeys("10064");
        driver.hideKeyboard();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText").sendKeys("123456");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[contains(@text, \"登录\")]").click();


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
