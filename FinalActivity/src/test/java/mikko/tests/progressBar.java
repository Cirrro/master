package mikko.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import mikko.pageobjects.progressBarPageObject;
import testBase.TestBase;

public class progressBar extends TestBase {

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void jqueryProgressBar() throws InterruptedException {
		try {
			progressBarPageObject jUI = new progressBarPageObject(driver);

			// Download Dialog

			jUI.goToProgressBar();
			System.out.println("\nJQuery UI Progress bar - Download Dialog:\n");
			jUI.downloadButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			Assert.assertTrue(jUI.downloadDialog.isDisplayed(), "Download Dialog is not in Display");
			boolean progress = wait.until((ExpectedConditions.attributeToBe(jUI.progressBar, "aria-valuenow", "100")));
			if (progress == true) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Close']"))).click();
			}
			Assert.assertTrue(progress, "Error");
			System.out.println("File Download Complete!");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 2)
	public void bootstrapProgressBar() throws InterruptedException {

		try {
			progressBarPageObject boot = new progressBarPageObject(driver);

			// Stylish progress bar demo
			boot.goToBootstrapProgressBar();
			System.out.println("\nProgress Bar for Download:\n");
			boot.clickDownload.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			boolean downloadprogress = wait
					.until(ExpectedConditions.textToBe(By.xpath("//div[@class='percenttext']"), "100%"));
			Assert.assertTrue(downloadprogress, "Error Download");
			System.out.println("File Download Complete!");

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 3)
	public void dragAndDrop() throws InterruptedException {

		try {
			progressBarPageObject DnD = new progressBarPageObject(driver);

			DnD.goTodragAndDrop();
			System.out.println("\nRange Sliders:\n");
			String positionOne = DnD.rangeOne.getText();
			String valueOne = DnD.rangeTwo.getText();
			String locationOne = DnD.rangeThree.getText();
			String axisOne = DnD.rangeFour.getText();
			String latitudeOne = DnD.rangeFive.getText();
			String pointOne = DnD.rangeFive.getText();

			// Using Action class for drag and drop.
			Actions act = new Actions(driver);
			act.dragAndDropBy(DnD.sliderOne, 60, 0).build().perform();
			String positionTwo = DnD.rangeOne.getText();
			Assert.assertFalse(positionOne.equals(positionTwo));
			System.out.println("Slider One - position has changed to " + positionTwo);
			act.dragAndDropBy(DnD.sliderTwo, 10, 0).build().perform();
			String valueTwo = DnD.rangeOne.getText();
			Assert.assertFalse(valueOne.equals(valueTwo));
			System.out.println("Slider Two - position has changed to " + valueTwo);
			act.dragAndDropBy(DnD.sliderThree, 50, 0).build().perform();
			String locationTwo = DnD.rangeThree.getText();
			Assert.assertFalse(locationOne.equals(locationTwo));
			System.out.println("Slider Three - position has changed to " + locationTwo);
			act.dragAndDropBy(DnD.sliderFour, 30, 0).build().perform();
			String axisTwo = DnD.rangeFour.getText();
			Assert.assertFalse(axisOne.equals(axisTwo));
			System.out.println("Slider Four - position has changed to " + axisTwo);
			act.dragAndDropBy(DnD.sliderFive, 90, 0).build().perform();
			String latitudeTwo = DnD.rangeFive.getText();
			Assert.assertFalse(latitudeOne.equals(latitudeTwo));
			System.out.println("Slider Five - position has changed to " + latitudeTwo);
			act.dragAndDropBy(DnD.sliderSix, 100, 0).build().perform();
			String pointTwo = DnD.rangeFive.getText();
			Assert.assertFalse(pointOne.equals(pointTwo));
			System.out.println("Slider Five - position has changed to " + pointTwo);

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
