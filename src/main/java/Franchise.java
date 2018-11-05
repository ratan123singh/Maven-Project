
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;

public class Franchise extends Firstproject {
	public static WebDriver d;

	public static void main(String[] args) throws Exception {

		Franchise obj = new Franchise();
		d = obj.initialize();

		d.get("https://ticycles.experiencecommerce.com/");

		String title = d.getTitle();
		System.out.println(title);

		String currentURL = d.getCurrentUrl();
		System.out.println(currentURL);

		String pageSource = d.getPageSource();
		System.out.println(pageSource);

		JavascriptExecutor js = (JavascriptExecutor) d;

		for (int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0,1000)");
		}
		for (int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0, -1000)");
		}
		// d.manage().window().setSize(new Dimension(360,640));

		// Robot r1 =new Robot();
		//
		// r1.keyPress(KeyEvent.VK_CONTROL);
		// r1.keyPress(KeyEvent.VK_SHIFT);
		// r1.keyPress(KeyEvent.VK_I);
		//
		// Thread.sleep(2000);
		//
		// r1.keyPress(KeyEvent.VK_CONTROL);
		// r1.keyPress(KeyEvent.VK_SHIFT);
		// r1.keyPress(KeyEvent.VK_M);

		// Thread.sleep(2000);
		//
		// r1.keyRelease(KeyEvent.VK_CONTROL);
		// r1.keyRelease(KeyEvent.VK_SHIFT);
		// r1.keyRelease(KeyEvent.VK_I);

		Thread.sleep(2000);
		//
		// r1.keyRelease(KeyEvent.VK_CONTROL);
		// r1.keyRelease(KeyEvent.VK_SHIFT);
		// r1.keyRelease(KeyEvent.VK_M);

		d.findElement(By.xpath("//a[text()='Franchise Enquiry']")).click();

		d.findElement(By.id("btn_franchise_ok")).click();

		d.findElement(By.id("name")).sendKeys(" ");

		d.findElement(By.id("mobile_number")).sendKeys("");

		d.findElement(By.id("email")).sendKeys("");

		d.findElement(By.id("profession")).sendKeys("Testing");

		d.findElement(By.id("company_name")).sendKeys(" ");

		d.findElement(By.id("designation")).sendKeys("Quality Analyst");

		d.findElement(By.id("area_of_interest")).sendKeys("Watching Movies");

		Thread.sleep(1000);

		WebElement autoOptions = d.findElement(By.xpath(
				"//select[@id='state']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
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
				"//select[@id='city']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
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
		
		d.findElement(By.xpath(
				"//div[@class='inputField floating-label']/..//select[@id='ride_bicycle']/..//div[@class='selectize-control clickDrpDwn2 single']"
				+ "/..//div[@class='selectize-input items full has-options has-items']")).click();
		
			Thread.sleep(2000);
			
		d.findElement(By.xpath("//*[@id='franchise_form']/div/div/div[10]/div/div[2]/div/div[3]")).click();
		Thread.sleep(2000);

		
		d.findElement(By.xpath("//div[@class='selectize-input items full has-options has-items']")).click();

		Thread.sleep(2000);

		d.findElement(By.xpath("//*[@id='franchise_form']/div/div/div[11]/div/div[2]/div/div[2]")).click();

		Thread.sleep(2000);

		d.findElement(By.id("carpet_area")).sendKeys("1032");

		d.findElement(By.id("why_track_trail"))
				.sendKeys("Because Track & Trail is a good platform to advertisement my Business");

		// d.findElement(By.id("btn_franchise_enquiry")).click();

		// d = obj.quitwindow(d);

		// Actions a = new Actions(d);
		// a.moveToElement(d.findElement(By.xpath("//span[@class='top-heading
		// '][text()='Cycles']"))).perform();
		//
		// d.findElement(By.xpath("// a[text()='Mach City']")).click();
		//
		// d.findElement(By.id("loadMore")).click();
		//
		// d.findElement(By.xpath("//a[text()='Mach City iBike Single Speed
		// Medium Matt Black']")).click();
		//
		// d.findElement(By.id("check_pincode")).sendKeys("111111");
		//
		// d.findElement(By.id("btn_check_pincode")).click();
		//
		// d.findElement(By.xpath("//input[@class='form-submit']")).click();
		//
		// d.findElement(By.xpath("//a[text()='Go to checkout']")).click();
		//
		// d.findElement(By.xpath("//input[@value='Checkout']")).click();
		//
		// d.findElement(By.id("edit-name")).sendKeys("ratan.singh@experiencecommerce.com");
		//
		// d.findElement(By.xpath("//label[@for='edit-have-pass-1'][text()='Yes
		// ']")).click();
		//
		// d.findElement(By.id("edit-pass")).sendKeys("ratan123");
		//
		// d.findElement(By.id("edit-submit")).click();
		//
		// d.findElement(By.id("edit-continue")).click();
		//
		// //d.findElement(By.name("op")).click();
		//
		// d = obj.quitwindow(d);

	}

	private static void selectByIndex(int i) {
		// TODO Auto-generated method stub

	}

	private static void selectByVisibleText(String string) {
		// TODO Auto-generated method stub

	}
}