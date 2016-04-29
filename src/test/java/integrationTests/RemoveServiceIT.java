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

public class RemoveServiceIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	File scrnshot;

	@Test
	public void removeServiceTest() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Remove Service")).click();
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/empty-remove-service-form.jpg"));
		driver.findElement(By.id("serviceId")).sendKeys("0");
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/full-remove-service-form.jpg"));
		driver.findElement(By.id("removeService")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/after-remove-service.jpg"));
		Assert.assertTrue(!driver.getPageSource().contains("Repair for any Audi"));
		driver.quit();
	}

	@Test
	public void removeServiceNegativeTestWithEmptyForm() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Remove Service")).click();
		driver.findElement(By.id("removeService")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/validation-on-remove-service-form.jpg"));
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/CW/admin/removeService"));
		driver.quit();
	}
}
