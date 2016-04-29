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

public class RemoveNewsIT {
	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	File scrnshot;
	
	@Test
	public void removeNewsTest() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Remove News from the Home Page")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/empty-remove-news-form.jpg"));
		driver.findElement(By.id("newsId")).sendKeys("0");
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/full-remove-news-form.jpg"));
		driver.findElement(By.id("removeNews")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/after-remove-news-homepage.jpg"));
		Assert.assertTrue(!driver.getPageSource().contains("Test1"));
		driver.quit();
	}
	
	@Test
	public void removeNewsNegativeTestWithEmptyForm() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Remove News from the Home Page")).click();
		driver.findElement(By.id("removeNews")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/validation-on-remove-news-form.jpg"));
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/CW/admin/removeNews"));
		driver.quit();
	}
}
