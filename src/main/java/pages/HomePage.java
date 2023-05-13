package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class HomePage {
		
		WebDriver driver;
		
		private ElementsUtils eleUtils;
		
	 	public HomePage(WebDriver driver) {
	 		
	 		this.driver = driver;

			PageFactory.initElements(driver, this);
			
			eleUtils = new ElementsUtils(driver);

	 	}
	
	 	//locators
	 	@FindBy(xpath="//span[text()='My Account']")
	 	private WebElement myAccoutDropmenu;
	 	
	 	@FindBy (linkText ="Login")
	 	private WebElement loginOption;
	 	
	 	@FindBy (xpath = "//*[text()='Warning: No match for E-Mail Address and/or Password.']")
	 	private WebElement lpwarningmessage;
	 	
	 	@FindBy (linkText ="Register")
	 	private WebElement registerOption;
	 	
	 	@FindBy (xpath ="//input[@name='search']")
	 	private WebElement searchbox;
	 	
	 	@FindBy (xpath ="//button[@class='btn btn-default btn-lg']")
	 	private WebElement searchbtn;
	 	
	 	
	 	
	 	//page methods
	 	public void clickOnMyAccount() {
	 		
	 		eleUtils.clickOnElement(myAccoutDropmenu);
	 		
	 		//myAccoutDropmenu.click();
	 		
	 	}
	 	
	 	public void clickOnlogin() {
	 		
	 		eleUtils.clickOnElement(loginOption);
	 	//	loginOption.click();
	 			 		
	 	}
	 	
	 	public void clickOnregister() {
	 		
	 		eleUtils.clickOnElement(registerOption);
	 	//	registerOption.click();
	 	}
	 	
	 	public String getWarningMsg() {
			return lpwarningmessage.getText() ;
	 			
	 	}
	 	
	 	public void enterProductInSearchBox(String prod) {
	 		
	 		eleUtils.enterTheText(searchbox, prod);
	 	//	searchbox.sendKeys(prod);
	 	}
	 	
	 	public void clickOnSearchBtn() {

	 		eleUtils.clickOnElement(searchbtn);
	 	//	searchbtn.click();
	 	}
	 	
	 
}
