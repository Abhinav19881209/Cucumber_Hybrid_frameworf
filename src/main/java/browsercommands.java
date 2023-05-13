import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browsercommands {

	public static void main(String[] args) {

		WebDriver driver;
		
		ChromeOptions chops = new ChromeOptions();
		
		chops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(chops);
				
		//driver.get("https://www.google.com/");
		
		String URL = "https://demoqa.com/browser-windows/";
		
		driver.get(URL);
		
		String title = driver.getTitle();
		
		String currentURL = driver.getCurrentUrl();
		
	//	String pagesource = driver.getPageSource();
		
		System.out.println(title);
		System.out.println(currentURL);
	//	System.out.println(pagesource);
		
		driver.close();
		driver.quit();

	}

}
