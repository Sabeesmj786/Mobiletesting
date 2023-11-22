package org.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Sample2 {

public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriverLocalService build = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\msabe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				
				build.start();
				
				
				UiAutomator2Options options=new UiAutomator2Options();
				options.setCapability("deviceName", "Sabees");
				options.setChromedriverExecutable("C:\\Users\\msabe\\eclipse-workspace\\MobileTesting\\src\\test\\resources\\chromedriver.exe");
				options.setCapability("browserName", "Chrome");
				
				
				
				AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
				
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				
				driver.get("https://www.facebook.com/");
}
}
