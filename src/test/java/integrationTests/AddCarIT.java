package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCarIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	
	@Test
	public void addCarTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Add Car product")).click();
		driver.findElement(By.id("name")).sendKeys("Test Car");
		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys("1");
		driver.findElement(By.id("price")).sendKeys("1000");
		driver.findElement(By.id("addCar")).click();
		Assert.assertTrue(driver.getPageSource().contains("Test Car"));
		driver.quit();
	}
	
	@Test
	public void addCarNegativeTestWithEmptyForm(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Add Car product")).click();
		driver.findElement(By.id("name")).sendKeys("Test Car");
		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys("1");
		driver.findElement(By.id("price")).sendKeys("1000");
		driver.findElement(By.id("addCar")).click();
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/CW/admin/addCar"));
		driver.quit();
	}
}
