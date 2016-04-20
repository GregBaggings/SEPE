package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SearchFlowIT {
	private static final String SEACRH_PAGE = "http://localhost:8080/CW/search";
	
	@Test
	public void searchFlowTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(SEACRH_PAGE);
		driver.findElement(By.name("searchKey")).sendKeys("Audi");
		driver.findElement(By.id("submission")).click();
		driver.getPageSource().contains("Audi");
		driver.findElement(By.linkText("Back to the search")).click();
		driver.quit();
	}
}
