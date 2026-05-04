package learning_loc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DirectLocator {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://automationwithpiyush.vercel.app/locators.html");
		
////		id
//		WebElement username = driver.findElement(By.id("user_login_field"));
//		username.sendKeys("admin");
//		
////		name
//		WebElement password = driver.findElement(By.name("security_passphrase"));
//		password.sendKeys("1234567890");
//		
//		driver.navigate().to("https://www.facebook.com/");
//		
//		Thread.sleep(2000);
//		
//		WebElement metaPay = driver.findElement(By.partialLinkText("Quest"));
//		metaPay.click();
		
		driver.navigate().to("https://piyushit.com/");
		
//		scrolling
		new Actions(driver).scrollByAmount(0, 1000).build().perform();
		
		Thread.sleep(3000);
//		driver.findElement(By.className("btn-dark")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("input"));
		int totalLinks = links.size();
		System.out.println(totalLinks);
		
		Thread.sleep(3000);
		driver.quit();
	}
}
