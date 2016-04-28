package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveCarIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	
	@Test
	public void removeCarTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Remove Car")).click();
		driver.findElement(By.id("carId")).sendKeys("0");
		driver.findElement(By.id("removeCar")).click();
		Assert.assertTrue(!driver.getPageSource().contains("Audi RX-5"));
		driver.quit();
	}
	
	@Test
	public void removeCarNegativeTestWithEmptyForm(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Remove Car")).click();
		driver.findElement(By.id("removeCar")).click();
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/CW/admin/removeCar"));
		driver.quit();
	}
}
