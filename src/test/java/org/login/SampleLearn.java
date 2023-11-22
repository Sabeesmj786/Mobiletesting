package org.login;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SampleLearn {

	public static void main(String[] args) throws InterruptedException, IOException {
		// http://127.0.0.1:4723/
		AppiumDriverLocalService build = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\msabe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		build.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("deviceName", "sabees");
		options.setCapability("app", "D:\\Excel\\General-Store.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		Thread.sleep(3000);

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"))
				.click();

//		driver.setClipboardText("sabees26"); // copy the text
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(driver.getClipboardText());

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);

		String attribute = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");

		System.out.println(attribute);
		
		Assert.assertEquals(true, attribute.equals("Please enter your name"));


		TakesScreenshot ts = (TakesScreenshot) driver;

		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\msabe\\eclipse-workspace\\MobileTesting\\src\\test\\resources\\sample.png"));
		
		options.setChromedriverExecutable("C:\\Users\\msabe\\eclipse-workspace\\MobileTesting\\src\\test\\resources\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		

		Thread.sleep(2000);
		driver.quit();

		build.stop();

	}

}
