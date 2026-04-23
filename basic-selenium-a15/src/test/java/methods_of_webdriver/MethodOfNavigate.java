package methods_of_webdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodOfNavigate {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");

//		driver.get("https://www.instagram.com/");

		Thread.sleep(1000);

		driver.navigate().to("https://www.instagram.com/");

//		URL url = new URL("https://www.instagram.com/");

//		driver.navigate().to(url);

		Thread.sleep(500);

		driver.navigate().back();

		Thread.sleep(500);

		driver.navigate().forward();

		Thread.sleep(2000);

		driver.navigate().refresh();

		Thread.sleep(3000);
		driver.quit();
	}
}
