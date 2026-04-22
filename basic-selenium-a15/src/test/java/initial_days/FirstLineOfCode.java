package initial_days;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstLineOfCode {
	public static void main(String[] args) {
//		Homogeneous type of object creation
//		ChromeDriver cd = new ChromeDriver();
//		EdgeDriver ed = new EdgeDriver();
//		FirefoxDriver ffd = new FirefoxDriver();
		
//		type		r.v.  kw  
//		load, register, re-initialize the ns member
//		start the server
//		launch the empty chrome browser
		
//		(upcasting) Heterogeneous type of object creation
//		RemoteWebDriver driver1 = new ChromeDriver();
//		RemoteWebDriver driver2 = new EdgeDriver();
//		RemoteWebDriver driver3 = new FirefoxDriver();
		
//		
//		WebDriver driver1 = new ChromeDriver();
//		WebDriver driver2 = new EdgeDriver();
//		WebDriver driver3 = new FirefoxDriver();
		
//		runtime poly-morphism
		WebDriver driver = new ChromeDriver();		
					driver = new EdgeDriver();
						driver = new FirefoxDriver();	
						
	}
}
