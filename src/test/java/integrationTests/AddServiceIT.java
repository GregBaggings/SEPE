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

public class AddServiceIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	File scrnshot;

	@Test
	public void addServiceTest() throws IOException {
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
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/full-service-form.jpg"));
		driver.findElement(By.id("addService")).click();
		Assert.assertTrue(driver.getPageSource().contains("Test Service"));
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/after-service-add.jpg"));
		driver.quit();
	}

	@Test
	public void addServiceNegativeTestWithEmptyForm() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Add Service")).click();
		driver.findElement(By.id("addService")).click();
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/empty-service-form.jpg"));
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/CW/admin/addService"));
		driver.quit();
	}
}
