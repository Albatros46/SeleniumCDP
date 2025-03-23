package testig;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.fetch.Fetch;

//Intercept Network /API Responses with Selenium Chrome Dev Tools
public class NetworkMocking {

	public static void main(String[] args) throws Exception {
		// https://chromedevtools.github.io/devtools-protocol/tot/Fetch/
		// A domain for letting clients substitute browser's network layer with client
		// code.
		// https://chromedevtools.github.io/devtools-protocol/tot/Fetch/#method-enable
		// Enables issuing of requestPaused events. A request will be paused until
		// client calls one of failRequest, fulfillRequest or
		// continueRequest/continueWithAuth.
		System.setProperty("webdriver.chrome.driver",
				"E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		// Fetch.enable -> Array patterns, boolean handleAuthRequests
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println("Intercepted URL: " + mockedUrl);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(mockedUrl),Optional.of(request.getRequest().getMethod()),
						request.getRequest().getPostData(),Optional.empty(),Optional.empty()));
			}
			else {
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of( request.getRequest().getUrl()),Optional.of(request.getRequest().getMethod()),
						request.getRequest().getPostData(),Optional.empty(),Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click(); //  body > app-root > app-landingpage > div > button
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		Thread.sleep(2000);
		driver.close();
	}

}
