package integrationTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactPageIT {

	private static final String CONTACT_PAGE = "http://localhost:8080/CW/";
	
	@Test
	public void contactPageTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(CONTACT_PAGE);
		driver.getPageSource().contains("E-Mail");
		driver.getPageSource().contains("Phone");
		driver.getPageSource().contains("Address");
		driver.quit();
	}
}
