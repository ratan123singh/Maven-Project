import java.awt.AWTException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Warranty extends Firstproject {
	private static WebDriver d;

	public static void main(String[] args) throws FindFailed, InterruptedException, AWTException {

		Warranty obj = new Warranty();
		d = obj.initialize();

		d.get("https://ticycles.experiencecommerce.com/");
		
		String title = d.getTitle();
		System.out.println(title);
		
		String currentURL = d.getCurrentUrl();
		System.out.println(currentURL);
		
		String pageSource = d.getPageSource();
		System.out.println(pageSource);
		
		JavascriptExecutor js = (JavascriptExecutor)d;
		
		for(int i=1;i<10;i++)
		{
			js.executeScript("window.scrollBy(0,1000)"); //scroll down page
			Thread.sleep(1000);
		}
		for(int i=1; i<10; i++)
		{
			js.executeScript("window.scrollBy(0,-1000)"); //scroll upside page

		}
		
		d.findElement(By.xpath("//a[@href='https://ticycles.experiencecommerce.com/warranty']")).click();
		Thread.sleep(2000);

		d.findElement(By.id("btn_register_warranty")).click();
		Thread.sleep(2000);

		d.findElement(By.id("owner_name")).sendKeys("Ratan Singh");

		d.findElement(By.id("owner_mobileno")).sendKeys("8898952624");

		d.findElement(By.id("owner_email")).sendKeys("ratan@gmail.com");

		d.findElement(By.xpath("//div[@class='selectize-control clickDrpDwn2 single']")).click();

		d.findElement(By.xpath("//div[@data-value='male']")).click();

		d.findElement(By.id("customer_age")).sendKeys("22");

		WebElement autoOptions = d.findElement(By.xpath(
				"//select[@id='owner_state']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
		autoOptions.sendKeys("MAHARASHTRA", Key.ENTER);

		List<WebElement> optionsToSelect = d.findElements(By.xpath("//div[contains(text(),'MAHARASHTRA')]"));

		for (WebElement option : optionsToSelect) {
			System.out.println(option);
			if (option.getText().equals("MAHARASHTRA")) {
				System.out.println("Trying to select: " + "MAHARASHTRA");
				option.click();
				break;
			}
		}
		Thread.sleep(2000);

		WebElement autoOptions1 = d.findElement(By.xpath(
				"//select[@id='owner_city']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
		autoOptions1.sendKeys("MUMBAI", Key.ENTER);

		List<WebElement> optionsToSelect1 = d.findElements(By.xpath("//div[contains(text(),'MUMBAI')]"));

		for (WebElement option : optionsToSelect1) {
			System.out.println(option);
			if (option.getText().equals("MUMBAI")) {
				System.out.println("Trying to select: " + "MUMBAI");
				option.click();
				break;
			}
		}

		Thread.sleep(2000);

		WebElement autoOptions2 = d.findElement(By.xpath(
				"//select[@id='owner_pincode']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
		autoOptions2.sendKeys("111111", Key.ENTER);

		List<WebElement> optionsToSelect2 = d.findElements(By.xpath("//div[contains(text(),'111111')]"));

		for (WebElement option : optionsToSelect2) {
			System.out.println(option);
			if (option.getText().equals("111111")) {
				System.out.println("Trying to select: " + "111111");
				option.click();
				break;
			}
		}

		d.findElement(By.id("owner_address")).sendKeys("Sakinaka, Mumbai");

		d.findElement(By.xpath("//input[@type='text'][@id='date_of_purchase']")).click();

		Date date = new Date(0);
		SimpleDateFormat s1 = new SimpleDateFormat("d");
		SimpleDateFormat s2 = new SimpleDateFormat("MM");
		String str1 = s1.format(date);
		String str2 = s2.format(date);
		System.out.println(str1);
		System.out.println(str2);

		d.findElement(By.xpath("//button[text()='Set']")).click();

		d.findElement(By.id("frame_number")).sendKeys("MH03A1211");

		Thread.sleep(2000);
		
		d.findElement(By.xpath("//input[@placeholder='Select Brand*']")).click();

		d.findElement(By.xpath("//div[@data-value='659']")).click();
		Thread.sleep(2000);

		d.findElement(By.xpath("//input[@type='text'][@placeholder='Select Model']")).click();
		Thread.sleep(2000);

		d.findElement(By.xpath("//div[@data-value='3907'][text()='BSA Ladybird Ibiza']")).click();
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

		// d.findElement(By.id("btn_register_warranty")).click();
	WebElement btn=	d.findElement(By.id("btn_register_warranty"));
	//btn.click();

	}
}