package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasic {

	@Test
	public void AppiumTest() throws MalformedURLException {
		
		//Code to start server
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\dshru\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.9").usingPort(4723).build();
		service.start();
		
		//AndroidDriver
		//Appium Code -> Appium Server -> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel7Emulator");
		options.setApp("C:\\Users\\dshru\\eclipse-workspace\\Appium\\src\\test\\java\\resource\\ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://192.168.1.9:4723/"), options);
		

		//Actual Automation Code
		//Different Locators- xpath, id, accessibilityId, classname, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.quit();
		service.stop();     //stop the server
		
	}
	
}
