package testig;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// https://chromedevtools.github.io/devtools-protocol/tot/Emulation/
		Integer width;  // Cihazın ekran genişliği | Gerätebildschirmbreite
		Integer height;  // Cihazın ekran yüksekliği | Gerätebildschirmhöhe
		Number deviceScaleFactor;  // Cihazın ekran ölçekleme faktörü | Skalierungsfaktor des Geräts
		Boolean mobile = false;  // Mobil cihaz olup olmadığını belirler | Ob es sich um ein mobiles Gerät handelt
		Optional<Number> scale = Optional.empty();  // Ekran ölçeğini belirler (isteğe bağlı) | Skalierung des Bildschirms (optional)
		Optional<Integer> screenWidth = Optional.of(1200);  // Cihazın fiziksel ekran genişliği (isteğe bağlı) | Physische Bildschirmbreite des Geräts (optional)
		Optional<Integer> screenHeight = Optional.of(800);  // Cihazın fiziksel ekran yüksekliği (isteğe bağlı) | Physische Bildschirmhöhe des Geräts (optional)
		Optional<Integer> positionX = Optional.empty();  // Görüntünün X konumu (isteğe bağlı) | X-Position des Bildes (optional)
		Optional<Integer> positionY = Optional.empty();  // Görüntünün Y konumu (isteğe bağlı) | Y-Position des Bildes (optional)
		Optional<Boolean> dontSetVisibleSize = Optional.empty();  // Görüntü boyutunun ayarlanıp ayarlanmayacağını belirler (isteğe bağlı) | Legt fest, ob die sichtbare Größe eingestellt wird (optional)
		Optional<org.openqa.selenium.devtools.v131.emulation.model.ScreenOrientation> screenOrientation = Optional.empty();  // Ekran yönünü belirler (isteğe bağlı) | Bildschirmorientierung festlegen (optional)
		Optional<org.openqa.selenium.devtools.v131.page.model.Viewport> viewport = Optional.empty();  // Görüntüleme alanını tanımlar (isteğe bağlı) | Definiert den Anzeigebereich (optional)
		Optional<org.openqa.selenium.devtools.v131.emulation.model.DisplayFeature> displayFeature = Optional.empty();  // Ekrandaki özel donanım özelliklerini tanımlar (isteğe bağlı) | Definiert spezielle Hardware-Funktionen des Bildschirms (optional)
		Optional<org.openqa.selenium.devtools.v131.emulation.model.DevicePosture> devicePosture = Optional.empty();  // Cihazın duruşunu/sunum şeklini belirler (isteğe bağlı) | Legt die Geräthaltung oder Präsentationsform fest (optional)
	
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//Send command to CDP Method-> CDP Method will invoke and get access to chrome dev tools
		//devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, deviceScaleFactor, mobile, scale, screenWidth, screenHeight, positionX, positionY, dontSetVisibleSize, screenOrientation, viewport, displayFeature, devicePosture));
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(2000);
		
		//Network.getRequestPostData()
	
	}

}
