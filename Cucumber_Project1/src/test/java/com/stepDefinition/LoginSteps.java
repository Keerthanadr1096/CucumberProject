package com.stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageObjects.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends BaseClass {
	@Before
	public void setup() throws IOException {
		
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
		System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("user is on loginpage")
	public void user_is_on_loginpage() {
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_admin_and_password_as(String string, String string2) {
		lp=new LoginPage(driver);
		lp.setUserName("Admin");
		lp.setPassword("admin123");
	}

	@And("click on login button")
	public void click_on_login_button() {
	   lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	    
		if(driver.getPageSource().contains("Invalid credentials")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else { 
			Assert.assertEquals("OrangeHRM" ,lp.getPageTitle());
		}
	}
	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}
	
	
}
