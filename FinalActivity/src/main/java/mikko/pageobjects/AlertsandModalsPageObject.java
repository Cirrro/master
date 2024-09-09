package mikko.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mikko.AbstractComponents.AbstractComponents;

public class AlertsandModalsPageObject extends AbstractComponents{

	WebDriver driver;
	
	public AlertsandModalsPageObject(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Bootstrap Alert messages
	
	@FindBy(xpath="//div[@class='col-md-4']//button")
	public List<WebElement> allButtons;
	
	@FindBy(xpath="//div[@class='col-md-6']//button")
	public WebElement allCloseButtons;
	
	//Bootstrap Modal
	@FindBy(xpath="//a[@href='#myModal0']")
	public WebElement launchButton1;
	
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	public WebElement modalContent;
	
	@FindBy(xpath="//div[@id='myModal0']//a[@class='btn btn-primary']")
	public WebElement modalButton;
	
	@FindBy(xpath="//a[@href='#myModal']")
	public WebElement launchButton2;
	
	@FindBy(xpath="//a[@href='#myModal2']")
	public WebElement launchButton3;
	
	@FindBy(xpath="(//a[@class='btn'][normalize-space()='Close'])[3]")
	public WebElement closeButton3;
	
	@FindBy(xpath="(//a[@class='btn btn-primary' and text()='Save changes'])[2]")
	public WebElement modalButton2;
	
	
	//Window popup Modal
	@FindBy(xpath="//a[text()='  Follow On Twitter ']")
	public WebElement twitterButton;
	
	@FindBy(xpath="//a[text()='  Like us On Facebook ']")
	public WebElement facebookButton;
	
	@FindBy(xpath="//a[text()='Follow Twitter & Facebook']")
	public WebElement twitterandfacebookButton;
	
	@FindBy(xpath="//a[@id='followall']")
	public WebElement followAll;
	
	public void goTobootstrapAlert()
	{
		driver.get("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");
	}
	
	public void goTobootstrapModal()
	{
		driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
	}
	
	public void goTowindowPopupModal()
	{
		driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
	}
	
}
