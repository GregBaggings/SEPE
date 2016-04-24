package integrationTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactPageIT {

	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	private static final String CONTANCTS_PAGE = "http://localhost:8080/CW/contact";
	
	@Test
	public void contactPageTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.get(CONTANCTS_PAGE);
		Assert.assertTrue(driver.getPageSource().contains("E-mail:"));
		Assert.assertTrue(driver.getPageSource().contains("Phone:"));
		Assert.assertTrue(driver.getPageSource().contains("Address:"));
		driver.quit();
	}
}
