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

public class SearchFlowIT {
	private static final String SEACRH_PAGE = "http://localhost:8080/CW/search";
	File scrnshot;
	
	@Test
	public void searchFlowTest() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(SEACRH_PAGE);
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/search-page.jpg"));
		driver.findElement(By.name("searchKey")).sendKeys("Seat Ibiza");
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/full-search-form.jpg"));
		driver.findElement(By.id("submission")).click();
		scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new
				File("c:/screens/search-result.jpg"));
		Assert.assertTrue(driver.getPageSource().contains("Seat Ibiza"));
		driver.findElement(By.linkText("Back to the search")).click();
		driver.quit();
	}
}
