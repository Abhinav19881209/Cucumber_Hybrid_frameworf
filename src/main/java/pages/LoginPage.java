package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class LoginPage {
	
	WebDriver driver;
	
	private	ElementsUtils eleUtil;
	
 	public LoginPage(WebDriver driver) {
 		
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
 		
 		eleUtil = new ElementsUtils(driver);
 	}
 	
 	@FindBy(name="email")
 	private WebElement emailadd;
 	
 	@FindBy(id ="input-password")
 	private WebElement password;
 	
	@FindBy(xpath ="//input[@value='Login']")
 	private WebElement loginbutton;
 	
 	public void enterEmailID(String email) {

 		eleUtil.enterTheText(emailadd, email);
 	//	emailadd.sendKeys(email);
 	}
 	
 	public void enterPassword(String pass) {
 		
 		eleUtil.enterTheText(password, pass);
 	//	password.sendKeys(pass);
 	}
 	
 	public void clicklogin() {

 		eleUtil.clickOnElement(loginbutton);
 	//	loginbutton.click();

 	}

}
