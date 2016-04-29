package integrationTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	File scrnshot;

	@Test
	public void loginFlowTest() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/empty-login-form.jpg"));
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/full-login-form.jpg"));
		driver.findElement(By.name("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Add Car product"));
		driver.quit();
	}

	@Test
	public void loginFlowTestWithInvalidUser() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("TestUser");
		driver.findElement(By.name("password")).sendKeys("TestPw");
		driver.findElement(By.name("submit")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/validation-on-login-form.jpg"));
		Assert.assertTrue(driver.getPageSource().contains("Invalid username and password!"));
		driver.quit();
	}
}
