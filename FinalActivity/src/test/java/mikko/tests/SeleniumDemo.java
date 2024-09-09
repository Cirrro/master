package mikko.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testBase.TestBase;

public class SeleniumDemo extends TestBase{

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	WebDriverManager.chromedriver().setup();
	// driver = new ChromeDriver();
	//.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	driver.get("https://demo.seleniumeasy.com/");
	 
	InputForms inputForms = new InputForms();
	DatePickers datePickers = new DatePickers();
	Table table = new Table();
	progressBar progressBar = new progressBar();
	AlertsandModals alertsAndModals = new AlertsandModals();
	listBox listBox = new listBox();
	
	@BeforeMethod
	public void setUpBeforeMethod() 
	{
		 
		 inputForms.setDriver(driver);
		 datePickers.setDriver(driver);
		 table.setDriver(driver);
		 progressBar.setDriver(driver);
		 alertsAndModals.setDriver(driver);
		 listBox.setDriver(driver);
	}
	
    @Test
    public void runTests() throws InterruptedException, IOException 
    {
    	long startTime = System.currentTimeMillis();
    	
		runInputFormTests();
		runDatePickerTests();
        runTableTests();
        runProgressBarTests();
    	runListBoxTests();
        runAlertAndModalsTests();
        
        
        long endTime = System.currentTimeMillis();
		long durationseconds = (endTime - startTime) / 1000;
		
		System.out.println("\nRuntime duration: " +durationseconds+ " seconds\n");
    }
	
	 public void runInputFormTests() throws InterruptedException, IOException 
	{
	    inputForms.simpleForm();
	    inputForms.checkboxForm();
	    inputForms.radioButtons();
	    inputForms.dropDown();
	    inputForms.inputForm();
	    inputForms.AjaxForm();
	    inputForms.JqueryForm();
	}
	
	public void runDatePickerTests() throws InterruptedException 
	{
		datePickers.DateExample();
	    datePickers.jqeuryDatepicker();
		
	}

	
	public void runTableTests() throws InterruptedException 
	{
		 table.tablePagination();
		 table.dataSearch();
         table.tableFilterDemo();
         table.tableSortAndSearch();
         table.dataTableDownload();
		
	}
	
	
	public void runProgressBarTests() throws InterruptedException 
	{
		 progressBar.jqueryProgressBar();
	     progressBar.bootstrapProgressBar();
	     progressBar.dragAndDrop();
		
	}

		
	public void runAlertAndModalsTests() throws InterruptedException 
	{
		 alertsAndModals.bootstrapAlert();
         alertsAndModals.bootstrapModal();
         alertsAndModals.windowPopupModal();
		
	}
	
		
	public void runListBoxTests() throws InterruptedException 
	{
		 listBox.bootstrapListbox();
	     listBox.dataListFilter();
		
	}
	
	
}
