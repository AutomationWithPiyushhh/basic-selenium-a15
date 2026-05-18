package learning_actions_class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://jqueryui.com/slider/");

		driver.switchTo().frame(0);

		Actions act = new Actions(driver);

		WebElement slider = driver.findElement(By.id("slider"));

//		moveByOffset(x,y)
//		act.moveToElement(slider).moveByOffset(100, 0).click().build().perform();
		act.moveToElement(slider, 100, 0).click().build().perform();

		Thread.sleep(1000);

		act.moveByOffset(-100, 0).click().build().perform();

		Thread.sleep(1000);

		act.moveByOffset(-100, 0).click().build().perform();

		Thread.sleep(3000);
		driver.quit();
	}
}
