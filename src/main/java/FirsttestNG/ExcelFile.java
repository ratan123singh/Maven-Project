package FirsttestNG;

import java.io.File;
import java.io.IOException;
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

public class ExcelFile {
	public WebDriver d;

	@Test(dataProvider="testdata")
	public void tiLogin(String email_address, String password) {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		d = new ChromeDriver();

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.manage().window().maximize();

		d.navigate().to("URL");

		d.findElement(By.xpath("//a[text()='sign in']")).click();

		d.findElement(By.id("edit-name")).sendKeys(email_address);

		d.findElement(By.id("edit-pass")).sendKeys(password);

		d.findElement(By.name("op")).click();
		
		Assert.assertEquals("https://ticycles.experiencecommerce.com/users/ratansingh5322", d.getCurrentUrl());

	}

	@AfterMethod
	public void tearDown() {
		d.close();

	}	
	
	@DataProvider(name = "testdata")
	public Object[][] readExcel() throws BiffException, IOException {
		File f = new File("C:/Users/Ratan/Desktop/MyexcelSheet.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet2");
			
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