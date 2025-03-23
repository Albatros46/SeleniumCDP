package testig;

import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v132.network.Network;
import org.openqa.selenium.devtools.v132.network.model.ConnectionType;

public class NetworkSpeed {
    public static void main(String[] args) throws InterruptedException {
        // How to Emulate Network Speed with Selenium ChromeDevTools Integration
    	// https://chromedevtools.github.io/devtools-protocol/tot/Network/#method-emulateNetworkConditions
        System.setProperty("webdriver.chrome.driver", "E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
        
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        
        // Ağı taklit et
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
            false, 
            3000,  // Latency (ms)
            20000, // Download throughput (bps)
            100000, // Upload throughput (bps)
            Optional.of(ConnectionType.CELLULAR4G),
            Optional.empty(),  // packetLoss yerine null değil Optional.empty()
            Optional.empty(),
            Optional.empty()
        ));
        
        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        
        Thread.sleep(2000);
        driver.close();
        
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken: " + (endTime - startTime));
    }
}
