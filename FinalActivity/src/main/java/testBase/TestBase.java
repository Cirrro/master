package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private static final boolean True = false;
	protected WebDriver driver;
	protected WebDriverWait wait;

	@BeforeMethod(alwaysRun = True)
	public void setUp() {
		WebDriverManager.chromedriver().driverVersion("119.0.6045.105").setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = True)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

