package learning_sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingCommands {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://automationwithpiyush.vercel.app/synchronization.html");

//		WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'START')]"));
//		startButton.click();
//		
//		WebElement stopButton = driver.findElement(By.xpath("//button[contains(text(),'STOP')]"));
//		stopButton.click();

		WebElement unlock = driver.findElement(By.id("trigger-display"));
		unlock.click();

		WebElement textField = driver.findElement(By.id("target-display"));

//		wait until it is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(textField));

		textField.clear(); // InvalidElementStateException: invalid element state: Element is not currently
							// interactable and may not be manipulated

		textField.sendKeys("Value entered...."); // ElementNotInteractableException: element not interactable

		Thread.sleep(3000);
		driver.quit();
	}
}
