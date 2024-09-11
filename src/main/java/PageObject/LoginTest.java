package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	//LoginPage lp;
	LoginPage2 lp;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://qaenv.satbet.com/");
		//Thread.sleep(5000);
		lp = new LoginPage2(driver);	
	}
	
	@Test
	void testLogin()
	{
		lp.clicklogin();
		lp.setUserName("Testcam1");
		lp.setPassword("Test@123");
		lp.clickSubmit();			
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
