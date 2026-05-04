package learning_element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AWP_signup {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://automationwithpiyush.vercel.app/signup.html");
//		actions
		
//		sendkeys
		WebElement fn = driver.findElement(By.name("firstname"));
		fn.sendKeys("dinga");
		
//		clear
		Thread.sleep(500);
		fn.clear();
		
		Thread.sleep(500);
		fn.sendKeys("dingi");
		
		WebElement femaleRadio = driver.findElement(By.xpath("//label[contains(text(),'Female')]/input"));
		
//		isDisplayed && isEnabled
		if (femaleRadio.isDisplayed() && femaleRadio.isEnabled()) {
			femaleRadio.click();
			if (femaleRadio.isSelected()) {
				System.out.println("female radio button selected successfullyy");
			}
		}
		
		String typeOfRadioButton = femaleRadio.getAttribute("type");
		System.out.println(typeOfRadioButton);
		
		String acClr = femaleRadio.getCssValue("accent-color");
		System.out.println(acClr);
		
		
		WebElement signUp = driver.findElement(By.cssSelector("button[type='submit']"));
		
		signUp.submit();
		
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}
