package mikko.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import mikko.pageobjects.InputformPageObject;
import testBase.TestBase;

public class InputForms extends TestBase {

	// public static void main(String[] args) {
	// TODO Auto-generated method stub

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void simpleForm() throws InterruptedException {

		try {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			// simple form 1
			InputformPageObject InputPage = new InputformPageObject(driver);

			InputPage.goToSimple();
			System.out.println("\nSingle Input Field:\n");
			InputPage.usermessage.sendKeys("hello");
			InputPage.showmessage.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("display")));
			String confirmMessage = InputPage.display.getText();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("hello"));
			System.out.println(InputPage.display.getText());
			// simple form 2
			System.out.println("\nTwo Input Fields:\n");

			int a = 1;
			int b = 2;
			int sum = a + b;
			InputPage.value1.sendKeys(String.valueOf(a));
			InputPage.value2.sendKeys(String.valueOf(b));
			InputPage.gettotal.click();

			Assert.assertEquals(InputPage.sumValue.getText(), String.valueOf(sum));
			System.out.println(InputPage.displayvalue.getText());

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test(priority = 2)
	public void checkboxForm() throws InterruptedException {

		try {

			InputformPageObject InputPage = new InputformPageObject(driver);

			// single chechbox

			InputPage.goTocheckbox();
			System.out.println("\nSingle Checkbox Demo:\n");
			InputPage.check.click();
			String confirmMessage = InputPage.successcheckbox.getText();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("Success - Check box is checked"));
			System.out.println(InputPage.successcheckbox.getText());

			// multiple checkbox
			System.out.println("\nMultiple Checkbox Demo:\n");
			String uncheck = "Uncheck All";
			InputPage.checkall.click();
			By checkboxes = By.xpath("//div//input[@class='cb1-element']");
			List<WebElement> boxes = driver.findElements(checkboxes);
			for (WebElement checkbox : boxes) {
				Assert.assertTrue(checkbox.isSelected());
			}
			Assert.assertTrue(InputPage.uncheckall.isDisplayed());
			String confirmcheckbox = InputPage.uncheckall.getAttribute("value");
			if (confirmcheckbox.equals(uncheck)) {
				System.out.println("Button shows Uncheckall");
			} else {
				System.out.println("Button don't shows Uncheckall");
			}

			String check = "Check All";
			InputPage.option2.click();
			Assert.assertTrue(InputPage.checkall.isDisplayed());
			String confirmcheck = InputPage.checkall.getAttribute("value");
			if (confirmcheck.equals(check)) {
				System.out.println("Button shows checkall");
			} else {
				System.out.println("Button don't shows checkall");
			}

			Thread.sleep(3000);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 3)
	public void radioButtons() throws InterruptedException {

		try {

			InputformPageObject InputPage = new InputformPageObject(driver);

			// radiobutton demo

			InputPage.goToradiobutton();
			System.out.println("\nRadio Button Demo:\n");
			InputPage.Male1.click();
			InputPage.getvalue1.click();
			String confirmradiobutton = InputPage.radiocheck.getText();
			Assert.assertTrue(confirmradiobutton.equalsIgnoreCase("Radio button 'Male' is checked"));
			System.out.println(InputPage.radiocheck.getText());

			// group radiobutton demo
			System.out.println("\nGroup Radio Buttons Demo:\n");
			InputPage.Male2.click();
			InputPage.agegroup.click();
			InputPage.getvalue2.click();
			String innerHTML = InputPage.groupradiocheck.getAttribute("innerHTML");
			String[] paragraph = innerHTML.split("<br>");

			String Sex = paragraph[0];
			String Age = paragraph[1];
			Assert.assertTrue(Sex.equalsIgnoreCase("Sex : Male"));
			Assert.assertTrue(Age.equalsIgnoreCase(" Age group: 15 - 50"));

			System.out.println(Sex);
			System.out.println(Age);

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 4)
	public void dropDown() throws InterruptedException {

		try {

			InputformPageObject InputPage = new InputformPageObject(driver);

			// select list demo

			InputPage.goTodropdown();
			String day = "Saturday";
			System.out.println("\nSelect List Demo:\n");
			InputPage.selectdropdown.click();
			WebElement daySelect = driver.findElement(By.xpath("//option[@value='" + day + "']"));
			daySelect.click();
			String confirmday = InputPage.dayselected.getText();
			Assert.assertTrue(confirmday.equalsIgnoreCase("Day selected :- " + day));
			System.out.println(InputPage.dayselected.getText());

			// multi select list demo
			System.out.println("\nMulti Select List Demo:\n");
			InputPage.Ohioselected.click();
			InputPage.Firstselected.click();
			String confirmselected = InputPage.showselected.getText();
			Assert.assertTrue(confirmselected.equalsIgnoreCase("First selected option is : Ohio"));
			System.out.println(InputPage.showselected.getText());

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 5)
	public void inputForm() throws InterruptedException, IOException {
		try {

			InputformPageObject InputPage = new InputformPageObject(driver);
			dataDriven d = new dataDriven();
			ArrayList data = d.getData("Testdata First");

			InputPage.goToinputform();

			System.out.println("\nInput form with validations:\n");

			InputPage.send.click();
			By invalidValue = By.xpath("//small[@data-bv-result='INVALID']");
			List<WebElement> invalids = driver.findElements(invalidValue);
			int value = 0;
			for (WebElement invalid : invalids) {
				if (invalid.isDisplayed()) {
					value++;
				}
			}
			Assert.assertEquals(value, invalids.size());
			System.out.println("Form can't send blank details");

			for (int i = 1; i <= 8; i++) {
				By inputGroup = By.xpath("(//div[@class='input-group']//input)[" + i + "]");
				WebElement inputField = driver.findElement(inputGroup);
				inputField.sendKeys(data.get(i).toString());
			}

			InputPage.state.click();
			InputPage.statechoice.click();
			InputPage.Nohosting.click();
			InputPage.comment.sendKeys(data.get(9).toString());

			// first attempt on sendkeys from excel via unique element
			/*
			 * InputPage.firstname.sendKeys(data.get(1).toString());
			 * InputPage.lastname.sendKeys(data.get(2).toString());
			 * InputPage.email.sendKeys(data.get(3).toString());
			 * InputPage.phonenumber.sendKeys(data.get(4).toString());
			 * InputPage.address.sendKeys(data.get(5).toString());
			 * InputPage.city.sendKeys(data.get(6).toString());
			 * InputPage.zip.sendKeys(data.get(7).toString());
			 * InputPage.website.sendKeys(data.get(8).toString());
			 */

			Thread.sleep(2000);

			By elementlocate = By.xpath("//div[@class='form-group has-feedback has-success']");
			List<WebElement> elements = driver.findElements(elementlocate);
			int count = 0;
			for (WebElement element : elements) {
				if (element.isDisplayed()) {
					count++;
				}
			}
			Assert.assertEquals(count, elements.size());
			System.out.println("textboxes are filled");
			InputPage.send.click();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 6)
	public void AjaxForm() throws InterruptedException {

		try {
			InputformPageObject InputPage = new InputformPageObject(driver);

			InputPage.goToAjaxform();
			System.out.println("\nAjax Form Submit with Loading icon:\n");
			InputPage.Nameinput.sendKeys("Mikko");
			InputPage.Commentinput.sendKeys("Testing Testing");
			InputPage.submitbutton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='submit-control']"),
					"Form submited Successfully!"));
			String formsubmit = InputPage.successsubmit.getText();
			Assert.assertEquals(formsubmit, "Form submited Successfully!");
			System.out.println("Ajax Form submited successfully");

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test(priority = 7)
	public void JqueryForm() throws InterruptedException {

		try {
			InputformPageObject InputPage = new InputformPageObject(driver);

			// Drop Down with Search box

			InputPage.goToJqueryform();
			System.out.println("\nDrop Down with Search box:\n");
			String country = "Japan";
			InputPage.selectcountry.click();
			InputPage.countrydropdown.sendKeys(country);
			driver.findElement(By.xpath("//li[@role='treeitem'][contains(text(),'" + country + "')]")).click();
			String countryvalue = InputPage.selectcountry.getText();
			Assert.assertEquals("Japan", countryvalue);
			System.out.println(countryvalue + " is selected");

			// Select Multiple Values
			System.out.println("\nSelect Multiple Values:\n");
			InputPage.selectestate.sendKeys("Alaska");
			InputPage.selectestate.sendKeys(Keys.ENTER);
			InputPage.selectestate.sendKeys("Florida");
			InputPage.selectestate.sendKeys(Keys.ENTER);
			InputPage.selectestate.sendKeys("Colorado");
			InputPage.selectestate.sendKeys(Keys.ENTER);

			By selectchoice = By.xpath("//li[@class='select2-selection__choice']");
			List<WebElement> choices = driver.findElements(selectchoice);
			int count = 0;
			for (WebElement elementchoice : choices) {
				if (elementchoice.isDisplayed()) {
					count++;
				}
			}

			Assert.assertEquals(count, choices.size());
			System.out.println("States are selected");

			// Drop Down with Disabled values
			System.out.println("\nDrop Down with Disabled values:\n");
			InputPage.selectterritory.click();
			String selectTerritory = "Guam";
			InputPage.terrtorydropdown.sendKeys(selectTerritory);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement territory = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + selectTerritory + "']")));
			String ariaDisabled = territory.getAttribute("aria-disabled");
			String ariaSelected = territory.getAttribute("aria-selected");

			if ("true".equals(ariaDisabled)) {
				Assert.assertTrue(ariaDisabled.equalsIgnoreCase("true"));
				System.out.println(selectTerritory + " option is Disabled");
			} else if ("false".equals(ariaSelected)) {
				Assert.assertTrue(ariaSelected.equalsIgnoreCase("false"));
				System.out.println(selectTerritory + " option is Enabled'");
			}

			// Drop-down with Category related options
			System.out.println("\nDrop-down with Category related options:\n");
			String file = "C";
			InputPage.selectfile.click();
			WebElement selected = driver.findElement(By.xpath("//option[text()='" + file + "']"));
			selected.click();
			String selectedText = selected.getText();
			Actions a = new Actions(driver);
			a.click().build().perform();
			WebElement category = driver.findElement(By.xpath("//option[text()='" + file + "']//parent::optgroup"));
			String categoryText = category.getAttribute("label");
			Assert.assertEquals(file, selectedText, "Selected file is not equal");
			System.out.println(file + " is under " + categoryText + " category");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
