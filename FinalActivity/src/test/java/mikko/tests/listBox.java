package mikko.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import mikko.pageobjects.listBoxPageObject;
import testBase.TestBase;

public class listBox extends TestBase {

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void bootstrapListbox() throws InterruptedException {

		try {
			listBoxPageObject listBox = new listBoxPageObject(driver);

			String[] listItems = { "Morbi leo risus", "Vestibulum at eros" };
			List<String> Items = Arrays.asList(listItems);
			listBox.goTobootstrapListbox();
			System.out.println("\nDual List Box Example:\n");
			List<WebElement> listboxTwoFirst = driver.findElements(By.xpath("(//ul[@class='list-group'])[2]//li"));
			for (String itemText : Items) {
				driver.findElement(By.xpath("(//ul//li[text()='" + itemText + "'])[1]")).click();

			}

			listBox.rightButton.click();
			Thread.sleep(1000);
			List<WebElement> listboxTwo = driver.findElements(By.xpath("(//ul[@class='list-group'])[2]//li"));

			// this For loop print twice because of the Items it finds in the listboxTwo
			// have duplicates
			/*
			 * for(WebElement list : listboxTwo) { String listText = list.getText();
			 * if(Items.contains(listText)) { System.out.println(listText +
			 * "has been moved to the right listbox"); } }
			 */

			for (String itemText : Items) {
				if (driver.findElement(By.xpath("(//ul//li[text()='" + itemText + "'])[2]")).isDisplayed()) {
					System.out.println(itemText + " has been moved to the right listbox");
				}
			}

			if (listboxTwo.size() > listboxTwoFirst.size()) {
				Assert.assertNotEquals(listboxTwo.size(), listboxTwoFirst.size());
				System.out.println("Right ListBox count increase");
			} else {
				System.out.println("Right ListBox count nothing happened");
			}

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 2)
	public void dataListFilter() throws InterruptedException {
		try {
			listBoxPageObject listFilter = new listBoxPageObject(driver);

			listFilter.goTodataListFilter();
			System.out.println("\nData List Filter:\n");
			String data = "shizzle";
			listFilter.searchFilter.sendKeys(data);
			int value = driver.findElements(By.xpath("//*[contains(text(), '" + data + "')]//parent::div")).size();
			List<WebElement> searched = driver
					.findElements(By.xpath("//*[contains(text(), '" + data + "')]//parent::div"));

			int elementCount = 0;
			for (WebElement search : searched) {
				if (search.isDisplayed()) {
					elementCount++;
				}
			}
			Assert.assertEquals(value, elementCount);
			System.out.println(elementCount + " Data have shown");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
