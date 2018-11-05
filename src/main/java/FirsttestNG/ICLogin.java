package FirsttestNG;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ICLogin {
	public WebDriver d;

	@Test(dataProvider = "testdata")
	public void Login(String phone_number)
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		DesiredCapabilities chrome_cap = DesiredCapabilities.chrome();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("incognito");

		chrome_cap.setCapability(ChromeOptions.CAPABILITY, options);

		d = new ChromeDriver(chrome_cap);

		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		d.manage().window().maximize();

		Thread.sleep(3000);

		d.navigate().to("https://navendor-ic-staging.herokuapp.com/login");
		
		Thread.sleep(3000);
		
		d.findElement(By.xpath("//input[@type='tel']")).sendKeys(phone_number);

		d.findElement(By.xpath("//button[@type='submit']")).click();

		String dbUrl = "DB URL";

		// Database Username
		String username = "DB username";

		// Database Password
		String password = "DB Password";
		Thread.sleep(5000);
		// Query to Execute
		String query = "Insert query to fetch mobile number from db";

		// Load mysql jdbc driver
		Class.forName("org.postgresql.Driver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		// testing
		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);
		// try{
		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String phone = rs.getString(7);
			String name = rs.getString(6);
			String email = rs.getString(8);
			String address = rs.getString(9);
			String otp = rs.getString(19);
			String sap_code = rs.getString(13);
			System.out.println("Name is " + name);
			System.out.println("Phone Number is " + phone);
			System.out.println("Email id is " + email);
			System.out.println("Address is " + address);
			System.out.println("Sap code is " + sap_code);
			System.out.println("OTP is " + otp);

			Thread.sleep(2000);
			d.findElement(By.xpath("//input[@class='pincode-input-text']")).sendKeys(otp);
			Thread.sleep(5000);
		}

		Assert.assertEquals("https://navendor-ic-staging.herokuapp.com/home", d.getCurrentUrl());
		System.out.println("Successfully Login");
	}
	@DataProvider(name = "testdata")
	public Object[][] readExcel() throws BiffException, IOException {
		File f = new File("C://Users//Ratan//Downloads//Customers to be upload (7) (1).xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet2");

		int rows = s.getRows();
		int columns = s.getColumns();
		System.out.println("Number of rows " + rows);
		System.out.println("Number of columns " + columns);

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
			Assert.assertEquals("https://navendor-ic-staging.herokuapp.com/login", d.getCurrentUrl());
			System.out.println("Phone number is not registered with us.");
		}
		d.quit();
	}
	public String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}