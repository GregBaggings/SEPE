package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutIT {
private static final String HOME_PAGE = "http://localhost:8080/CW/";
	
	@Test
	public void logoutFlowTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Logout")).click();
		Assert.assertTrue(driver.getPageSource().contains("News"));
		driver.quit();
	}
}
