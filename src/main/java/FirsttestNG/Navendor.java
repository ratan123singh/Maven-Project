package FirsttestNG;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navendor {
	public static void main(String[] args)
			throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe"); 
		
		ChromeDriver d = new ChromeDriver(); 

		d.get("https://lead-retail-x-staging.herokuapp.com/login");

		d.manage().window().maximize();

		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

//		Robot r1 = new Robot();
//
//		r1.keyPress(KeyEvent.VK_CONTROL);
//		r1.keyPress(KeyEvent.VK_SHIFT);
//		r1.keyPress(KeyEvent.VK_I);
//
//		Thread.sleep(2000);

		// r1.keyPress(KeyEvent.VK_CONTROL);
		// r1.keyPress(KeyEvent.VK_SHIFT);
		// r1.keyPress(KeyEvent.VK_M);

		// Thread.sleep(2000);

//		r1.keyRelease(KeyEvent.VK_CONTROL);
//		r1.keyRelease(KeyEvent.VK_SHIFT);
//		r1.keyRelease(KeyEvent.VK_I);
//
//		Thread.sleep(2000);

		// r1.keyRelease(KeyEvent.VK_CONTROL);
		// r1.keyRelease(KeyEvent.VK_SHIFT);
		// r1.keyRelease(KeyEvent.VK_M);

		d.findElement(By.xpath("//*[@placeholder='Enter your phone number']	")).sendKeys("9167987069");
		Thread.sleep(2000);

		d.findElement(By.xpath("//button[@type='submit']/..//span[text()='Login']")).click();
		Thread.sleep(2000);

		String dbUrl = "Insert DB  URL";

		// Database Username
		String username = "Insert DB Username";

		// Database Password
		String password = "Insert DB Password";

		// Query to Execute
		String query = "Insert query to fetch phone number from db";

		// Load mysql jdbc driver
		Class.forName("org.postgresql.Driver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		// testing
		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

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

			d.findElement(By.xpath("//input[@class='pincode-input-text']")).sendKeys(otp);
			Thread.sleep(2000);

			d.findElement(By.xpath("//a[@class='lr-notifications-pop__interaction__nothanks']//span[text()='No Thanks']")).click();
			
			d.findElement(By.xpath("//div[@class='nav-text']//h3[text()='Book Order']")).click();
			
			d.findElement(By.xpath("//div[@class='enjoyhint_close_btn']")).click();
			
			d.findElement(By.xpath("//div[@class='lr-customer-row__full-name']//span[text()='THAKKAR POPATLAL VELJI SALES LTD']")).click();
			
			d.findElement(By.xpath("//span[text()='NEXT']")).click();
			
			d.findElement(By.id("myQuantityVal")).sendKeys("55");
			
			d.findElement(By.xpath("//div[@class='lr-order-product-box ']//h3[text()='Ambuja Cement Paper Bag']")).click();
			
			d.findElement(By.xpath("//span[text()='NEXT']")).click();

			d.findElement(By.xpath("//div[@class='lr-address-row__address']")).click();
			
			d.findElement(By.xpath("//span[text()='NEXT']")).click();

			d.findElement(By.xpath("//span[text()='ORDER']")).click();
		}
	}
}
