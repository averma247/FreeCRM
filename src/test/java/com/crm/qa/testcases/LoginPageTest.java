package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testdata.ExcelUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	String xlFilePath = "./src/main/resources/testData/LoginDetails.xlsx";
	String sheetName = "login";
	ExcelUtil ProvideData = new ExcelUtil();
	Object[][] data;
	
	@DataProvider(name = "getLoginDetails")
	public Object[][] getLoginDetails() throws Exception {
		data = ProvideData.testData(xlFilePath, sheetName);			
		return data;
	}
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		init();
		loginPage= new LoginPage();
		logger= Logger.getLogger(LoginPageTest.class);
		
	}
	
	@Test(enabled = true)
	public void loginPageTitleTest() {
		String pageTitle= loginPage.validateLoginPageTitle();
		System.out.println("Page Title: "+ pageTitle);
		logger.info("Page Title: "+ pageTitle);
		Assert.assertEquals(pageTitle, "Free CRM - CRM software for customer relationship management, sales, and support");
	}
	
	@Test(dataProvider = "getLoginDetails",enabled = false)
	public void loginTest(String username,String password){
		logger.info("Username: "+username +"--------"+ "Password: "+password);
		homePage = loginPage.login(username,password);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
