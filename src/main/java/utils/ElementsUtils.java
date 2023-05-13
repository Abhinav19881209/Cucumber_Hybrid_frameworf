 	package utils;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils {
	
	WebDriver driver;
	
	public static final int EXPLICIT_TIME_OUT = 30;
	
	public ElementsUtils(WebDriver driver) {
		
		this.driver = driver;
		
	}

	
	public WebElement waitForEleToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIME_OUT));
		WebElement ele = null;
		try {
			ele = wait.until(ExpectedConditions.elementToBeClickable(element));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return ele;
	}
	
	public void clickOnElement(WebElement element) {
		
		WebElement ele = waitForEleToBeClickable(element);
		ele.click();
	}
	
	public void enterTheText(WebElement element,String text) {
		
		WebElement ele = waitForEleToBeClickable(element);
		ele.click();
		ele.clear();
		ele.sendKeys(text);
	}
	
	
	public Select selectOptions(WebElement element) {
		
		WebElement ele = waitForEleToBeClickable(element);
		
		Select select = new Select(ele);
		
		return select;
		
	}
	
	public void selectOptionByVisibleText(WebElement element, String dropdownoption) {
		
		selectOptions(element).selectByVisibleText(dropdownoption);
		
	}
	
	public void deSelectAllTheOptions(WebElement element) {
		
		selectOptions(element).deselectAll();;
	}
	
	public List<WebElement> getAllOptions(WebElement element) {
		
		List<WebElement> optionlist= selectOptions(element).getOptions();
		
		return optionlist;
	}
	
	public void selectByText(WebElement element, String text) {
			
			for(WebElement options : getAllOptions(element)) {
				
				if (text.equalsIgnoreCase(options.getText())) {
					
					options.click();
				}
			}
							
	}
	// methods for alerts
	
	
	public Alert waitForAlert(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIME_OUT));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		return alert;
	}
	
	public void acceptTheAlert(WebElement element) {
		
		waitForAlert(element).accept();
	}
	
	public void dismissTheAlert(WebElement element) {
		
		waitForAlert(element).dismiss();
	}
	
	//method for Actions class
	
	public WebElement visibilityOfElement(WebElement element) {
		
		WebElement ele = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIME_OUT));
		try {
			ele = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ele;
	}
	
	Actions action;
	
	public void mouseHoverandClick(WebElement element) {
		
			WebElement ele = visibilityOfElement(element);
			
			action = new Actions(driver);
			action.moveToElement(ele).click().build().perform();
	}
	
	public void doubleClick(WebElement element) {
		
		WebElement ele = visibilityOfElement(element);
		
		action = new Actions(driver);
		action.contextClick(ele);
	}
	
	//Java Script click
	
	 public void javaScriptClick(WebElement element) {
		 
		 WebElement ele = visibilityOfElement(element);
		 
		 JavascriptExecutor jse = ((JavascriptExecutor)driver);
		 
		 jse.executeScript("arguments[0].click", ele);
	 }
	
	 public void enterTextUsingJavaScript(WebElement element,String text) {
		 
		 WebElement ele = visibilityOfElement(element);
		 
		 JavascriptExecutor jse = ((JavascriptExecutor)driver);
		 
		 jse.executeScript("arguments[0].value='"+text+"'", ele);
		 
	 }
}



















