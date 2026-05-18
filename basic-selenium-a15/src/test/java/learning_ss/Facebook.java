package learning_ss;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Facebook {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://facebook.com/");

//		our driver ref var doesn't have that method which will take the ss
//		so we needed explicitly downcasting to convert our webdriver type to takesscreenshot type
//		and that's where we have assigned driver value to tks whose type is takesscreenshot
		TakesScreenshot tks = (TakesScreenshot) driver;
//		String ss = tks.getScreenshotAs(OutputType.BASE64);
//		byte[] ss = tks.getScreenshotAs(OutputType.BYTES);
		File source = tks.getScreenshotAs(OutputType.FILE);

//		create a ss folder => right click on folder => properties => copy the path
//		/basic-selenium-a15/ss
//		modify it to
//		./ss => . means project level
//		if this is not working then use location (given in properties)
//		C:\Users\User\git\basic-selenium-a15\basic-selenium-a15\ss
		
		File destination = new File("./ss/dingaLoginFb.png");
		
		FileHandler.copy(source,destination);
		
//		driver.getScreenshotAs();

		Thread.sleep(3000);
		driver.quit();
	}
}
