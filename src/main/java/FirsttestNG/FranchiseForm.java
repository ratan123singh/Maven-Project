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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FranchiseForm {
	public WebDriver d;

	@Test(dataProvider = "testdata")
	public void tiLogin(String Full_Name, String Contact, String Email_Id, String Business, String Company_Name,
			String Designation, String Area_of_interest, String State, String City, String Carpet_area_in_sqft, String TT_Franchise)
			throws IOException, InterruptedException, FindFailed {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		d = new ChromeDriver();

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.manage().window().maximize();
		
		try{

		d.get("https://ticycles.experiencecommerce.com/");

		String title = d.getTitle();
		System.out.println(title);

		String currentURL = d.getCurrentUrl();
		System.out.println(currentURL);

		String pageSource = d.getPageSource();
		System.out.println(pageSource);

		JavascriptExecutor js = (JavascriptExecutor) d;

		for (int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0,1000)"); // scroll down page
			Thread.sleep(1000);
		}
		for (int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0,-1000)"); // scroll upside page

		}

		Thread.sleep(2000);

		d.findElement(By.xpath("//a[text()='Franchise Enquiry']")).click();

		d.findElement(By.id("btn_franchise_ok")).click();

		d.findElement(By.id("name")).sendKeys(Full_Name);

		d.findElement(By.id("mobile_number")).sendKeys(Contact);

		d.findElement(By.id("email")).sendKeys(Email_Id);

		d.findElement(By.id("profession")).sendKeys(Business);

		d.findElement(By.id("company_name")).sendKeys(Company_Name);

		d.findElement(By.id("designation")).sendKeys(Designation);

		d.findElement(By.id("area_of_interest")).sendKeys(Area_of_interest);

		Thread.sleep(1000);

		WebElement autoOptions = d.findElement(By.xpath(
				"//select[@id='state']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
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
				"//select[@id='city']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
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

		d.findElement(By
				.xpath("//div[@class='inputField floating-label']/..//select[@id='ride_bicycle']/..//div[@class='selectize-control clickDrpDwn2 single']"
						+ "/..//div[@class='selectize-input items full has-options has-items']"))
				.click();

		Thread.sleep(2000);

		d.findElement(By.xpath("//*[@id='franchise_form']/div/div/div[10]/div/div[2]/div/div[3]")).click();
		Thread.sleep(2000);

		d.findElement(By.xpath("//div[@class='selectize-input items full has-options has-items']")).click();

		Thread.sleep(2000);

		d.findElement(By.xpath("//*[@id='franchise_form']/div/div/div[11]/div/div[2]/div/div[2]")).click();

		Thread.sleep(2000);

		d.findElement(By.id("carpet_area")).sendKeys(Carpet_area_in_sqft);

		d.findElement(By.id("why_track_trail")).sendKeys(TT_Franchise);
		
		}catch(Exception e){
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date5 = new Date();
		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File("D://Screenshot//" + "screenshot" + "-" + dateFormat.format(date5) + ".png"));
		}
		Assert.assertEquals("https://ticycles.experiencecommerce.com/franchise-enquiry", d.getCurrentUrl());

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

	@AfterMethod
	public void tearDown() {
		d.close();

	}

	@DataProvider(name = "testdata")
	public Object[][] readExcel() throws BiffException, IOException {
		File f = new File("C:/Users/Ratan/Desktop/Qspiders.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet4");

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
}