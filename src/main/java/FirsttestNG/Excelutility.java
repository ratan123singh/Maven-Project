package FirsttestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excelutility {
	public WebDriver d;
    public String Testcase;
    public WritableSheet writablesh;
    public WritableWorkbook workbookcopy;

@DataProvider(name = "testdata")
public void queryParameterization() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException{

FileInputStream testfile = new FileInputStream("C://Users//Ratan//Desktop//Untitled 1.xls");
//Now get Workbook
Workbook wbook = Workbook.getWorkbook(testfile);
//Now get Workbook Sheet
Sheet sheets = wbook.getSheet("Sheet1");
int Norows = sheets.getRows();
//Read rows and columns and save it in String Two dimensional array
String inputdata[][] = new String[sheets.getRows()][sheets.getColumns()];
System.out.println("Number of rows present in TestData xls file is -"+Norows);

//For writing the data into excel we will use FileoutputStream class
FileOutputStream testoutput = new FileOutputStream("C://Users//Ratan//Desktop//Untitled 1_results.xls");
System.out.println("creating file one");
//To Create writable workbook
workbookcopy = Workbook.createWorkbook(testoutput);
System.out.println("creating file 2");
//To Create Writable sheet in Writable workbook
writablesh = workbookcopy.createSheet("Sheet1",0);
System.out.println("creating file 3");

//Using for loop to write all the data to new sheet
    for(int i=0;i<sheets.getRows();i++)
       {
        for(int k=0;k<sheets.getColumns();k++)
        {
         inputdata[i][k] = sheets.getCell(k, i).getContents();
         Label l = new Label(k, i, inputdata[i][k]);
         Label l2 = new Label(4,0,"Results");            
         writablesh.addCell(l);
         writablesh.addCell(l2);
        }
       }            
    }
@Test(dataProvider = "testdata")
public void Login(String phone_number)
		throws IOException, ClassNotFoundException, SQLException, InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

	d = new ChromeDriver();

	d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	d.manage().window().maximize();

	d.navigate().to("https://navendor-ic-staging.herokuapp.com/login");

	d.findElement(By.xpath("//input[@type='tel']")).sendKeys(phone_number);

	d.findElement(By.xpath("//button[@type='submit']")).click();

	String dbUrl = "Insert DB URL";

	// Database Username
	String username = "Insert DB Username";

	// Database Password
	String password = "Insert DB Password";
	Thread.sleep(5000);
	// Query to Execute
	String query = "Insert query to fetch phone numer from DB";

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



@AfterTest
public void writeexcels(){
    try {
        workbookcopy.write();
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        workbookcopy.close();
    } catch (WriteException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }   
}
}