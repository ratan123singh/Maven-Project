
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firstproject 
{

	public WebDriver initialize() throws AWTException
	{
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		
		
		DesiredCapabilities chrome_cap = DesiredCapabilities.chrome();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("incognito");
		
		chrome_cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriver d = new ChromeDriver(chrome_cap); 
		
		d.manage().deleteAllCookies();
				
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		return d;
	}
	private DesiredCapabilities DesiredCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}
	public WebDriver quitwindow(WebDriver d) throws Exception
	{
		d.quit();
		
		try
		{
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return d;
	}
	
}