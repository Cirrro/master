package mikko.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mikko.AbstractComponents.AbstractComponents;

public class TablePageObject extends AbstractComponents {

	WebDriver driver;

	public TablePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Table Pagination
	@FindBy(xpath = "//tbody[@id='myTable']//tr[@style='display: table-row;']")
	public WebElement tableRow;

	@FindBy(xpath = "//a[normalize-space()='2']")
	public WebElement pageTwo;

	@FindBy(xpath = "//a[@class='next_link']")
	public WebElement nextButton;

	@FindBy(xpath = "//a[@class='prev_link']")
	public WebElement prevButton;

	// Table Data Search
	@FindBy(xpath = "//input[@id='task-table-filter']")
	public WebElement searchFilter;

	@FindBy(xpath = "(//tbody)[1]//tr")
	public List<WebElement> taskTable;

	@FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-filter']")
	public WebElement filterButton;

	@FindBy(xpath = "//tr[@class='filters']//th")
	public WebElement filterBoxes;

	@FindBy(xpath = "//input[@placeholder='#']")
	public WebElement numFilter;

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement userFilter;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement firstnameFilter;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastnameFilter;

	// Table filter demo
	@FindBy(xpath = "//button[normalize-space()='Green']")
	public WebElement greenButton;

	@FindBy(xpath = "//button[normalize-space()='Orange']")
	public WebElement orangeButton;

	@FindBy(xpath = "//button[normalize-space()='Red']")
	public WebElement redButton;

	@FindBy(xpath = "//button[normalize-space()='All']")
	public WebElement allButton;

	// TTable Sort And Search Demo

	@FindBy(xpath = "//th[text()='Name']")
	public WebElement nameSort;

	@FindBy(xpath = "//th[text()='Position']")
	public WebElement positionSort;

	@FindBy(xpath = "//th[text()='Office']")
	public WebElement officeSort;

	@FindBy(xpath = "//th[text()='Age']")
	public WebElement ageSort;

	@FindBy(xpath = "//th[text()='Start date']")
	public WebElement dateSort;

	@FindBy(xpath = "//th[text()='Salary']")
	public WebElement salarySort;

	@FindBy(xpath = "//select[@name='example_length']")
	public WebElement lengthShow;

	@FindBy(xpath = "//select[@name='example_length']//option[@value='25']")
	public WebElement length25;

	@FindBy(xpath = "//select[@name='example_length']//option[@value='50']")
	public WebElement length50;

	@FindBy(xpath = "//input[@type='search']")
	public WebElement searchBox;

	public void goToTablePagination() {
		driver.get("https://demo.seleniumeasy.com/table-pagination-demo.html");
	}

	public void goToTableDataSearch() {
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
	}

	public void goToTableFilterDemo() {
		driver.get("https://demo.seleniumeasy.com/table-records-filter-demo.html");
	}

	public void goToTableSortandSearchDemo() {
		driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
	}

	public void goTodataTableDownload() {
		driver.get("https://demo.seleniumeasy.com/table-data-download-demo.html");
	}

}
