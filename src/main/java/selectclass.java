import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectclass {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver;
		
		ChromeOptions chops = new ChromeOptions();
		
		chops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(chops);

		String URL = "https://demo.guru99.com/test/newtours/register.php";
		
		driver.get(URL);
		
		System.out.println(driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.name("country"));

		Select select = new Select(dropdown);
		
		select.selectByVisibleText("ANTARCTICA");
		
		//System.out.println(select.isMultiple()+" - is multiple");
		
		List<String> dropdwnvalues = new ArrayList<String>();
		
		List<WebElement> dropdwnlist = select.getOptions();
		
		for(WebElement ddl : dropdwnlist) {
			 
			dropdwnvalues.add(ddl.getText());
			System.out.println(ddl.getText());
		}
		
		
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();

	}

}
