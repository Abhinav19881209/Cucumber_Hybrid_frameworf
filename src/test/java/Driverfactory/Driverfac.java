package Driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfac {
		
	static WebDriver driver = null;
	
	public static final int IMPLICIT_TIME_OUT = 10;
	public static final int PAGELOAD_TIME_OUT = 15;

	public static void initisliseBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			 driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			 driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_TIME_OUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIME_OUT));
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
}
