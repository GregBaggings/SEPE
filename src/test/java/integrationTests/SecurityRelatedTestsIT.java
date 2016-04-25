package integrationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// This test contains all security related test scenario to check  
// that a not logged in user cannot access the admin features.
public class SecurityRelatedTestsIT {
	public final static String EXPECTED_URL_AFTER_REDIRECT = "http://localhost:8080/CW/";

	@Test
	public void adminPageOpenTest() {
		String URL = "http://localhost:8080/CW/admin";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
	@Test
	public void addCarOpenTest() {
		String URL = "http://localhost:8080/CW/admin/addCar";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
	@Test
	public void addServiceOpenTest() {
		String URL = "http://localhost:8080/CW/admin/addService";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
	@Test
	public void removeCarOpenTest() {
		String URL = "http://localhost:8080/CW/admin/removeCar";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
	@Test
	public void removeServiceOpenTest() {
		String URL = "http://localhost:8080/CW/admin/removeService";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
	@Test
	public void addNewsOpenTest() {
		String URL = "http://localhost:8080/CW/admin/addNews";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
	@Test
	public void removeNewsOpenTest() {
		String URL = "http://localhost:8080/CW/admin/removeNews";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
	@Test
	public void listTablesOpenTest() {
		String URL = "http://localhost:8080/CW/admin/list";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Assert.assertTrue(driver.getCurrentUrl().equals(EXPECTED_URL_AFTER_REDIRECT));
	}
	
}
