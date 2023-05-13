import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radio_checkbox_click {

	public static void main(String[] args) throws InterruptedException {
		
		String rdo_btn = "Option 3";
		
		WebDriver driver;
		
		ChromeOptions chops = new ChromeOptions();
		
		chops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(chops);

		String URL = "https://demo.guru99.com/test/radio.html";
		
		driver.get(URL);
		
		System.out.println(driver.getTitle());
		
//		WebElement radio_name = driver.findElement(By.xpath("//input[@type = 'radio'][3]"));
//		
//		String value_name = radio_name.getAttribute("value");
//		
//		System.out.println(value_name);
		
		List<WebElement> eles = driver.findElements(By.xpath("//input[@type = 'radio']"));
		
		for(WebElement btn : eles) {
			
			if (btn.getAttribute("value").equalsIgnoreCase(rdo_btn)) {
				
				btn.click();
			}
			
		}
		
		List<WebElement> chkb = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement chk : chkb) {
			
			if(!chk.isSelected()) {
				chk.click();
				
			}
		}
		
		Thread.sleep(10000);
		driver.close();
	}

}
