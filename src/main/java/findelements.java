import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findelements {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver;
		
		ChromeOptions chops = new ChromeOptions();
		
		chops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(chops);
		driver.manage().window().maximize();
				
		//driver.get("https://www.google.com/");
		
		String URL = "http://demo.guru99.com/test/ajax.html";
		
		driver.get(URL);
		
		WebElement ele = driver.findElement(By.id("no"));
		ele.click();
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();

	}

}
