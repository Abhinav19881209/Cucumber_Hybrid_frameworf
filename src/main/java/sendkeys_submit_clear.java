import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sendkeys_submit_clear {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver;
		
		ChromeOptions chops = new ChromeOptions();
		
		chops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(chops);
		driver.manage().window().maximize();
		String URL = "https://www.facebook.com/";
		driver.get(URL);
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		driver.switchTo().window(URL);
		
		driver.findElement(By.xpath("//*[contains(text(),'First name')]")).sendKeys("Tiger");
		
		driver.findElement(By.xpath("//*[contains(text(),'Surname')]")).sendKeys("shroff");
		
		driver.findElement(By.xpath("//*[contains(text(),'Mobile number or email address')]")).sendKeys("Tiger@gmail.abc");
		
		driver.findElement(By.xpath("//*[contains(text(),'New password')]")).sendKeys("Tiger");
		
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'Sign Up')]")).click();
		
	
		Thread.sleep(50000); 
		
				
		driver.close();
		driver.quit();

	}

}
