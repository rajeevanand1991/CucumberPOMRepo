package com.qa.stepDefinitions;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps extends TestBase {
	//LoginPage loginpage = new LoginPage(); ==> It will initialize only once, then other methods cannot able to call using those reference
	//Faced java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.SearchContext.findElement(org.openqa.selenium.By)" because "this.searchContext" is null
	LoginPage loginpage;
	HomePage homepage;

	@Given("user opens browser")
	public void user_opens_browser() {
		TestBase.initialization();
	}
	
	@Then("user is on login page")
	public void user_is_on_login_page() {
		loginpage = new LoginPage(); //This will make initialize the reference of loginpage and use for other methods
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals("Free CRM software for customer relationship management India", title);
	}
	
	@Then("user logs into app")
	public void user_enters_username_and_password() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Then("validate home page title")
	public void validate_home_page_title() {
		String homeTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals("Free CRM", homeTitle);
	}
	
	@Then("validate logged in username")
	public void validate_logged_in_username() {
		boolean flag = homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
}