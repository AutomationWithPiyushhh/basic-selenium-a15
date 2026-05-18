package learning_dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class AWP_dd {

	public static void main(String[] args) {

		// Initialize WebDriver (Selenium 4 handles driver binaries automatically)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Use an implicit wait as a fallback
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Define Explicit Wait for dynamic elements
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// TODO: Change this to the actual file path where you saved the HTML file
			String filePath = "https://automationwithpiyush.vercel.app/dropdown.html";
			driver.get(filePath);

			System.out.println("--- STARTING VIEW 1: STANDARD SELECTS ---");

			// ---------------------------------------------------------
			// 1. STANDARD SINGLE SELECT (Using Select Class)
			// ---------------------------------------------------------
			WebElement singleSelectElement = driver.findElement(By.id("single-select"));
			Select singleSelect = new Select(singleSelectElement);

			singleSelect.selectByIndex(1); // Selects United States
			Thread.sleep(1000); // Only for visual observation
			singleSelect.selectByValue("uk"); // Selects United Kingdom
			Thread.sleep(1000);
			singleSelect.selectByVisibleText("Canada"); // Selects Canada
			System.out.println("Single Select Selected: " + singleSelect.getFirstSelectedOption().getText());

			// ---------------------------------------------------------
			// 2. STANDARD MULTI-SELECT (Using Select Class)
			// ---------------------------------------------------------
			WebElement multiSelectElement = driver.findElement(By.id("multi-select"));
			Select multiSelect = new Select(multiSelectElement);

			if (multiSelect.isMultiple()) {
				multiSelect.selectByVisibleText("Selenium WebDriver");
				multiSelect.selectByValue("java");
				multiSelect.selectByIndex(3); // TestNG

				System.out.println("Total Multi-Select options chosen: " + multiSelect.getAllSelectedOptions().size());

				Thread.sleep(1000);
				multiSelect.deselectByValue("java"); // Deselect one
			}

			// ---------------------------------------------------------
			// 3. AUTO-SUGGESTION (Dynamic Dropdown)
			// ---------------------------------------------------------
			WebElement searchBox = driver.findElement(By.id("auto-search"));
			searchBox.sendKeys("sel");

			// Explicitly wait for the suggestion list to appear (Because of our 300ms
			// simulated delay)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='suggestion-box']/li")));

			// Get all suggestions
			List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@id='suggestion-box']/li"));
			for (WebElement suggestion : suggestions) {
				if (suggestion.getText().equalsIgnoreCase("selenium grid")) {
					suggestion.click();
					break; // Exit loop once found
				}
			}
			System.out.println("Auto-suggest value selected.");

			// ---------------------------------------------------------
			// SWITCH TO VIEW 2 (Custom DIVs & Robot)
			// ---------------------------------------------------------
			System.out.println("\n--- SWITCHING TO VIEW 2: CUSTOM DIVS & ROBOT ---");
			driver.findElement(By.id("btn-advanced")).click();
			Thread.sleep(1000); // Brief pause for UI animation

			// ---------------------------------------------------------
			// 4. CUSTOM DIV - findElement() Direct Approach
			// ---------------------------------------------------------
			driver.findElement(By.id("job-header")).click(); // Open dropdown

			// Directly locate the exact 'li' tag using XPath and click it
			WebElement qaOption = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//ul[@id='job-list']/li[text()='Automation Engineer']")));
			qaOption.click();
			System.out.println("Custom Div (findElement) successful.");

			// ---------------------------------------------------------
			// 5. CUSTOM DIV - findElements() Loop Approach
			// ---------------------------------------------------------
			driver.findElement(By.id("tool-input")).click(); // Open dropdown

			// Grab all options and iterate to find "Playwright"
			List<WebElement> toolOptions = driver.findElements(By.xpath("//ul[@id='tool-list']/li"));
			for (WebElement option : toolOptions) {
				if (option.getText().equals("Playwright")) {
					option.click();
					break;
				}
			}
			System.out.println("Custom Div (findElements iteration) successful.");

			// ---------------------------------------------------------
			// 6. JAVA ROBOT CLASS - Keyboard Navigation
			// ---------------------------------------------------------
			WebElement osInput = driver.findElement(By.id("os-input"));
			osInput.click(); // Focus the input to trigger the dropdown

			// Initialize Robot class
			Robot robot = new Robot();
			robot.setAutoDelay(500); // Slow down robot keystrokes so you can see it happen

			// Press Arrow Down 3 times (Should land on "Ubuntu Linux")
			for (int i = 0; i < 3; i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
			}

			// Press Enter to select
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Robot Class keyboard selection successful.");

			// Final pause to review the page
			Thread.sleep(3000);

		} catch (Exception e) {
			System.err.println("An error occurred during test execution:");
			e.printStackTrace();
		} finally {
			// Clean up and close browser
			driver.quit();
			System.out.println("Browser closed. Test Complete.");
		}
	}
}