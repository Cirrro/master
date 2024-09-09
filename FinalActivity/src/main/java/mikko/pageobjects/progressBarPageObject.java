package mikko.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mikko.AbstractComponents.AbstractComponents;

public class progressBarPageObject extends AbstractComponents {

	WebDriver driver;

	public progressBarPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Download Dialog

	@FindBy(xpath = "//button[@id='downloadButton']")
	public WebElement downloadButton;

	@FindBy(xpath = "//div[@id='progressbar']")
	public WebElement progressBar;

	@FindBy(xpath = "//button[text()='Close']")
	public WebElement closeButton;

	@FindBy(xpath = "//div[@role='dialog']")
	public WebElement downloadDialog;

	// Stylish progress bar demo
	@FindBy(xpath = "//button[@id='cricle-btn']")
	public WebElement clickDownload;

	@FindBy(xpath = "//div[@class='prog-circle']")
	public WebElement progressDownload;

	@FindBy(xpath = "//div[@class='percenttext']")
	public WebElement percentagetext;

	// Range Sliders
	@FindBy(xpath = "(//input[@type='range'])[1]")
	public WebElement sliderOne;

	@FindBy(xpath = "(//input[@type='range'])[2]")
	public WebElement sliderTwo;

	@FindBy(xpath = "(//input[@type='range'])[3]")
	public WebElement sliderThree;

	@FindBy(xpath = "(//input[@type='range'])[4]")
	public WebElement sliderFour;

	@FindBy(xpath = "(//input[@type='range'])[5]")
	public WebElement sliderFive;

	@FindBy(xpath = "(//input[@type='range'])[6]")
	public WebElement sliderSix;

	@FindBy(xpath = "(//output[@id='range'])[1]")
	public WebElement rangeOne;

	@FindBy(xpath = "//output[@id='rangePrimary']")
	public WebElement rangeTwo;

	@FindBy(xpath = "//output[@id='rangeSuccess']")
	public WebElement rangeThree;

	@FindBy(xpath = "//output[@id='rangeInfo']")
	public WebElement rangeFour;

	@FindBy(xpath = "//output[@id='rangeWarning']")
	public WebElement rangeFive;

	@FindBy(xpath = "//output[@id='rangeDanger']")
	public WebElement rangeSix;

	public void goToProgressBar() {
		driver.get("https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
	}

	public void goToBootstrapProgressBar() {
		driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
	}

	public void goTodragAndDrop() {
		driver.get("https://demo.seleniumeasy.com/drag-drop-range-sliders-demo.html");
	}
}
