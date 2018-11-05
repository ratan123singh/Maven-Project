package FirsttestNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveNavendor {
	public static void main(String[] args) throws InterruptedException, AWTException, ClassNotFoundException, SQLException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");

		ChromeDriver d = new ChromeDriver(); 

		d.get("https://www.navendor.com/login");

		d.manage().window().maximize();

		Robot r1 = new Robot();

		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_SHIFT);
		r1.keyPress(KeyEvent.VK_I);

		Thread.sleep(2000);

		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_SHIFT);
		r1.keyPress(KeyEvent.VK_M);

		Thread.sleep(2000);

		r1.keyRelease(KeyEvent.VK_CONTROL);
		r1.keyRelease(KeyEvent.VK_SHIFT);
		r1.keyRelease(KeyEvent.VK_I);

		Thread.sleep(2000);

		r1.keyRelease(KeyEvent.VK_CONTROL);
		r1.keyRelease(KeyEvent.VK_SHIFT);
		r1.keyRelease(KeyEvent.VK_M);

		d.findElement(By.xpath("//input[@type='tel']")).sendKeys("8898952624");
		Thread.sleep(2000);

		d.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		 String dbUrl = "";					

			//Database Username		
			String username = "";	
         
			//Database Password		
			String password = "";				

			//Query to Execute		
			String query = "select * from businesses where phone = '+918898952624';";	
         
  	    //Load mysql jdbc driver		
    	    Class.forName("org.postgresql.Driver");			
    
    		//Create Connection to DB		
     	Connection con = DriverManager.getConnection(dbUrl,
     			username, password);
   
   		//Create Statement Object		
 	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
  		ResultSet rs= stmt.executeQuery(query);							
  
  		// While Loop to iterate through all data and print results		
			while (rs.next()){
		        		String phone = rs.getString(7);								        
                     String name = rs.getString(6);
                     String email = rs.getString(8);
                     String address = rs.getString(9);
                     String otp = rs.getString(19);
                     String sap_code = rs.getString(13);
                     
                    // String websales_id = rs.getString(7);
                     
                     
                     System. out.println("Name is "+name);
                     System. out.println("Phone Number is "+phone);
                     System.out.println("Email id is "+email);
                     System.out.println("Address is "+address);
                     System.out.println("Sap code is "+sap_code);
                     System.out.println("OTP is "+otp);
                     
                     d.findElement(By.xpath("//input[@type='tel'][@class='pincode-input-text']")).sendKeys(otp);
         			Thread.sleep(2000);

		d.findElement(By.xpath("//button[@class='lr-button lr-button--primary']/..//span[contains(text(), 'ALLOW')]")).click();
		Thread.sleep(1000);

		d.findElement(By.xpath("//*[@class='icon-add-customer']	")).click();
		Thread.sleep(1000);

			}
	}
}
