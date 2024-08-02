package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException { 
		
	service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\dshru\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("192.168.1.9").usingPort(4723).build();
	service.start();
	
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("Pixel7Emulator");
	options.setApp("C:\\Users\\dshru\\eclipse-workspace\\Appium\\src\\test\\java\\resource\\ApiDemos-debug.apk");
	
	driver = new AndroidDriver(new URL("http://192.168.1.9:4723/"), options);

	}
	
	public void tearDown() { 
		 
		driver.quit();
		service.stop();
		
	}
}
