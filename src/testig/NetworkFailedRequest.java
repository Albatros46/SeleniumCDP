package testig;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.fetch.Fetch;
import org.openqa.selenium.devtools.v132.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v132.network.model.ErrorReason;

public class NetworkFailedRequest {

	public static void main(String[] args) throws Exception {
		// How to Test Failed Network Request Calls with Selenium CDP Commands
		System.setProperty("webdriver.chrome.driver",
				"E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//-----------------------------------------
		// java.util.Optional<java.lang.String> urlPattern
		Optional<List<RequestPattern>> patterns=Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty()))); // Test edilen sitedeki request edilen sayfa.
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request->
		{
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
			
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click(); //  body > app-root > app-landingpage > div > button
		//System.out.println(driver.findElement(By.cssSelector("p")).getText());
		Thread.sleep(2000);
		driver.close();
	}

}
