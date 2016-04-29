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

public class AddCarIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	File scrnshot;
	
	@Test
	public void addCarTest() throws IOException{
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
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/full-car-form.jpg"));
		driver.findElement(By.id("addCar")).click();
		Assert.assertTrue(driver.getPageSource().contains("Test Car"));
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/after-car-add.jpg"));
		driver.quit();
	}
	
	@Test
	public void addCarNegativeTestWithEmptyForm() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Add Car product")).click();
		driver.findElement(By.id("addCar")).click();
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/CW/admin/addCar"));
		File scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/empty-car-form.jpg"));
		driver.quit();
	}
}
