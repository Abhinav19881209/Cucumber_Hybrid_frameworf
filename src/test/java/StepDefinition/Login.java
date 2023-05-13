package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import Driverfactory.Driverfac;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	
//	WebDriver driver;	
	
	WebDriver driver = Driverfac.getDriver();
	
	LoginPage lp = new LoginPage(driver);
	
	AccountPage ap = new AccountPage(driver);
	
	HomePage hp = new HomePage(driver);

	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		hp.clickOnMyAccount();
		
		hp.clickOnlogin();
		
	}

	@When("^User has enters email address (.+)$")
	public void user_has_enters_email_address(String email) {
		
		lp.enterEmailID(email);
	}

	@And("^User has enters password (.+)$")
	public void user_has_enters_password(String Password) {

		 lp.enterPassword(Password);	
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	    
		lp.clicklogin();
	}

	@Then("User should get succesfully logged in")
	public void user_should_get_succesfully_logged_in() {
		Assert.assertTrue(ap.getAccounttext().contains("Edit your account information"));
	}

	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() {
		
		Assert.assertTrue(hp.getWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	
}
