import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectClassformultipleselection {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		ChromeOptions chops = new ChromeOptions();
		
		chops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(chops);

		String URL = "https://output.jsbin.com/osebed/2";
		
		driver.get(URL);
		
		System.out.println(driver.getTitle());
		
		Select select = new Select(driver.findElement(By.id("fruits")));
		
		if(select.isMultiple()) {
			
			select.selectByIndex(2);
			select.selectByIndex(3);
			
		}
			
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
	}

}
