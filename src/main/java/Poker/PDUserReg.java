package Poker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class PDUserReg {
	

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DTPL\\Music\\chromedriver-win64\\chromedriver.exe");
		 //ChromeOptions options = new ChromeOptions();
		
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        
    	driver.get("https://qa.pokerdangal.co.in/controls/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//username
		driver.findElement(By.xpath("//*[@id = 'username']")).sendKeys("admin");
		//password
       driver.findElement(By.xpath("//*[@id = 'password']")).sendKeys("test123");    
       Thread.sleep(1000);
       //login
       driver.findElement(By.xpath("//*[@id = 'submit']")).click();
       //register 
       driver.get("https://qa.pokerdangal.co.in/controls/user/account/register?rid=11");
       for(int i=1;i<=10;i++) {
    	   String randomPhoneNumber = generatePhoneNumber();
       //playername
       driver.findElement(By.xpath("//*[@id = 'USERNAME']")).sendKeys("pduser"+i);
       //free chip
       Select dropdown = new Select(driver.findElement(By.xpath("//*[@id = 'internal_player']"))); // Replace with the actual XPath of the dropdown
       dropdown.selectByIndex(1);
      
       
       //email
       driver.findElement(By.xpath("//*[@id = 'EMAIL']")).sendKeys("Test"+i+"@gmail.com");
       
       //password
       driver.findElement(By.xpath("//*[@id = 'PASSWORD']")).sendKeys("Test@123");
       //confirm password
       driver.findElement(By.xpath("//*[@id = 'CONFIRM_PASSWORD']")).sendKeys("Test@123");
       //gender
       Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id = 'GENDER']"))); // Replace with the actual XPath of the dropdown
       dropdown1.selectByIndex(1);
       //dob
       WebElement inputBox = driver.findElement(By.id("DOB")); // Replace with the actual id of the input box

       // Enter text using JavaScript
       String textToEnter = "19-02-1997";
       ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputBox, textToEnter);
       
       //firstname
       driver.findElement(By.xpath("//*[@id = 'FIRST_NAME']")).sendKeys("PD");
       //lastname
       driver.findElement(By.xpath("//*[@id = 'LAST_NAME']")).sendKeys("Test"+i);
       //contactno
       driver.findElement(By.xpath("//*[@id = 'CONTACT']")).sendKeys(randomPhoneNumber);
       //doorno
       driver.findElement(By.xpath("//*[@id = 'PARTNER_STREET']")).sendKeys("Test"+i);
       //state
       Select state = new Select(driver.findElement(By.xpath("//*[@id = 'PARTNER_STATE']"))); // Replace with the actual XPath of the dropdown
       state.selectByIndex(9);
       Thread.sleep(1000);
       //city
       Select city = new Select(driver.findElement(By.xpath("//*[@id = 'PARTNER_CITY']"))); // Replace with the actual XPath of the dropdown
       city.selectByIndex(1);
//       //country
//       Select country = new Select(driver.findElement(By.xpath("//*[@id = 'PARTNER_COUNTRY']"))); // Replace with the actual XPath of the dropdown
//       dropdown.selectByIndex(55);
       
       //pincode
       driver.findElement(By.xpath("//*[@id = 'ZIPCODE']")).sendKeys("600008");
       
     //create button
       driver.findElement(By.xpath("//*[@id = 'Submit']")).click();
       Thread.sleep(3000);
       }
	}
	private static String generatePhoneNumber() {
        // Generate a random 10-digit phone number
        StringBuilder phoneNumber = new StringBuilder("9");

        for (int i = 0; i < 9; i++) {
            phoneNumber.append((int) (Math.random() * 10)); // Append a random digit (0-9)
        }

        return phoneNumber.toString();
    }
}
