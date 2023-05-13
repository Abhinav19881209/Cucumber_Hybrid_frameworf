package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
		
	WebDriver driver;
	
	public SearchPage(WebDriver driver){
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "HP LP3065")
 	private WebElement hpproduct;
	
	@FindBy (xpath = "//p[text()='There is no product that matches the search criteria.']")
 	private WebElement noprodmatching;
	
	public String getProductName() {
 		
 		return hpproduct.getText();
 	}
	
	public String getNoProductMatchingmsg() {
 		
 		return noprodmatching.getText();
 	}
	
}
