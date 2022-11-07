package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitHelper;

public class LoginPage {
	
		WaitHelper wh;
		public WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this );
			wh=new WaitHelper(driver);
		}
		@FindBy(css="input[name='username']")
		WebElement userNameTextField;
		
		@FindBy(css="input[name='password']")
		WebElement passwordTextField;
		
		@FindBy(css="button[type='submit']")
		WebElement loginButton;
		
		public String getPageTitle()
		{
			return driver.getTitle();
		}
		public void setUserName(String uname) {
			wh.WaitForElement(userNameTextField, Duration.ofSeconds(10));
			userNameTextField.clear();
			userNameTextField.sendKeys(uname);
		}
		public void setPassword(String password) {
			wh.WaitForElement(passwordTextField, Duration.ofSeconds(10));
			passwordTextField.clear();
			passwordTextField.sendKeys(password);
		}
		public void clickLogin() {
			loginButton.click();
		}
		
}
