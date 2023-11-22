package org.step;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.en.*;

public class StepDefinitionClass {
	
	AndroidDriver driver;
	
	AppiumDriverLocalService build;

@Given("User Sarts The Server")
public void user_sarts_the_server() {
	
	 build = new AppiumServiceBuilder()
	.withAppiumJS(new File("C:\\Users\\msabe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	.withIPAddress("127.0.0.1").usingPort(4723).build();
	build.start();
	


}
@Given("User launches the Device")
public void user_launches_the_device() throws InterruptedException, MalformedURLException {
	
	UiAutomator2Options options=new UiAutomator2Options();
	options.setCapability("deviceName", "sabees");
	options.setCapability("app", "D:\\Excel\\General-Store.apk");
	
	 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	Thread.sleep(2000);
	
	
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
//	
//	Thread.sleep(3000);
	
	

}
@When("User Locates The Element and Clicks")
public void user_locates_the_element_and_clicks() throws InterruptedException {
	
                  //LONGPRESS OPERATION
//	Thread.sleep(2000);
//	driver.findElement(AppiumBy.accessibilityId("Views")).click();
//	driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
//	driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
//	WebElement longPressElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
//	
//	JavascriptExecutor js =(JavascriptExecutor) driver;
//	
//	js.executeScript("mobile:longClickGesture", 
//			ImmutableMap.of("elementId",((RemoteWebElement)longPressElement)
//					.getId(),"duration", 2000));
//	
//	Thread.sleep(2000);
//	
//	driver.pressKey(new KeyEvent(AndroidKey.BACK));
//	driver.pressKey(new KeyEvent(AndroidKey.BACK));
//	driver.pressKey(new KeyEvent(AndroidKey.BACK));
//	

}
@When("User Performs One More Click Operation")
public void user_performs_one_more_click_operation() throws InterruptedException {
Thread.sleep(2000);


//SCROLL OPERATION
driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"));")).click();

driver.pressKey(new KeyEvent(AndroidKey.BACK));
driver.pressKey(new KeyEvent(AndroidKey.BACK));

//SWIPE OPERATION
driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
WebElement Source = driver.findElement(By.xpath("//android.widget.ImageView[2]"));

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("mobile:swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)Source).getId(),"direction","left","percent",0.90));


driver.pressKey(new KeyEvent(AndroidKey.BACK));
driver.pressKey(new KeyEvent(AndroidKey.BACK));

  //DRAG AND DROP OPERATION
Thread.sleep(2000);
driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
WebElement source1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

JavascriptExecutor js1 = (JavascriptExecutor) driver;
js1.executeScript("mobile:dragGesture",ImmutableMap.of("elementId",((RemoteWebElement)source1).getId(),"endX",621,"endY",516 ));

Thread.sleep(3000);

DeviceRotation dr = new DeviceRotation(0,0,90);
driver.rotate(dr);



}
@Then("user close the driver and server")
public void user_close_the_driver_and_server() throws InterruptedException {

	Thread.sleep(3000);
	driver.quit();
	build.stop();
}

}