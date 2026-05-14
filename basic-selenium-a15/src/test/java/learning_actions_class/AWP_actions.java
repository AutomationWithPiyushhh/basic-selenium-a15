package learning_actions_class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AWP_actions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://automationwithpiyush.vercel.app/actions.html");

//		Select sel = new Select(element);
		Actions act = new Actions(driver);

//		Thread.sleep(3000);

//		I> hover 
		WebElement hoverEle = driver.findElement(By.xpath("//button[contains(text(),'Hover')]"));
		act.moveToElement(hoverEle).build().perform();

//		II> left click
		WebElement leftClick = driver.findElement(By.id("click-text"));
//		act.moveToElement(leftClick).click().build().perform();
		act.click(leftClick).build().perform();

//		V> click and hold	
		WebElement holdIcon = driver.findElement(By.id("hold-icon"));
//		act.moveToElement(holdIcon).clickAndHold().pause(Duration.ofSeconds(3)).release().build().perform();
		act.clickAndHold(holdIcon).pause(Duration.ofSeconds(3)).release().build().perform();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
