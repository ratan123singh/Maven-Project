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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGScript {
	WebDriver d;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		d = new ChromeDriver();

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		d.manage().window().maximize();

		d.manage().deleteAllCookies();

		d.navigate().to(" ");
		

		//login("ratan.singh@experiencecommerce.com", "ratan123");
	}

//	@Test(priority = 3, description = "loginpage")
//	public void clickOnSignin() {
//		d.findElement(By.xpath("//a[text()='sign in']")).click();
//		// Assert.assertEquals(login, "User account");
//	}

	@Test(priority = 1, description = "verifyPageTitleTest")
	public void verifyPageTitleTest() throws IOException {
		String title = d.getTitle();
		System.out.println("The page title is:" + title);
		Assert.assertEquals(title, "Track & Trail");
		File screenshotFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("D://Screenshot//Screenshot.png"));
		String currentURL = d.getCurrentUrl();
		System.out.println(currentURL);
		String pageSource = d.getPageSource();
		System.out.println(pageSource);
	}

	@Test(priority = 2, description = "verifyTiLogoTest")
	public void verifyTiLogoTest() throws IOException {
		boolean flag = d.findElement(By.xpath("//a[@class='mainLogo']")).isDisplayed();
		Assert.assertTrue(flag);
		File screenshotFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("D://Screenshot//Screenshot.png"));
		String pageSource = d.getPageSource();
		System.out.println(pageSource);
	}

	@Test(priority = 4, description = "Login")
	public void login() throws IOException {
		d.findElement(By.xpath("//a[text()='sign in']")).click();
		
		d.findElement(By.id("edit-name")).sendKeys(" ");

		d.findElement(By.id("edit-pass")).sendKeys(" ");

		d.findElement(By.name("op")).click();
		
		File screenshotFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("D://Screenshot//Screenshot.png"));
		
	    Assert.assertTrue(d.getPageSource().contains("My Profile"));
		String currentURL = d.getCurrentUrl();
		System.out.println(currentURL);
	    String pageSource = d.getPageSource();
		System.out.println(pageSource);
		

	}
	
	@Test(priority = 3, description = "Login")
	public void login1() {
		d.findElement(By.xpath("//a[text()='sign in']")).click();
		
		d.findElement(By.id("edit-name")).sendKeys(" ");

		d.findElement(By.id("edit-pass")).sendKeys(" ");

		d.findElement(By.name("op")).click();
		
	    Assert.assertEquals(d.findElement(By.xpath("//div[@class='messages error']")).getText(),"Error message"
	    		+ "Invalid Email-Id/Password]");

		String currentURL = d.getCurrentUrl();
		System.out.println(currentURL);
	    String pageSource = d.getPageSource();
		System.out.println(pageSource);
	}

	@AfterMethod
	public void tearDown() {
		d.quit();
	}
}
