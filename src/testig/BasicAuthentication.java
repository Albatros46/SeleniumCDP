package testig;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) {
		// Working with Basic Authentication Using Selenium uriPredicate Function
		//
		// https://httpbin.org/basic-auth/foo/bar
		System.setProperty("webdriver.chrome.driver",
				"E:\\Projeler\\Testing\\SeleniumFeaturesLatest\\drivers\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		// Predicate, consumer, function, supplier, operator
		Predicate<URI> uriPredicate = uri->uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("https://httpbin.org/basic-auth/foo/bar");
		
	}

}
