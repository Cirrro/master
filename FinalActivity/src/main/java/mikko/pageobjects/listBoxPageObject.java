package mikko.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mikko.AbstractComponents.AbstractComponents;

public class listBoxPageObject extends AbstractComponents{

WebDriver driver;
	
	public listBoxPageObject(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Dual List Box Example
	@FindBy(xpath="//li[text()='bootstrap-duallist ']")
	public WebElement bootstrap;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-sm move-right']")
	public WebElement rightButton;
	
	
	//
	@FindBy(xpath="//input[@id='input-search']")
	public WebElement searchFilter;
	
	
	public void goTobootstrapListbox()
	{
		driver.get("https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html");
	}
	public void goTodataListFilter()
	{
		driver.get("https://demo.seleniumeasy.com/data-list-filter-demo.html");
	}
	
}
