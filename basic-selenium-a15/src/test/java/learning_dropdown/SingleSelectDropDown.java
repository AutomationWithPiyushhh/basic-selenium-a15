package learning_dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSelectDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		driver.get("https://automationwithpiyush.vercel.app/signup.html");
		
////		find element for the select tag (suffix => DD)
//		WebElement dayDD = driver.findElement(By.id("day"));
////		create an object of select class and pass the webelement
//		Select selDay = new Select(dayDD);
////		perform the task
//		selDay.selectByIndex(0);
//
//		WebElement monthDD = driver.findElement(By.id("month"));
//		Select selMon = new Select(monthDD);
//		selMon.selectByIndex(1);
//		
//
//		WebElement yearDD = driver.findElement(By.id("year"));
//		Select selYear = new Select(yearDD);
//		selYear.selectByVisibleText("1995");
		
	
		driver.get("https://automationwithpiyush.vercel.app/dropdown.html");
		
//	//	find element for the select tag (with suffix => DD)
//		WebElement singleSelectDD = driver.findElement(By.id("single-select"));
//		
//	//	create an object of select class and pass the webelement
//		Select selSSDD = new Select(singleSelectDD);
//			
//	//	perform the task
//		selSSDD.selectByIndex(3);
//		Thread.sleep(1000);
//		selSSDD.selectByValue("DXB");
//		Thread.sleep(1000);
//		selSSDD.selectByVisibleText("Paris, France");
//
//		Thread.sleep(1000);
//
////		selSSDD.deselectByIndex(3); // UnsupportedOperationException: You may only deselect options of a multi-select
//
////		isMultiple() => to check whether the given dd is multi select or not
//		if (selSSDD.isMultiple()) {
//			selSSDD.deselectByIndex(3);
//		}
//		
//		List<WebElement> opts = selSSDD.getOptions();
//		
//		for (WebElement i : opts) {
//			String text = i.getText();
//			System.out.println(text);
//		}

	//	find element for the select tag (with suffix => DD)
		WebElement msDD = driver.findElement(By.id("multi-select"));
	
	//	create an object of select class and pass the webelement
		Select selMs = new Select(msDD);
			
	//	perform the task
		selMs.selectByIndex(0);
		selMs.selectByIndex(1);
		selMs.selectByIndex(3);

		Thread.sleep(1000);
//		selMs.deselectAll();.
		
		WebElement firstSelected = selMs.getFirstSelectedOption();
		System.out.println(firstSelected.getText());
		
//		List<WebElement> selectedAll = selMs.getAllSelectedOptions();		
//		for (WebElement i : selectedAll) {
//			System.out.println(i.getText());
//		}
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
}
