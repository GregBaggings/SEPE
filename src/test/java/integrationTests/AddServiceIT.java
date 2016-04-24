package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddServiceIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";

	@Test
	public void addServiceTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Add Service")).click();
		driver.findElement(By.id("name")).sendKeys("Test Service");
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("10");
		driver.findElement(By.id("onStock")).sendKeys("true");
		driver.findElement(By.id("addService")).click();
		Assert.assertTrue(driver.getPageSource().contains("Test Service"));
		driver.quit();
	}
}
