package mikko.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import mikko.pageobjects.TablePageObject;
import testBase.TestBase;

public class Table extends TestBase {

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void tablePagination() throws InterruptedException {
		try {
			TablePageObject Table = new TablePageObject(driver);

			Table.goToTablePagination();
			System.out.println("\nTable with Pagination Example:\n");

			// each page has max 5 records

			int tablerowCount = driver
					.findElements(By.xpath("//tbody[@id='myTable']//tr[@style='display: table-row;']")).size();
			Assert.assertEquals(tablerowCount, 5, "Table records is not equal to 5");
			System.out.println("Table record per page is " + tablerowCount);

			Thread.sleep(1000);

			// Second Page will have both Prev and Next buttons enabled to navigate

			Table.pageTwo.click();
			Table.prevButton.click();
			Table.nextButton.click();
			Thread.sleep(2000);
			Assert.assertTrue(Table.prevButton.isDisplayed(), "Prev button is not working");
			System.out.println("Prev button is enable to navigate");
			Assert.assertTrue(Table.nextButton.isDisplayed(), "Next button is not working");
			System.out.println("Next button is enable to navigate");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 2)
	public void dataSearch() throws InterruptedException {
		try {
			TablePageObject Search = new TablePageObject(driver);

			Search.goToTableDataSearch();
			System.out.println("\nTasks:\n");
			// Type in your search to filter data by Tasks / Assignee / Status
			String dataText = "in progress";
			Search.searchFilter.sendKeys(dataText);
			WebElement tableBody = driver.findElement(By.xpath("//table[@id='task-table']/tbody"));
			List<WebElement> counts = tableBody.findElements(By.xpath(".//td[text()='" + dataText + "']"));
			int add = 0;
			for (WebElement count : counts) {
				if (count.isDisplayed()) {
					add++;
				}
			}

			if (tableBody.findElements(By.xpath(".//td[text()='" + dataText + "']")).size() > 0) {
				Assert.assertEquals(tableBody.findElements(By.xpath(".//td[text()='" + dataText + "']")).size(), add);
				System.out.println(tableBody.findElements(By.xpath(".//td[text()='" + dataText + "']")).size() + " "
						+ dataText + " is displayed in the column ");
			} else {
				System.out.println(dataText + " is NOT displayed in the column ");
			}

			System.out.println("\nListed Users:\n");
			// Click the filter icon to activate column filters inputs ()
			Search.filterButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(Search.filterBoxes));
			Assert.assertTrue(Search.filterBoxes.isEnabled(), "Filter box are not Enable");
			System.out.println("filter box is Enabled");

			Search.numFilter.sendKeys("2");
			Thread.sleep(1000);
			Search.numFilter.clear();
			Search.userFilter.sendKeys("mikesali");
			Thread.sleep(1000);
			Search.userFilter.clear();
			Search.firstnameFilter.sendKeys("Zieko");
			Thread.sleep(1000);
			Search.firstnameFilter.clear();
			Search.lastnameFilter.sendKeys("Dimarison");
			Thread.sleep(1000);
			Search.lastnameFilter.clear();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 3)
	public void tableFilterDemo() throws InterruptedException {
		try {
			TablePageObject Filter = new TablePageObject(driver);

			Filter.goToTableFilterDemo();
			System.out.println("\nTable Filter Demo:\n");
			Filter.greenButton.click();
			List<WebElement> greens = driver.findElements(By.xpath("//tr[@data-status='pagado']"));
			int greenCount = 0;
			for (WebElement green : greens) {
				if (green.isDisplayed()) {
					greenCount++;
				}
			}
			Assert.assertTrue(driver.findElement(By.xpath("//tr[@data-status='pagado']")).isDisplayed(),
					"green not displayed");
			System.out.println(greenCount + " Green records are displayed");

			Filter.orangeButton.click();
			List<WebElement> oranges = driver.findElements(By.xpath("//tr[@data-status='pendiente']"));
			int orangeCount = 0;
			for (WebElement orange : oranges) {
				if (orange.isDisplayed()) {
					orangeCount++;
				}
			}
			Assert.assertTrue(driver.findElement(By.xpath("//tr[@data-status='pendiente']")).isDisplayed(),
					"orange not displayed");
			System.out.println(orangeCount + " Orange records are displayed");

			Filter.redButton.click();
			List<WebElement> reds = driver.findElements(By.xpath("//tr[@data-status='cancelado']"));
			int redCount = 0;
			for (WebElement red : reds) {
				if (red.isDisplayed()) {
					redCount++;
				}
			}
			Assert.assertTrue(driver.findElement(By.xpath("//tr[@data-status='cancelado']")).isDisplayed(),
					"red not displayed");
			System.out.println(redCount + " red records are displayed");

			Filter.allButton.click();
			Thread.sleep(2000);
			List<WebElement> colors = driver.findElements(By.xpath("//tbody/tr"));
			int count = 0;
			for (WebElement color : colors) {
				if (color.isDisplayed()) {
					count++;
				}
			}

			Assert.assertEquals(count, colors.size());
			System.out.println(count + " All records are displayed");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 4)
	public void tableSortAndSearch() throws InterruptedException {
		try {
			TablePageObject SnS = new TablePageObject(driver);

			Actions a = new Actions(driver);
			SnS.goToTableSortandSearchDemo();
			System.out.println("\nTable Sort And Search Demo:\n");
			a.moveToElement(SnS.nameSort).doubleClick().build().perform();

			// Name Sort
			List<WebElement> nameList = driver.findElements(By.xpath("//tbody//tr/td[1]"));
			List<Object> originalList = nameList.stream().map(s -> s.getText()).collect(Collectors.toList());
			List<Object> sortedList = originalList.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(originalList.equals(sortedList), "Name are not Equal");
			System.out.println("Name are Sorted");

			// Position Sort
			SnS.positionSort.click();
			List<WebElement> positionList = driver.findElements(By.xpath("//tbody//tr/td[2]"));
			List<Object> positionOriginalList = positionList.stream().map(s -> s.getText())
					.collect(Collectors.toList());
			List<Object> positionSortedList = positionOriginalList.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(positionOriginalList.equals(positionSortedList), "Position are not Equal");
			System.out.println("Position are Sorted");

			// Office Sort
			SnS.officeSort.click();
			List<WebElement> officeList = driver.findElements(By.xpath("//tbody//tr/td[3]"));
			List<Object> officeOriginalList = officeList.stream().map(s -> s.getText()).collect(Collectors.toList());
			List<Object> officeSortedList = officeOriginalList.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(officeOriginalList.equals(officeSortedList), "Office are not Equal");
			System.out.println("Office are Sorted");

			// Age Sort
			SnS.ageSort.click();
			List<WebElement> ageList = driver.findElements(By.xpath("//tbody//tr/td[4]"));
			List<Object> ageOriginalList = ageList.stream().map(s -> s.getText()).collect(Collectors.toList());
			List<Object> ageSortedList = ageOriginalList.stream().sorted().collect(Collectors.toList());
			Assert.assertTrue(ageOriginalList.equals(ageSortedList), "age are not Equal");
			System.out.println("age are Sorted");

			// Date Sort
			List<WebElement> dateList = driver.findElements(By.xpath("//tbody//tr/td[5]"));
			List<Object> dateOriginalList = dateList.stream().map(s -> s.getText()).collect(Collectors.toList());
			SnS.dateSort.click();
			List<WebElement> newdateList = driver.findElements(By.xpath("//tbody//tr/td[5]"));
			List<Object> dateSortedList = newdateList.stream().map(s -> s.getText()).collect(Collectors.toList());
			Assert.assertFalse(dateOriginalList.equals(dateSortedList), "date are Equal");
			System.out.println("date are Sorted");

			// Salary Sort
			List<WebElement> salaryList = driver.findElements(By.xpath("//tbody//tr/td[6]"));
			List<Object> salaryOriginalList = salaryList.stream().map(s -> s.getText()).collect(Collectors.toList());
			SnS.salarySort.click();
			List<WebElement> newsalaryList = driver.findElements(By.xpath("//tbody//tr/td[6]"));
			List<Object> salarySortedList = newsalaryList.stream().map(s -> s.getText()).collect(Collectors.toList());
			Assert.assertFalse(salaryOriginalList.equals(salarySortedList), "salary are Equal");
			System.out.println("salary are Sorted");

			// Length filter
			SnS.lengthShow.click();
			SnS.length25.click();
			List<WebElement> nameCount = driver.findElements(By.xpath("//tbody//tr/td[1]"));
			Thread.sleep(1000);
			Assert.assertEquals(nameCount.size(), 25);
			System.out.println(nameCount.size() + " entries are showing in the table");
			Thread.sleep(1000);
			SnS.lengthShow.click();
			SnS.length50.click();
			List<WebElement> newCount = driver.findElements(By.xpath("//tbody//tr/td[1]"));
			Thread.sleep(1000);
			Assert.assertTrue(newCount.size() <= 50);
			System.out.println(newCount.size() + " entries are showing in the table");
			Thread.sleep(1000);

			// Search Filter

			String searchText = "Tokyo";
			SnS.searchBox.sendKeys(searchText);
			WebElement tableBody = driver.findElement(By.xpath("//table[@id='example']/tbody"));
			List<WebElement> searchs = tableBody.findElements(By.xpath(".//td[text()='" + searchText + "']"));
			int sr = 0;
			for (WebElement search : searchs) {
				if (search.isDisplayed()) {
					sr++;
				}
			}
			if (tableBody.findElements(By.xpath(".//td[text()='" + searchText + "']")).size() > 0) {
				Assert.assertEquals(tableBody.findElements(By.xpath(".//td[text()='" + searchText + "']")).size(), sr);
				System.out.println(tableBody.findElements(By.xpath(".//td[text()='" + searchText + "']")).size() + " "
						+ searchText + " is displayed in the column ");
			} else {
				System.out.println(searchText + " is NOT displayed in the column ");
			}

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 5)
	public void dataTableDownload() throws InterruptedException {
		try {
			TablePageObject dataTable = new TablePageObject(driver);

			dataTable.goTodataTableDownload();
			System.out.println("\nData Table with Download / Print Demo:\n");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
