package methods_of_webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Webdriver {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.instagram.com/");

		String title = driver.getTitle();
		System.out.println(title);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		Thread.sleep(3000);

//		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);

//		driver.manage();
//		driver.manage().window().maximize();
//		
//		driver.manage().window().minimize();
//		
//		driver.manage().window().fullscreen();

		Dimension dim = driver.manage().window().getSize();
		System.out.println(dim); // => (width , height)

		int w = driver.manage().window().getSize().getWidth();
		int h = dim.getHeight();
		
		System.out.println(w + " and " + h);
		
		Point pt = driver.manage().window().getPosition();
		System.out.println(pt); // => (x , y)

		int x = driver.manage().window().getPosition().getX();
		int y = pt.getY();
		
		System.out.println(x + " and " + y);
		
//		driver.navigate();

//		Window Handling
//		driver.getWindowHandle();
//		driver.getWindowHandles();
//		driver.switchTo();
		
//		driver.close(); // it will close current window
		// it will not stop the server

		driver.quit(); // it will close all the wins
		// it will stop the server
	}
}
