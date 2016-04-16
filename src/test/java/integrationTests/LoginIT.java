package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	
	@Test
	public void loginFlowTest(){
		WebDriver driver = new FirefoxDriver();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.getPageSource().contains("Remove Product");
		driver.quit();
	}
}
