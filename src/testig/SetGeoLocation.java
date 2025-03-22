package testig;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) throws Exception {
		// https://chromedevtools.github.io/devtools-protocol/tot/Emulation/ -->
		// Emulation.setGeolocationOverride
		// https://chromedevtools.github.io/devtools-protocol/tot/Emulation/#method-setGeolocationOverride
		/*
		 * int latitude, int longitude, int accuracy
		 */
		System.setProperty("webdriver.chrome.driver",
				"E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> coordinates = new HashMap<String,Object>(); // Stuttgart  koordinatları 
		coordinates.put("latitude", 48.7775); // Enlem / Latitude : 48°46'39"N
		coordinates.put("longitude", 9.1803); // Boylam/Longitude: 9°10'40"E
		coordinates.put("accuracy", 1); // Hassasiyet (1 metre)
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        //driver.get("https://www.google.com/maps");
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElement(By.cssSelector(".LC20lb")).click();
		String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();

		System.out.println(title);
		Thread.sleep(2000);
		driver.quit();
		}

}
