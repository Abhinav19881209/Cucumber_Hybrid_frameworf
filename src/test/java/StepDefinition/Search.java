package StepDefinition;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import Driverfactory.Driverfac;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class Search {
			
//	WebDriver driver;
	
	WebDriver driver = Driverfac.getDriver();
	HomePage hp = new HomePage(driver);
	SearchPage sp = new SearchPage(driver);
	
	@Given("User opens the application")
	public void user_opens_the_application() {
	 
		System.out.println("user is on homepage");
	
	}

	@When("user enters product {string} in serach box")
	public void user_enters_product_in_serach_box(String product) {
	  
		hp.enterProductInSearchBox(product);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		
		hp.clickOnSearchBtn();
	}

	@Then("User should get valid product dispalyed in serch result")
	public void user_should_get_valid_product_dispalyed_in_serch_result() {
	 
		Assert.assertTrue(sp.getProductName().contains("HP"));
		
	}

	@Then("User should get message about no product matching")
	public void user_should_get_message_about_no_product_matching() {
	    
		Assert.assertTrue(sp.getNoProductMatchingmsg().contains("There is no product that matches the search criteria."));
	}


}
