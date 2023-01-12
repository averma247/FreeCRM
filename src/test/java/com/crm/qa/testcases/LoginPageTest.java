package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		init();
		loginPage= new LoginPage();
		
	}
	
	@Test
	public void loginPageTitleTest() {
		String pageTitle= loginPage.validateLoginPageTitle();
		System.out.println("Page Title: "+ pageTitle);
		Assert.assertEquals(pageTitle, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
