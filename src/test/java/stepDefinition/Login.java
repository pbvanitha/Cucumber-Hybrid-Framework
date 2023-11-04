package stepDefinition;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v115.fedcm.model.Account;

import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	WebDriver driver;
	
     
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
		
	}

	
	   
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(emailText);
		
	}
	
	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
	    
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterPassword(passwordText);
		
	}


	@When("User clicks on Login Button")
	public void user_clicks_on_login_button() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickOnLoginButton();
	   
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		AccountPage accountpage= new AccountPage(driver);
    Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformationOption());
	    
	}
	
	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String emailText) {
		
			driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp());
			
	   
		
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
	   
	}

	@When("User enters invalid password {string} into password field")
	public void User_enters_invalid_password_into_password_field(String passwordText) {
		
		driver.findElement(By.id("input-password")).sendKeys(getPasswordTimeStamp());
		
	}
	
public String getEmailTimeStamp() {
	Date date = new Date();
	return "amotoori"+date.toString().replace("", "_").replace(":","")+"@gmail.com";
	
}
public String getPasswordTimeStamp() {
	Date date = new Date();
	return "amotoori"+date.toString().replace("", "_").replace(":","")+"@gmail.com";
	
}

	
	    
	}



	
	
	
	

