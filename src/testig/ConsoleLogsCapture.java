package testig;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) throws Exception {
		// How to Log JavaScript Errors from Selenium Script to Console for Debugging
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		// listeners - OnTestFailure
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-product-shop/body/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		Thread.sleep(2000);
		LogEntries entry= driver.manage().logs().get(LogType.BROWSER);// Get LogEntires object
		List<LogEntry> logs=entry.getAll();// LogEntryObject - getAll method return all logs in List
		for (LogEntry e : logs) // iterating through list and printing each log message
		{
			System.out.println(e.getMessage());// Log4j
		}
		driver.close();

	}

}
