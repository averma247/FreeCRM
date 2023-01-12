package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long Page_Load_Timeout=20;
	public static long Implicit_Wait=10;
	public static String screenshotPath;
	
	public static void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		screenshotPath=currentDir + "/screenshots/" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(scrFile, new File(screenshotPath));
	}
	

}
