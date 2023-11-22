package org.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Sample {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService build = new AppiumServiceBuilder()
		.withAppiumJS(new File("C:\\Users\\msabe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		build.start();
		
		
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("deviceName", "sabees");
		options.setCapability("app", "D:\\Excel\\General-Store.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//DROPDOWN OPERATION
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		 
		//SENDKEYS OPERATION
		
		Thread.sleep(2000);
		driver.setClipboardText("sabees@123");
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(driver.getClipboardText());
		
		
		
		
	}

}
