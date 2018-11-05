import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BikeGuide extends Firstproject {
	public static WebDriver d;

	public static void main(String[] args) throws Exception {

		Firstproject obj = new Firstproject();
		d = obj.initialize();

		d.get("https://ticycles.experiencecommerce.com/");

		d.findElement(By.xpath("//span[text()='Cycle Guide']")).click();

		d.findElement(By
				.xpath("//img[@src='https://ticycles.experiencecommerce.com/sites/all/themes/adaptivetheme/at_subtheme/images/male.jpg']"))
				.click();

		d.findElement(By.xpath("//a[@data-age='16p']")).click();

		d.findElement(By
				.xpath("//img[@src='https://ticycles.experiencecommerce.com/sites/default/files/styles/listing_image/public/cityRoad.jpg?itok=NodJ9CSb']"))
				.click();

		d.findElement(By
				.xpath("//img[@src='https://ticycles.experiencecommerce.com/sites/default/files/styles/listing_image/public/Casual-Rider.jpg?itok=NHIo9nxp']"))
				.click();

		Thread.sleep(1000);

		d.findElement(By.xpath("//a[@class='globalBtn btn-grad'][text()='NEXT']")).click();

		d.findElement(By.name("name_bike")).sendKeys(" ");

		d.findElement(By.id("visitor_email")).sendKeys(" ");
		
		d.findElement(By.id("visitor_mobile_number")).sendKeys(" ");

		d.findElement(By.xpath("//label[@for='test1']")).click();

		Thread.sleep(2000);

		d.findElement(By.xpath("//a[@class='globalBtn btn-grad'][@id='btn_submit']")).click();
		
		Thread.sleep(2000);

		d.findElement(By.xpath("//a[text()='Mach City iBike Hardtail Large Matt Black']")).click();

		d.findElement(By.id("check_pincode")).sendKeys("111111");

		d.findElement(By.id("btn_check_pincode")).click();

		d.findElement(By.xpath("//input[@class='form-submit']")).click();

		d.findElement(By.xpath("//a[text()='Go to checkout']")).click();

		d.findElement(By.xpath("//input[@value='Checkout']")).click();

		d.findElement(By.id("edit-name")).sendKeys("ratan.singh@experiencecommerce.com");

		d.findElement(By.xpath("//label[@for='edit-have-pass-1'][text()='Yes ']")).click();

		d.findElement(By.id("edit-pass")).sendKeys("ratan123");

		d.findElement(By.id("edit-submit")).click();

		d.findElement(By.id("edit-continue")).click();

		// d.findElement(By.name("op")).click();

		d = obj.quitwindow(d);

	}
}