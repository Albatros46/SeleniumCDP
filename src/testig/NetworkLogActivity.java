package testig;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Handler;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;
import org.openqa.selenium.devtools.v132.network.model.Request;
import org.openqa.selenium.devtools.v132.network.model.Response;

public class NetworkLogActivity {
	public static void main(String[] args) throws Exception {
		// https://chromedevtools.github.io/devtools-protocol/tot/Network/
		// https://chromedevtools.github.io/devtools-protocol/tot/Network/#method-enable
		System.setProperty("webdriver.chrome.driver", "E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		//Log file -> 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		// Network.WillBeSent will get fired -> https://chromedevtools.github.io/devtools-protocol/tot/Network/#event-requestWillBeSent
		devTools.addListener(Network.requestWillBeSent(),request->
		{
			Request req=request.getRequest();
			System.out.println("URL: "+req.getUrl());
		});
		
		
		// #method-enable 3 parameters -> int:maxTotalBufferSize, int:maxResourceBufferSize, int:maxPostDataSize
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//Events will get fired -> https://chromedevtools.github.io/devtools-protocol/tot/Network/#event-responseReceived
		devTools.addListener(Network.responseReceived(),response->
		{
			Response res=response.getResponse();
			System.out.println("URL: "+res.getUrl());
			System.out.println("Status: "+res.getStatus());
			//response.getResponse().getStatus();
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println("Error: "+res.getStatus());
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click(); //  body > app-root > app-landingpage > div > button
		Thread.sleep(2000);
		driver.close();
	}
}
