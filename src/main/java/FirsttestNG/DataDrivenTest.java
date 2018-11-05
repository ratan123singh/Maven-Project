package FirsttestNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenTest {
	public WebDriver d;

	@Test(dataProvider = "testdata")
	public void tiLogin(String email_address, String password) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		d = new ChromeDriver();

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.manage().window().maximize();
		
		Thread.sleep(2000);
		

		d.navigate().to("URL");

		d.findElement(By.xpath("//a[text()='sign in']")).click();

		d.findElement(By.id("edit-name")).sendKeys(email_address);

		d.findElement(By.id("edit-pass")).sendKeys(password);

		d.findElement(By.name("op")).click();
		
		
		
			WebElement wc= d.findElement(By.id("user_name_hover"));
			System.out.println(wc);
			Assert.assertEquals("https://ticycles.experiencecommerce.com/user/"+wc, d.getCurrentUrl());

			System.out.println("Successfully login");
		

//		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
//		Date date = new Date();
//		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile,
//		new File("D://Screenshot//" + "screenshot" + "-" + dateFormat.format(date) + ".png"));
		
//		WebElement wc= d.findElement(By.id("user_name_hover"));
//		System.out.println(wc);
//		Assert.assertEquals("https://ticycles.experiencecommerce.com/users/"+wc, d.getCurrentUrl());

		// using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = d.getWindowHandles();

		// using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();

		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allWindowHandles) {

			// switch to each browser window
			d.switchTo().window(windowHandle);
			String title = d.getTitle();

			// print the window handle id of each browser window
			System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);

		}
	}


	@DataProvider(name = "testdata")
	public Object[][] readExcel() throws BiffException, IOException {
		File f = new File("C:/Users/Ratan/Desktop/Qspiders.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet5");

		int rows = s.getRows();
		int columns = s.getColumns();
		System.out.println(rows);
		System.out.println(columns);

		String inputData[][] = new String[rows][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell c = s.getCell(j, i);

				inputData[i][j] = c.getContents();
				System.out.println(inputData[i][j]);
			}
		}
		return inputData;
		 
	}
	@AfterMethod
	public void screenShot(ITestResult result) {
		// using ITestResult.FAILURE is equals to result.getStatus then it enter
		// into if condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// To create reference of TakesScreenshot
//				 DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
//			        Date date = new Date();

				File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				// Copy files to specific location
				// result.getName() will return name of test case so that
				// screenshot name will be same as test case name
				FileUtils.copyFile(scrFile,
						new File("D://Screenshot//" + "screenshot" + "-" + timestamp() + ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			Assert.assertEquals("https://ticycles.experiencecommerce.com/user", d.getCurrentUrl());
			System.out.println("Invalid username/password");
		}
		d.quit();
	}
	public String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}