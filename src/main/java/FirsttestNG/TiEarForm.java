package FirsttestNG;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Key;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TiEarForm {
	public WebDriver d;

	@Test(dataProvider = "testdata")
	public void tiLogin(String Name, String Email, String Mobile_Number, String State, String City, String Pin_code)
			throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		d = new ChromeDriver();

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.manage().window().maximize();

		Thread.sleep(2000);

	//	try {

			d.navigate().to(" ");

			d.findElement(By.id("btn_experience_visit")).click();

			d.findElement(By.name("name")).sendKeys(Name);

			d.findElement(By.name("email")).sendKeys(Email);

			d.findElement(By.name("mobile")).sendKeys(Mobile_Number);

			Thread.sleep(2000);

			WebElement autoOptions = d.findElement(By.xpath(
					"//select[@id='visit_state']/..//div[@class='selectize-control clickDrpDwn2 clear_field single']/..//input[@type='text']"));
			autoOptions.sendKeys(State, Key.ENTER);

			List<WebElement> optionsToSelect = d.findElements(By.xpath("//div[contains(text(), 'MAHARASHTRA')]"));

			for (WebElement option : optionsToSelect) {
				System.out.println(option);
				if (option.getText().equals(State)) {
					System.out.println("Trying to select: " + State);
					option.click();
					break;
				}
			}
			Thread.sleep(2000);

			WebElement autoOptions1 = d.findElement(By.xpath(
					"//select[@id='visit_city']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
			autoOptions1.sendKeys(City, Key.ENTER);

			List<WebElement> optionsToSelect1 = d.findElements(By.xpath("//div[contains(text(), 'MUMBAI')]"));

			for (WebElement option : optionsToSelect1) {
				System.out.println(option);
				if (option.getText().equals(City)) {
					System.out.println("Trying to select: " + City);
					option.click();
					break;
				}
			}
			Thread.sleep(2000);

			WebElement autoOptions2 = d.findElement(By.xpath(
					"//select[@id='visit_pincode']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
			autoOptions2.sendKeys(Pin_code, Key.ENTER);

			List<WebElement> optionsToSelect2 = d.findElements(By.xpath("//div[contains(text(), '111111')]"));

			for (WebElement option : optionsToSelect2) {
				System.out.println(option);
				if (option.getText().equals(Pin_code)) {
					System.out.println("Trying to select: " + Pin_code);
					option.click();
					break;
				}
			}
			d.findElement(By.id("btn_visit_submit")).click();

			d.findElement(By.id("btn_ok")).click();
			Thread.sleep(1000);
//		} catch (Exception e) {
//			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
//			Date date = new Date();
//			File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(scrFile,
//					new File("D://Screenshot//" + "screenshot" + "-" + dateFormat.format(date) + ".png"));
//		}

		Assert.assertEquals(" ",
				d.getCurrentUrl());

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
	public Object[][] readExcel() throws BiffException, IOException, RowsExceededException, WriteException {
		File f = new File("C:/Users/Ratan/Desktop/Qspiders.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet2");

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
				TakesScreenshot screenshot = (TakesScreenshot) d;

				File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location
				// result.getName() will return name of test case so that
				// screenshot name will be same as test case name
				FileUtils.copyFile(scrFile,
						new File("D://Screenshot//" + "screenshot" + "-" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			Assert.assertEquals(" ", d.getCurrentUrl());
			System.out.println("Invalid Data");
		}
		d.quit();
	}
}
