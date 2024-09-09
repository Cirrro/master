package mikko.tests;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import mikko.pageobjects.DatepickerPageObject;
import testBase.TestBase;

public class DatePickers extends TestBase {

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void DateExample() throws InterruptedException {

		try {
			DatepickerPageObject DatePick = new DatepickerPageObject(driver);

			DatePick.goToDatepicker();
			// Date Example :
			System.out.println("\nDate Example:\n");

			// Future Dates Disabled
			DatePick.selectdate.click();
			Boolean futuredate = DatePick.futuredate.isEnabled();
			Assert.assertTrue(futuredate, "Future dates enabled");
			System.out.println("Future dates disabled");

			// Days Of Week Disabled- Sunday
			By sundates = By.xpath("//td[@class='disabled disabled-date day']");
			List<WebElement> disabledate = driver.findElements(sundates);

			for (WebElement elementchoice : disabledate) {

				// Boolean dates = !elementchoice.isEnabled();
				if (!elementchoice.isEnabled() == true) {

					Assert.assertTrue(!elementchoice.isEnabled(), "dates enabled");
					// System.out.println(driver.findElement(By.xpath("//td[@class='disabled
					// disabled-date day']")).getText());
					// hindi makuha na maayos yung text per xpath

				} else {
					System.out.println("Selected dates are disabled");
				}
			}

			// Week Starts from Monday
			String[] itemsNeeded = { "Mo" };
			int j = 0;

			List<WebElement> dayname = driver.findElements(By.xpath("//th[@class='dow']"));
			for (WebElement element : dayname) {
				String[] name = element.getText().split("");
				List itemsNeededList = Arrays.asList(itemsNeeded);

				if (itemsNeededList.contains(name)) // finding the present name in Array
				{
					j++;
					Assert.assertEquals(name, "Mo");

				}
			}
			System.out.println("Week Starts from Monday");

			// Click on 'Today' to select Current date
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();

			DatePick.todaybutton.click();
			Thread.sleep(1000);
			String todaydate = DatePick.todaydate.getAttribute("value");
			Assert.assertEquals(todaydate, formatter.format(date));
			System.out.println("Today's current date is " + todaydate);

			// Click on Clear button to clear the date entered
			Thread.sleep(1000);
			DatePick.selectdate.click();
			DatePick.clearbutton.click();
			String datetextbox = DatePick.todaydate.getAttribute("value");
			Assert.assertEquals(datetextbox, "");
			System.out.println("Entered dates are clear");

			// Date Range Example :
			System.out.println("\nDate Range Example:\n");
			// Days Of Week Disabled- Sunday
			DatePick.startdate.click();
			By Sundates = By.xpath("//td[@class='disabled disabled-date day']");
			List<WebElement> Disabledate = driver.findElements(Sundates);

			for (WebElement elementchoice : Disabledate) {

				// Boolean dates = !elementchoice.isEnabled();
				if (!elementchoice.isEnabled() == true) {

					Assert.assertTrue(elementchoice.isEnabled(), "dates enabled");

				} else {
					System.out.println("Selected dates are disabled");
				}
			}

			// Week Starts from Sunday
			String[] week = { "Su" };
			int k = 0;

			List<WebElement> daynames = driver.findElements(By.xpath("//thead//tr[3]//th"));
			for (WebElement dayname2 : daynames) {
				String[] names = dayname2.getText().split("");
				List weeklist = Arrays.asList(week);

				if (weeklist.contains(names)) // finding the present name in Array
				{
					k++;
					Assert.assertEquals(names, "Su");
				}
			}
			System.out.println("Week Starts from Sunday");

			// Selected Date will be displayed in both fields.
			DatePick.pickdate.click();

			String start = DatePick.startdate.getAttribute("value");
			String end = DatePick.enddate.getAttribute("value");
			Assert.assertTrue(start.contains(start));
			Assert.assertTrue(end.contains(end));
			System.out.println("Both fields populated");

			Thread.sleep(1000);
			// Start date should be less than end date
			DatePick.startdate.click();
			DatePick.date1.click();
			DatePick.enddate.click();
			DatePick.date2.click();

			String d1 = DatePick.startdate.getAttribute("value");
			String d2 = DatePick.enddate.getAttribute("value");

			if (d1.compareTo(d2) > 0) {
				Assert.assertNotEquals(d1, d2);
				System.out.println("Date 1 is greater than Date 2");
			} else if (d1.compareTo(d2) < 0) {
				Assert.assertNotEquals(d1, d2);
				System.out.println("Date 1 is less than Date 2");
			} else if (d1.compareTo(d2) == 0) {
				Assert.assertEquals(d1, d2);
				System.out.println("Both dates are equal");

			}

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 2)
	public void jqeuryDatepicker() throws InterruptedException {
		try {
			DatepickerPageObject DatePick = new DatepickerPageObject(driver);

			DatePick.goToJqueryDatepicker();
			System.out.println("\nDate Range Picker:\n");
			// Table consisting of two TextBoxes
			Assert.assertTrue(DatePick.fromDate.isDisplayed());
			Assert.assertTrue(DatePick.toDate.isDisplayed());
			System.out.println("Date range picker textboxes are here");

			// Start Date should be less than End date
			DatePick.fromDate.click();
			DatePick.fromDatePick.click();
			DatePick.toDate.click();
			DatePick.toDatePick.click();

			String fromD1 = DatePick.fromDate.getAttribute("value");
			String toD1 = DatePick.toDate.getAttribute("value");

			if (fromD1.compareTo(toD1) > 0) {
				Assert.assertNotEquals(fromD1, toD1);
				System.out.println("Date 1 is greater than Date 2");
			} else if (fromD1.compareTo(toD1) < 0) {
				Assert.assertNotEquals(fromD1, toD1);
				System.out.println("Date 1 is less than Date 2");
			} else if (fromD1.compareTo(toD1) == 0) {
				Assert.assertEquals(fromD1, toD1);
				System.out.println("Both dates are equal");

			}

			// Start Date and the dates before the Start Date disabled in the End Date
			Thread.sleep(1000);

			DatePick.fromDate.click();
			DatePick.Pickdate10.click();
			DatePick.toDate.click();

			By disabledDates = By.xpath("//span[@class='ui-state-default']");
			List<WebElement> disablecounts = driver.findElements(By.xpath("//span[@class='ui-state-default']"));
			java.util.List<WebElement> disdates = driver.findElements(disabledDates);
			int count = 0;
			for (WebElement elements : disdates) {
				if (elements.isDisplayed()) {
					count++;
				}
			}

			Assert.assertEquals(count, disablecounts.size());
			System.out.println("The dates before the Start Date are disabled in the End Date");

			// End Date and the dates after the End Date disabled in the Start Date
			Thread.sleep(1000);

			DatePick.toDate.click();
			DatePick.Pickdate20.click();
			DatePick.fromDate.click();

			By disableFrom = By.xpath("//span[@class='ui-state-default']");
			List<WebElement> disableCountFrom = driver.findElements(By.xpath("//span[@class='ui-state-default']"));
			java.util.List<WebElement> disFrom = driver.findElements(disableFrom);
			int fromCount = 0;
			for (WebElement elementFrom : disFrom) {
				if (elementFrom.isDisplayed()) {
					fromCount++;
				}
			}
			Assert.assertEquals(fromCount, disableCountFrom.size());
			System.out.println("The dates after the End Date are disabled in the Start Date");

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
