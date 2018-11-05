import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;

public class TiEAR extends Firstproject {
	public static WebDriver d;

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		TiEAR obj = new TiEAR();
		d = obj.initialize();
		
		d.navigate().to("https://ticycles.experiencecommerce.com/cycles/montra/montra-madrock-29?id=2508");

		d.findElement(By.id("btn_experience_visit")).click();

		d.findElement(By.name("name")).sendKeys("Andrew D'mello");

		d.findElement(By.name("email")).sendKeys("ratantest1995@gmail.com");

		d.findElement(By.name("mobile")).sendKeys("8898952624");
		
		Thread.sleep(2000);

		WebElement autoOptions = d.findElement(By.xpath(
				"//select[@id='visit_state']/..//div[@class='selectize-control clickDrpDwn2 clear_field single']/..//input[@type='text']"));
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
				"//select[@id='visit_city']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
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
				"//select[@id='visit_pincode']/..//div[@class='selectize-control clickDrpDwn2 single']/..//input[@type='text']"));
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
		

	//	d.findElement(By.id("btn_visit_submit")).click();

		//d.findElement(By.id("btn_ok")).click();

		d.quit();
	}

}
