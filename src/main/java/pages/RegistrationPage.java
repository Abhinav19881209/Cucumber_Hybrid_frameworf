package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class RegistrationPage {
		
	WebDriver driver;
	ElementsUtils eleUtil;	

 	public RegistrationPage(WebDriver driver) {
 		
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
 		
 		eleUtil = new ElementsUtils(driver);
 	}
 	
 	@FindBy(id="input-firstname")
 	private WebElement firstname;
 	
 	@FindBy(id="input-lastname")
 	private WebElement lastname;
 	
 	@FindBy(id="input-email")
 	private WebElement email;
 	
 	@FindBy(id="input-telephone")
 	private WebElement telephone;
 	
 	@FindBy(id="input-password")
 	private WebElement password;
 	
 	@FindBy(id="input-confirm")
 	private WebElement confirm;
 	
 	@FindBy(xpath="//input[@name='agree']")
 	private WebElement pripolicy;
 	
 	@FindBy(xpath="//input[@value='Continue']")
 	private WebElement continuebtn;
 	
 	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
 	private WebElement acctsuccessmsg;
 	
 	@FindBy(xpath="//div[@class='col-sm-10']/label[1]/input")
 	private WebElement newsletteryes;
 	
 	@FindBy (xpath="//*[text()='Warning: E-Mail Address is already registered!']")
 	private WebElement dupwarningmsg;
 	
 	@FindBy (xpath="//div[text()='First Name must be between 1 and 32 characters!']")
 	private WebElement mandatefirstnamemsg;
 	
	@FindBy (xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
 	private WebElement mandatelastnamemsg;
	
	@FindBy (xpath="//div[text()='E-Mail Address does not appear to be valid!']")
 	private WebElement mandateemailmsg;
	
	@FindBy (xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
 	private WebElement mandatetelephonemsg;
 	
	@FindBy (xpath="//div[text()='Password must be between 4 and 20 characters!']")
 	private WebElement mandatePasswordmsg;
 	
	
 	//////////////////////////////////////////////methods
 	public void enterFirstName(String text) {

 		eleUtil.enterTheText(firstname, text);
 	}
 	
 	public void enterEmail(String text) {
	
 		eleUtil.enterTheText(email, text);
 	}
 	public void enterLastName(String text) {

 		eleUtil.enterTheText(lastname, text);
 	}
 	
 	public void enterTelephone(String text) {

 		eleUtil.enterTheText(telephone, text);
 	}
 	
 	public void enterPassword(String text) {

 		eleUtil.enterTheText(password, text);
 	}
 	
 	public void enterConfirmText(String text) {

 		eleUtil.enterTheText(confirm, text);
 	}
 	
 	public void clickPrivacyPolicy() {
 
 		eleUtil.clickOnElement(pripolicy);
 	}
 	
	public void clickOnContinue() {

		eleUtil.clickOnElement(continuebtn);
 	}
	
	public String acctSuccessMessage() {
		
		return acctsuccessmsg.getText();
	}
	
	public void clickOnYesNewletter() {

		 eleUtil.clickOnElement(newsletteryes);
	}
	
	public String dupwarningMessageforEmail() {
		
		return dupwarningmsg.getText();
	}
	
	public String mandateMsgForFirstName() {
		
		String fn = mandatefirstnamemsg.getText();
		System.out.println("msg from firstname is "+fn);
		
		return fn;
	}
	
public String mandateMsgForLastName() {
		
	String ln = mandatelastnamemsg.getText();
	System.out.println("msg from lastname is "+ln);
		return ln;
	}

public String mandateMsgForEmail() {
	
	return mandateemailmsg.getText();
}

public String mandateMsgForTelephone() {
	
	return mandatetelephonemsg.getText();
}

public String mandateMsgForPassword() {
	
	return mandatePasswordmsg.getText();
}
 	
}
