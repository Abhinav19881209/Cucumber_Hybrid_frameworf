package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import Driverfactory.Driverfac;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Myhooks {
	
	WebDriver driver;
	
	//driver = Driverfac.getDriver();
	
	@Before
	public void setup() {
		
		Properties prop = ConfigReader.initProperties();
		Driverfac.initisliseBrowser(prop.getProperty("browser"));	
		driver = Driverfac.getDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("URL"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioname = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) {
			
			byte[] scrnshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(scrnshot, "image/png", scenarioname);	
		}
		
		driver.quit();
	}
}
