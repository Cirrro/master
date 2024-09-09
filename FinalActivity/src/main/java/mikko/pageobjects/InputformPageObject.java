package mikko.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mikko.AbstractComponents.AbstractComponents;

public class InputformPageObject extends AbstractComponents {

	WebDriver driver;

	public InputformPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// SimppleForm
	@FindBy(xpath = "//input[@id='user-message']")
	public WebElement usermessage;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Show Message']")
	public WebElement showmessage;

	@FindBy(id = "display")
	public WebElement display;

	@FindBy(id = "displayvalue")
	public WebElement displayvalue;

	@FindBy(xpath = "//input[@id='value1']")
	public WebElement value1;

	@FindBy(xpath = "//input[@id='value2']")
	public WebElement value2;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='Get Total']")
	public WebElement gettotal;

	@FindBy(xpath = "//span[@id='displayvalue']")
	public WebElement sumValue;

	// Checkbox
	@FindBy(xpath = "//input[@id='isAgeSelected']")
	public WebElement check;

	@FindBy(xpath = "//div[@id='txtAge']")
	public WebElement successcheckbox;

	// @FindBy(xpath="//input[@id='check1']") //create two xpath using value -
	// checkall and uncheck all
	// public WebElement checkall;

	@FindBy(xpath = "//input[@value='Check All']")
	public WebElement checkall;

	@FindBy(xpath = "//input[@value='Uncheck All']")
	public WebElement uncheckall;

	@FindBy(xpath = "//label[normalize-space()='Option 2']")
	public WebElement option2;

	@FindBy(xpath = "//div//input[@class='cb1-element']")
	public List<WebElement> checkboxes;

	// Radiobuttons
	@FindBy(css = "input[value='Male'][name='optradio']")
	public WebElement Male1;

	@FindBy(xpath = "//button[@class='btn btn-default' and text()='Get Checked value']")
	public WebElement getvalue1;

	@FindBy(xpath = "//p[@class='radiobutton']")
	public WebElement radiocheck;

	@FindBy(css = "input[value='Male'][name='gender']")
	public WebElement Male2;

	@FindBy(xpath = "//input[@value='15 - 50']")
	public WebElement agegroup;

	@FindBy(xpath = "//button[@class='btn btn-default' and text()='Get values']")
	public WebElement getvalue2;

	@FindBy(xpath = "//p[@class='groupradiobutton']")
	public WebElement groupradiocheck;

	// dropdownlist
	@FindBy(xpath = "//select[@id='select-demo']")
	public WebElement selectdropdown;

	@FindBy(xpath = "//option[@value='Saturday']")
	public WebElement satdropdown;

	@FindBy(xpath = "//p[@class='selected-value']")
	public WebElement dayselected;

	@FindBy(xpath = "//option[@value='Ohio']")
	public WebElement Ohioselected;

	@FindBy(xpath = "//button[@id='printMe']")
	public WebElement Firstselected;

	@FindBy(xpath = "//p[@class='getall-selected']")
	public WebElement showselected;

	// inputform
	@FindBy(xpath = "//input[@name='first_name']")
	public WebElement firstname;

	@FindBy(xpath = "//input[@name='last_name']")
	public WebElement lastname;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@name='phone']")
	public WebElement phonenumber;

	@FindBy(xpath = "//input[@name='address']")
	public WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	public WebElement city;

	@FindBy(xpath = "//select[@name='state']")
	public WebElement state;

	@FindBy(xpath = "//option[.='New York']")
	public WebElement statechoice;

	@FindBy(xpath = "//input[@name='zip']")
	public WebElement zip;

	@FindBy(xpath = "//input[@name='website']")
	public WebElement website;

	@FindBy(xpath = "//input[@value='no']")
	public WebElement Nohosting;

	@FindBy(xpath = "//textarea[@name='comment']")
	public WebElement comment;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	public WebElement send;

	@FindBy(xpath = "//div[@class='form-group has-feedback has-error']")
	public WebElement error;

	@FindBy(xpath = "//div[@class='form-group has-feedback has-success']")
	public WebElement success;

	// Ajaxform
	@FindBy(xpath = "//input[@name='title']")
	public WebElement Nameinput;

	@FindBy(xpath = "//textarea[@name='description']")
	public WebElement Commentinput;

	@FindBy(xpath = "//input[@value='submit']")
	public WebElement submitbutton;

	@FindBy(xpath = "//div[@id='submit-control']")
	public WebElement successsubmit;

	// Jqueryform
	@FindBy(xpath = "//span[@dir='ltr'][@style='width: 300px;']")
	public WebElement selectcountry;

	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']")
	public WebElement countrydropdown;

	@FindBy(xpath = "//li[@role='treeitem'][contains(text(),'Japan')]")
	public WebElement countryselected;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	public WebElement selectestate;

	@FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[2]")
	public WebElement selectterritory;

	@FindBy(xpath = "(//input[@role='textbox'])[2]")
	public WebElement terrtorydropdown;

	@FindBy(xpath = "//li[contains(.,'Guam')]")
	public WebElement territoryselected;

	@FindBy(xpath = "//select[@id='files']")
	public WebElement selectfile;

	@FindBy(xpath = "//option[normalize-space()='PHP']")
	public WebElement valuePhp;

	public void goToSimple() {
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
	}

	public void goTocheckbox() {
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	public void goToradiobutton() {
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}

	public void goTodropdown() {
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
	}

	public void goToinputform() {
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.seleniumeasy.com/input-form-demo.html");
	}

	public void goToAjaxform() {
		driver.get("https://demo.seleniumeasy.com/ajax-form-submit-demo.html");
	}

	public void goToJqueryform() {
		driver.get("https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html");
	}
}
