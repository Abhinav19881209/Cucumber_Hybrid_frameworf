import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class launchbrowser {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("initialized driver");
			WebDriver driver;
			ChromeOptions chops = new ChromeOptions();
			chops.addArguments("--remote-allow-origins=*");
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(chops);
			System.out.println("lauch browser");
			// Navigate to the demoqa website
			driver.get("https://www.google.com/");
			
			driver.close();
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("lauch edge browser");
			// Navigate to the demoqa website
			Thread.sleep(3000);
			driver.get("https://www.google.com/");
			
			driver.quit();
	}

}
