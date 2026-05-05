package learning_sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitingCommands {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://automationwithpiyush.vercel.app/synchronization.html");
		
		WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'START')]"));
		startButton.click();
		
		WebElement stopButton = driver.findElement(By.xpath("//button[contains(text(),'STOP')]"));
		stopButton.click();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
