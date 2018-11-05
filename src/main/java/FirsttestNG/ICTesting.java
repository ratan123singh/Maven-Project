package FirsttestNG;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ICTesting {
	public WebDriver d;

	@Test(dataProvider="testdata")
	public void tiLogin(String email_address, String password) {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		d = new ChromeDriver();

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.manage().window().maximize();

		d.navigate().to("https://navendor-ic.herokuapp.com/home");

		d.findElement(By.xpath("//a[text()='sign in']")).click();

		d.findElement(By.id("edit-name")).sendKeys(email_address);

		d.findElement(By.id("edit-pass")).sendKeys(password);

		d.findElement(By.name("op")).click();
		
		Assert.assertEquals("https://ticycles.experiencecommerce.com/users/ratansingh5322", d.getCurrentUrl());
		
		//using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = d.getWindowHandles();
		
		//using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();
		
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
			
		//switch to each browser window
		d.switchTo().window(windowHandle);
		String title = d.getTitle();
		
		//print the window handle id of each browser window
		System.out.println("Window handle id of page -->"+ title +" --> is : "+windowHandle);

	}
	}

	@AfterMethod
	public void tearDown() {
		d.close();

	}	
	
	@DataProvider(name="testdata")
	public Object[][] readExcel() throws BiffException, IOException {
		File f = new File("C:/Users/Ratan/Desktop/MyexcelSheet.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet4");
			
		int rows = s.getRows();
		int columns = s.getColumns();
		System.out.println(rows);
		System.out.println(columns);

		String inputData[][] = new String [rows] [columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell c = s.getCell(j, i);

				inputData[i][j] = c.getContents();
				System.out.println(inputData[i][j]);
			}
		}
		return inputData;

	}
}
