import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_radiobutton {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		ChromeOptions chops = new ChromeOptions();
		
		chops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(chops);

		String URL = "https://demo.guru99.com/test/radio.html";
		
		driver.get(URL);
		
		System.out.println(driver.getTitle());
		
		WebElement radiobtu = driver.findElement(By.xpath("//*[@id='vfb-7-1']"));
		//*[@id="vfb-7-1"]
		File src = radiobtu.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:/Selenium project/Selenium_Tutorial_2023/Selenium_Practice_2023/target/Screenshots/buttons.png");
		
		try {
            FileHandler.copy(src, dest);
         } catch (IOException exception) {
            exception.printStackTrace();
         }
		
		System.out.println(radiobtu.getText());
		
		radiobtu.click();
		
		System.out.println("clicl on button");
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
		
		

	}

}
