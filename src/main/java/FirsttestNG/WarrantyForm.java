package FirsttestNG;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class WarrantyForm {
	public WebDriver d;

	@Test(dataProvider = "testdata")
	public void tiLogin(String Name, String Contact_Number, String Email_Id, String Age, String State, String City,
			String Pin_code, String Address, String F_S_Number, String Brand, String Model)
			throws IOException, InterruptedException, FindFailed {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		d = new ChromeDriver();

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.manage().window().maximize();

			d.get("https://ticycles.experiencecommerce.com/");

//			String title = d.getTitle();
//			System.out.println(title);
//
//			String currentURL = d.getCurrentUrl();
//			System.out.println(currentURL);
//
//			String pageSource = d.getPageSource();
//			System.out.println(pageSource);

			JavascriptExecutor js = (JavascriptExecutor) d;

			for (int i = 1; i < 10; i++) {
				js.executeScript("window.scrollBy(0,1000)"); // scroll down page
				Thread.sleep(1000);
			}
			for (int i = 1; i < 10; i++) {
				js.executeScript("window.scrollBy(0,-1000)"); // scroll upside
																// page

			}

			Thread.sleep(2000);

			d.findElement(By.xpath("//a[@href='https://ticycles.experiencecommerce.com/warranty']")).click();
			Thread.sleep(2000);

			d.findElement(By.id("btn_register_warranty")).click();
			Thread.sleep(2000);

			d.findElement(By.id("owner_name")).sendKeys(Name);

			d.findElement(By.id("owner_mobileno")).sendKeys(Contact_Number);

			d.findElement(By.id("owner_email")).sendKeys(Email_Id);

			d.findElement(By.xpath("//div[@class='selectize-control clickDrpDwn2 single']")).click();

			d.findElement(By.xpath("//div[@data-value='male']")).click();

			d.findElement(By.id("customer_age")).sendKeys(Age);

			WebElement autoOptions = d.findElement(By.xpath(
					"//select[@id='owner_state']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
			autoOptions.sendKeys(State, Key.ENTER);

			List<WebElement> optionsToSelect = d.findElements(By.xpath("//div[contains(text(),'MAHARASHTRA')]"));

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
					"//select[@id='owner_city']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
			autoOptions1.sendKeys(City, Key.ENTER);

			List<WebElement> optionsToSelect1 = d.findElements(By.xpath("//div[contains(text(),'MUMBAI')]"));

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
					"//select[@id='owner_pincode']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
			autoOptions2.sendKeys(Pin_code, Key.ENTER);

			List<WebElement> optionsToSelect2 = d.findElements(By.xpath("//div[contains(text(),'111111')]"));

			for (WebElement option : optionsToSelect2) {
				System.out.println(option);
				if (option.getText().equals(Pin_code)) {
					System.out.println("Trying to select: " + Pin_code);
					option.click();
					break;
				}
			}

			d.findElement(By.id("owner_address")).sendKeys(Address);

			d.findElement(By.xpath("//input[@type='text'][@id='date_of_purchase']")).click();

			Date date = new Date(0);
			SimpleDateFormat s1 = new SimpleDateFormat("d");
			SimpleDateFormat s2 = new SimpleDateFormat("MM");
			String str1 = s1.format(date);
			String str2 = s2.format(date);
			System.out.println(str1);
			System.out.println(str2);

			d.findElement(By.xpath("//button[text()='Set']")).click();

			d.findElement(By.id("frame_number")).sendKeys(F_S_Number);

			Thread.sleep(2000);

			WebElement autoOptions3 = d.findElement(By.xpath("//input[@placeholder='Select Brand*']"));
			autoOptions3.sendKeys(Brand, Key.ENTER);

			List<WebElement> optionsToSelect3 = d.findElements(By.xpath("//div[contains(text(),'BSA Ladybird')]"));

			for (WebElement option : optionsToSelect3) {
				System.out.println(option);
				if (option.getText().equals(Brand)) {
					System.out.println("Trying to select: " + Brand);
					option.click();
					break;
				}
			}

			Thread.sleep(4000);

			WebElement autoOptions4 = d.findElement(By.xpath("//input[@placeholder='Select Model']"));
			autoOptions4.sendKeys(Model, Key.ENTER);

			List<WebElement> optionsToSelect4 = d
					.findElements(By.xpath("//div[@data-value='3907'][@class='item']"));

			for (WebElement option : optionsToSelect4) {
				System.out.println(option);	
				if (option.getText().equals(Model)) {
					System.out.println("Trying to select: " + Model);
					option.click();
					break;
				}
			}
			Thread.sleep(2000);

			d.findElement(By.id("invoice_image")).click();
			Screen sc1 = new Screen();
			Pattern p1 = new Pattern("C:\\Users\\Ratan\\Desktop\\tt1.jpg");
			sc1.type(p1, "C:\\Users\\Ratan\\Pictures\\Localhost-9000(RunningProperly).PNG");
			Pattern p2 = new Pattern("C:\\Users\\Ratan\\Desktop\\open.jpg");
			sc1.click(p2);

			d.findElement(By.id("frame_number_image")).click();
			Screen sc2 = new Screen();
			Pattern p3 = new Pattern("C:\\Users\\Ratan\\Desktop\\tt2.jpg");
			sc2.type(p3, "C:\\Users\\Ratan\\Downloads\\Blog_detail_page.jpg");
			Pattern p4 = new Pattern("C:\\Users\\Ratan\\Desktop\\2018-07-30_20-25_Open.jpg");
			sc2.click(p4);

			d.findElement(By.id("terms_n_condition")).click();

			d.findElement(By.id("btn_register_warranty")).click();
			WebElement btn = d.findElement(By.id("btn_register_warranty"));
			btn.click();

		String url = d.getCurrentUrl();

		Assert.assertEquals("https://ticycles.experiencecommerce.com/warranty", url);
		System.out.println("successfully submitted");

		// using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = d.getWindowHandles();

		// using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();

		System.out.println("Number of browser windows opened on the system is : " + count);
		for (String windowHandle : allWindowHandles) {

			// switch to each browser window
			d.switchTo().window(windowHandle);
			String title1 = d.getTitle();

			// print the window handle id of each browser window
			System.out.println("Window handle id of page -->" + title1 + " --> is : " + windowHandle);

		}
	}

	


	@DataProvider(name = "testdata")
	public Object[][] readExcel() throws BiffException, IOException {
		File f = new File("C:/Users/Ratan/Desktop/Qspiders.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet3");

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
			// FileOutputStream fos = new
			// FileOutputStream("C:/Users/Ratan/Desktop/MyexcelSheet.xls");
			// f.write(fos);
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
		Assert.assertEquals("https://ticycles.experiencecommerce.com/warranty", d.getCurrentUrl());
		System.out.println("Invalid data");
	}
	d.quit();
}
}