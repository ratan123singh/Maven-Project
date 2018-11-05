package FirsttestNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot {
	
	@Test

	public static void captureScreenMethod() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		
		WebDriver d = new ChromeDriver();
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.manage().deleteAllCookies();
		
		try
		{
		
		d.navigate().to("https://ticycles.experiencecommerce.com/");
		
		d.navigate().refresh();
		
		d.findElement(By.xpath("//a[text()='sign in']")).click();
		
		d.findElement(By.id("edit-name")).sendKeys("ratan.singh.@experiencecommerce.com");

		d.findElement(By.id("edit-pass")).sendKeys("ratan123");

		d.findElement(By.name("op")).click();
		
		}
		catch(Exception e)
		{
			File screenshotFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("D://Screenshot//Screenshot.png"));
			
		}
			d.close();
			d.quit();
	}

}
