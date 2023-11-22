package org.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Sample1 {
	public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriverLocalService build = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\msabe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				
				build.start();
				
				
				UiAutomator2Options options=new UiAutomator2Options();
				
				options.setCapability("deviceName", "sabees");
				options.setCapability("app", "D:\\Excel\\Document from Ram Sarath Greens.apk");
				options.setCapability("appPackage", "io.appium.android.apis");
				options.setCapability("appActivity", "io.appium.android.apis.view.Gallery1");
				
				
				AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
				
				
				WebElement swipeOperation = driver.findElement(By.xpath("//android.widget.ImageView[2]"));
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				js.executeScript("mobile:swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)swipeOperation).getId(),"direction","left","percent",0.85 ));
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
