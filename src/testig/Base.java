package testig;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Base {
	public void Property(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
	}

	public void getTest() throws Throwable {
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
