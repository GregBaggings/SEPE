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

public class PublishNewsIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	File scrnshot;

	@Test
	public void publishNewsTest() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Add news to the Home Page")).click();
		driver.findElement(By.id("date")).clear();
		driver.findElement(By.id("date")).sendKeys("2016/07/12");
		driver.findElement(By.id("title")).sendKeys("Test Title");
		driver.findElement(By.id("content")).sendKeys("Test Content");
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/full-news-form.jpg"));
		driver.findElement(By.id("addNews")).click();
		driver.findElement(By.linkText("List of the databases")).click();
		scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("c:/screens/after-news-add.jpg"));
		Assert.assertTrue(driver.getPageSource().contains("Test Title"));
		Assert.assertTrue(driver.getPageSource().contains("Test Content"));
		driver.quit();
	}

	@Test
	public void publishNewsNegativeTestWithEmptyForm() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Add news to the Home Page")).click();
		driver.findElement(By.id("date")).clear();
		driver.findElement(By.id("addNews")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/empty-news-form.jpg"));
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/CW/admin/addNews"));
		driver.quit();
	}
}
