package testig;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTest {
	public static void main(String[] args) throws Exception {
		//https://chromedevtools.github.io/devtools-protocol/tot/Emulation/#method-setDeviceMetricsOverride
		System.setProperty("webdriver.chrome.driver", "E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map deviceMetrics = new HashMap();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 800);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);
		
		//driver.executeCdpCommand(commandName, parameters);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(2000);
		
	}

}
