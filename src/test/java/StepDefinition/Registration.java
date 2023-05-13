package StepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Driverfactory.Driverfac;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegistrationPage;


public class Registration {
	
//	WebDriver driver;
	WebDriver driver = Driverfac.getDriver();
		HomePage hp = new HomePage(driver);
		RegistrationPage rp = new RegistrationPage(driver);
	
	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
	    
		hp.clickOnMyAccount();
		hp.clickOnregister();
		
	}

	@When("user enters the belwo details")
	public void user_enters_the_belwo_details(DataTable dataTable) {
	   
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		rp.enterFirstName(dataMap.get("firstname"));
		rp.enterLastName(dataMap.get("lastname"));
		rp.enterEmail(dataMap.get("email"));
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterConfirmText(dataMap.get("confirm"));
			
	}
	
	@When("user select privacy Policy")
	public void user_select_privacy_policy() {
	    
		rp.clickPrivacyPolicy();
	}

	@When("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
	    
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("user account should get created successfull")
	public void user_account_should_get_created_successfull() {
	 Assert.assertTrue(rp.acctSuccessMessage().contains("Your Account Has Been Created!"));   
	 
	}

	@When("User select Yes for newsletter")
	public void user_select_yes_for_newsletter() {
	   
		rp.clickOnYesNewletter();
	}

	@Then("user account should get warning message for duplicate email")
	public void user_account_should_get_warning_message_for_duplicate_email() {
		
		boolean warninmsg = rp.dupwarningMessageforEmail().contains("Warning: E-Mail Address is already registered!");
	   
		Assert.assertTrue(warninmsg);
		//Assert.assertEquals(driver, driver);
	}

	@Then("user account should get warning message for every mandatory field")
	public void user_account_should_get_warning_message_for_every_mandatory_field() {
	    
		Assert.assertTrue(rp.mandateMsgForFirstName().contains("First Name must be between 1 and 32 characters!"));
		
		Assert.assertTrue(rp.mandateMsgForLastName().contains("Last Name must be between 1 and 32 characters!"));
		
		Assert.assertTrue(rp.mandateMsgForEmail().contains("E-Mail Address does not appear to be valid!"));
		
		Assert.assertTrue(rp.mandateMsgForTelephone().contains("Telephone must be between 3 and 32 characters!"));
		
		Assert.assertTrue(rp.mandateMsgForPassword().contains("Password must be between 4 and 20 characters!"));
	}

}
