package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	
	@Test
	public void loginFlowTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Add Car product"));
		driver.quit();
	}
	
	@Test
	public void loginFlowTestWithInvalidUser(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("TestUser");
		driver.findElement(By.name("password")).sendKeys("TestPw");
		driver.findElement(By.name("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Invalid username and password!"));
		driver.quit();
	}
}
