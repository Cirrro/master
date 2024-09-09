package mikko.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mikko.AbstractComponents.AbstractComponents;

public class DatepickerPageObject extends AbstractComponents {

	WebDriver driver;

	public DatepickerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Date Example
	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	public WebElement selectdate;

	@FindBy(xpath = "//td[@class='new disabled day'][normalize-space()='1']")
	public WebElement futuredate;

	@FindBy(xpath = "(//th[@class='today'][normalize-space()='Today'])[1]")
	public WebElement todaybutton;

	@FindBy(xpath = "(//input[@placeholder='dd/mm/yyyy'])[1]")
	public WebElement todaydate;

	@FindBy(xpath = "(//th[@class='clear'][normalize-space()='Clear'])[1]")
	public WebElement clearbutton;

	@FindBy(xpath = "//input[@placeholder='Start date']")
	public WebElement startdate;

	@FindBy(xpath = "//input[@placeholder='End date']")
	public WebElement enddate;

	@FindBy(xpath = "//td[normalize-space()='9']")
	public WebElement pickdate;

	@FindBy(xpath = "//td[normalize-space()='10']")
	public WebElement date1;

	@FindBy(xpath = "//td[normalize-space()='13']")
	public WebElement date2;

	// JQuery Date Picker Demo

	@FindBy(xpath = "//input[@id='from']")
	public WebElement fromDate;

	@FindBy(xpath = "//input[@id='to']")
	public WebElement toDate;

	@FindBy(xpath = "//a[normalize-space()='9']")
	public WebElement fromDatePick;

	@FindBy(xpath = "//a[normalize-space()='16']")
	public WebElement toDatePick;

	@FindBy(xpath = "//a[normalize-space()='10']")
	public WebElement Pickdate10;

	@FindBy(xpath = "//a[normalize-space()='20']")
	public WebElement Pickdate20;

	@FindBy(xpath = "//td[@data-handler='selectDay']")
	public WebElement dateDays;

	@FindBy(xpath = "//span[@class='ui-state-default']")
	public WebElement disabledDays;

	public void goToDatepicker() {
		driver.get("https://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
	}

	public void goToJqueryDatepicker() {
		driver.get("https://demo.seleniumeasy.com/jquery-date-picker-demo.html");
	}

}
