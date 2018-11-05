package FirsttestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestGrid {
	
	@Test
	public void test1() throws MalformedURLException
	{
//		System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
		
	       String path = "D:\\geckodriver";
	        System.out.println("******** " + path);
			System.setProperty("webdriver.gecko.driver", path);

		DesiredCapabilities cap = DesiredCapabilities.firefox();
		
		cap.setPlatform(Platform.WINDOWS);
		
		URL url = new URL(" ");
				
		cap.setCapability("marionette", true);
		cap.setCapability("networkConnectionEnabled", true);
		cap.setCapability("browserConnectionEnabled", true);
		
		WebDriver d = new RemoteWebDriver(url, cap); // error idhar hai
		
		d.manage().deleteAllCookies();
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		d.get("https://learn-automation.com");
		
		System.out.println("Title is "+d.getTitle());
		
		d.quit();
	}
}
