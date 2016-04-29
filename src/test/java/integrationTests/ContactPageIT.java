package integrationTests;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactPageIT {

	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	private static final String CONTANCTS_PAGE = "http://localhost:8080/CW/contact";
	
	@Test
	public void contactPageTest() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.get(CONTANCTS_PAGE);
		File scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/contacts-page.jpg"));
		Assert.assertTrue(driver.getPageSource().contains("E-mail:"));
		Assert.assertTrue(driver.getPageSource().contains("Phone:"));
		Assert.assertTrue(driver.getPageSource().contains("Address:"));
		driver.quit();
	}
}
