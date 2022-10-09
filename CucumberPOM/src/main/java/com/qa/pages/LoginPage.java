package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePage;
import com.qa.util.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository(OR)
	
		@FindBy(xpath="//a[text()='Login']")
		WebElement apploginBtn;
		
		@FindBy(xpath="//img[@class='img-responsive' and @alt='free crm logo']")
		WebElement crmLogo;
		
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//div[text()='Login']")
		WebElement loginBtn;
		
		@FindBy(xpath="//a/span[text()=' sign up']")
		WebElement signUpBtn;
		
		//To initialize the above WebElements (Initializing the Page Objects), create constructor for that and call the method of initElements
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateCRMImage() throws InterruptedException {
			Thread.sleep(5000);
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd) throws InterruptedException {
			Thread.sleep(5000);
			apploginBtn.click();
			Thread.sleep(5000);
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			//sometime above loginBtn.click(); ====> Not worked properly, then in that case we can use the below JavascriptExecutor code to work
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click();", loginBtn);
			Thread.sleep(5000);
			return new HomePage(); // To validate HomePage WebObjects after click of login button
		}
}