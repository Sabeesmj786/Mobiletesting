package org.login;


import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SampleHybrid {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		
		AppiumDriverLocalService build = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\msabe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		build.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("deviceName", "sabees");
		options.setCapability("app", "D:\\Excel\\General-Store.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		
		Thread.sleep(3000);
		
		driver.setClipboardText("sabees@123");
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(driver.getClipboardText());
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Set<String> contextHandles = driver.getContextHandles();
		
	
		List<String> li = new ArrayList();
		for (String c : contextHandles) {
			System.out.println(c);
			li.add(c);
		}
		System.out.println(li);
		
		options.setChromedriverExecutable("C:\\Users\\msabe\\eclipse-workspace\\MobileTesting\\src\\test\\resources\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		options.setCapability("autoWebView", true);
	
	}

}
