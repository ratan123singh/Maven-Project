package utils.excelutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.testng.annotations.AfterMethod;
 
import org.testng.annotations.Test;
public class WebDriverTest {
 
private WebDriver driver;
@Test
 
public void valid() throws Exception {
 
driver = new ChromeDriver();
 
driver.get("https://accounts.google.com/");
 
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
driver.findElement(By.id("Email")).sendKeys("abc");
 
driver.findElement(By.id("Passwd")).sendKeys("xyz");
 
driver.findElement(By.id("signIn")).click();
 
}
@Test
 
public void invalid_BlankPassword() throws Exception {
 
driver = new ChromeDriver();
 
driver.get("https://accounts.google.com/");
 
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
driver.findElement(By.id("Email")).sendKeys("abc");
 
driver.findElement(By.id("Passwd")).sendKeys("");
 
driver.findElement(By.id("signIn")).click();
 
}
@AfterMethod
 
public void tearDown() throws Exception {
 
driver.quit();
 
}
 
}