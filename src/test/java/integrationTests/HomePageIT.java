package integrationTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class HomePageIT {

	private static final String HOME_PAGE = "http://localhost:8080/CW/";
	
	@Test
	public void homePageTest(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
		driver.getPageSource().contains("Minerva's car store - The best deals anywhere");
		driver.quit();
	}
}
