package Betbarter;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BetbarterQA{
	private WebDriver driver; 
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver
       // System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
    	WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        extent.attachReporter(sparkReporter);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
    
    
    @Test
    
	public void testBetbarterAutomation() throws IOException {
        test = extent.createTest("Betbarter Automation Test");
        
     // launching site
        try {
        	
        	driver.get("https://qabb.betbarter.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//div[@class='sal-close-popupdt']")).click();
            driver.findElement(By.xpath("//a[text()=\"Accept\"]")).click();
            logWithScreenshot(Status.PASS, "Site Loading Successfully.");
            screenShot(driver, "E:\\Screenshots\\Site Loaded.jpg"); // Capture screenshot here
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to launch site.");
        }
        

        // Logging in
        try {
            driver.findElement(By.xpath("//span[text()=\"Login\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys("ajithbabu");
            driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("test@123");
            driver.findElement(By.xpath("//*[@id=\"login_check\"]")).click();
            logWithScreenshot(Status.PASS, "Login Successfully.");
            screenShot(driver, "E:\\Screenshots\\Login.jpg"); // Capture screenshot here
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to login.");
        }

        // Navigating and switching to the frame
        try {
            driver.findElement(By.xpath("//*[@id=\"myPage\"]/div[2]/div[1]/div[3]/ul/li[3]/a/span")).click();
            driver.switchTo().frame("frameLeft");
            logWithScreenshot(Status.PASS, "Sportsbook Page Loaded Successfully.");
            screenShot(driver, "E:\\Screenshots\\Sportsbook Page.jpg"); // Capture screenshot here
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to navigate or switch to the frame.");
        }

        // Handling the user input for selecting an element
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the element to click (1, 2, 3, or 4):");
        int indexToClick = scanner.nextInt();
        scanner.close();

        WebElement element = null;

        switch (indexToClick) {
    case 1:
        element = driver.findElement(By.xpath("(//div[@class='sportsMenuIcon_1'])[1]"));
        break;
    case 2:
        element = driver.findElement(By.xpath("(//div[@class='sportsMenuIcon_20'])[1]"));
        break;
    case 3:
        element = driver.findElement(By.xpath("(//div[@class='sportsMenuIcon_4'])[1]"));
        break;
    case 4:
        element = driver.findElement(By.xpath("(//div[@class='live_info_web'])[1]"));
        break;
    default:
        System.out.println("Invalid index entered. Please enter a valid index (1, 2, 3, or 4).");
        return;
}


        if (element != null && element.isDisplayed() && element.isEnabled()) {
            try {
                element.click();
                test.log(Status.PASS, "Clicked on element " + indexToClick);
                screenShot(driver, "E:\\Screenshots\\ElementClick_Success.jpg"); // Capture screenshot here
            } catch (Exception e) {
                test.log(Status.FAIL, "Failed to click on element " + indexToClick);
                screenShot(driver, "E:\\Screenshots\\ElementClick_Failure.jpg"); // Capture screenshot here
            }
        } else {
            test.log(Status.FAIL, "Element not found, not visible, or not clickable.");
            // Handle the situation accordingly, such as trying another element or reporting the issue.
        }

        // Capturing the screenshot after clicking the element
        try {
        	 logWithScreenshot(Status.PASS, "Bet Placed Successfully.");
        	driver.findElement(By.className("outcomeName")).click();
            driver.findElement(By.xpath("(//input[@type=\"number\"])[1]")).sendKeys("54");
            driver.findElement(By.xpath("//div[@class=\"bet_submit_btn\"]")).click();
            screenShot(driver, "E:\\Screenshots\\Betplaced.jpg"); // Capture screenshot here
        } catch (Exception e) {
            test.log(Status.FAIL, "Bet placed failed.");
        }

        try {
            WebElement betHistoryElement = driver.findElement(By.xpath("(//div[@class='header_tabs_bethistory_img'])[1]"));
            betHistoryElement.click();
            Thread.sleep(1000);
            WebElement betHistoryAll = driver.findElement(By.xpath("(//span[@class='dropdownhead'])[2]"));
            betHistoryAll.click();
            Thread.sleep(4000);
            logWithScreenshot(Status.PASS, "Navigated to Bet History successfully.");
        } catch (Exception e) {
            logWithScreenshot(Status.FAIL, "Bet History failed.");
        }
    }
        
    private void logWithScreenshot(Status status, String message) throws IOException {
        String screenshotPath = "E:\\Screenshots\\" + System.currentTimeMillis() + ".jpg";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        
        String screenshotLink = "<a href='file:///" + screenshotPath + "'>View Screenshot</a>";
        
        // Log the message with the screenshot link
        test.log(status, message + " - " + screenshotLink);
    }

    public static void screenShot(WebDriver driver, String loc) {
        TakesScreenshot tk = (TakesScreenshot) driver;
        File source = tk.getScreenshotAs(OutputType.FILE);
        File destination = new File(loc);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BetbarterQA betbarter = new BetbarterQA();
        try {
            betbarter.setUp();
            betbarter.testBetbarterAutomation();
            betbarter.tearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }