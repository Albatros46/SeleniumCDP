package testig;

import java.util.LinkedList;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

	public static void main(String[] args) throws InterruptedException {
		// https://chromedevtools.github.io/devtools-protocol/tot/Network/#method-setBlockedURLs
		// Blocking Unwanted Network Request Calls to Speed Up the Execution with Selenium
		// css, images 
		System.setProperty("webdriver.chrome.driver",
				"E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//-------------------------------
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		long startTime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click(); ///html/body/app-root/app-landingpage/div/p[2]/a
		driver.findElement(By.linkText("Selenium")).click();// /html/body/app-root/app-product-details/div/div[2]/div/ul/div[1]/li/div/div/a
		driver.findElement(By.cssSelector(".add-to-cart")).click(); // body > div.card > div > div > div.details.col-md-6 > div.action > button.add-to-cart.btn.btn-default.disabled
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		long endTime=System.currentTimeMillis();
		System.out.println("Total Time Taken: "+(endTime-startTime)); //Total Time Taken: 4557, 1777, 1648
		Thread.sleep(2000);
		driver.close();
		
	}

}
