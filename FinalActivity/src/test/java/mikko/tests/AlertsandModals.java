package mikko.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import mikko.pageobjects.AlertsandModalsPageObject;
import testBase.TestBase;

public class AlertsandModals extends TestBase {

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void bootstrapAlert() throws InterruptedException {

		try {
			AlertsandModalsPageObject Alert = new AlertsandModalsPageObject(driver);

			// Bootstrap Alert messages

			Alert.goTobootstrapAlert();
			System.out.println("\nBootstrap Alert messages:\n");
			By allButtons = By.xpath("//div[@class='col-md-4']//button");
			List<WebElement> Buttons = driver.findElements(allButtons);
			for (WebElement button : Buttons) {
				button.click();
			}

			for (WebElement button : Buttons) {
				Assert.assertTrue(button.isDisplayed());
			}

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			String autoclose = "autocloseable";
			By autoclosemessages = By.xpath("//*[contains(text(), '" + autoclose + "')]");
			List<WebElement> autoCloseShows = driver.findElements(autoclosemessages);

			for (WebElement autoClose : autoCloseShows) {
				if (autoClose.isDisplayed()) {
					wait.until(ExpectedConditions.invisibilityOfAllElements(autoCloseShows));
					Assert.assertFalse(autoClose.isDisplayed());
					System.out.println("alert messages shows and automatically close");
				}

			}

			By closeButtons = By.xpath("//div[@class='col-md-6']//button");
			List<WebElement> xButtons = driver.findElements(closeButtons);
			List<WebElement> closes = wait.until(ExpectedConditions.visibilityOfAllElements(xButtons));
			for (WebElement close : closes) {
				if (close.isDisplayed()) {
					close.click();
					System.out.println("alert messages shows and need to click close buttons");
					Assert.assertTrue(!close.isDisplayed());
				}
			}

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 2)
	public void bootstrapModal() throws InterruptedException {
		try {
			AlertsandModalsPageObject Modal = new AlertsandModalsPageObject(driver);

			Modal.goTobootstrapModal();
			System.out.println("\nSingle Modal Example:\n");
			// Single Modal Example
			Modal.launchButton1.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement modalShow = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content'])[1]")));
			Assert.assertTrue(modalShow.isDisplayed(), "Modal is not in display");
			System.out.println("Modal is in display");
			Modal.modalButton.click();

			// Multiple Modal Example
			System.out.println("\nMultiple Modal Example:\n");
			Modal.launchButton2.click();
			WebElement modalShow2 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content'])[2]")));
			Assert.assertTrue(modalShow2.isDisplayed(), "Modal is not in display");
			System.out.println("First Modal is in display");
			Modal.launchButton3.click();
			WebElement modalShow3 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content'])[3]")));
			Assert.assertTrue(modalShow3.isDisplayed(), "Modal is not in display");
			System.out.println("Second Modal is in display");
			Modal.closeButton3.click();
			Modal.modalButton2.click();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 3)
	public void windowPopupModal() throws InterruptedException {
		try {
			AlertsandModalsPageObject Window = new AlertsandModalsPageObject(driver);
			Window.goTowindowPopupModal();
			// Single Window Popup
			System.out.println("\nSingle Window Popup:\n");
			Window.twitterButton.click();

			Set<String> windows = driver.getWindowHandles();
			Iterator<String> iterate = windows.iterator();

			if (iterate.hasNext()) {
				String firstPage = iterate.next();
				String firstModal = iterate.next();

				driver.switchTo().window(firstModal);
				String twitter = driver.getCurrentUrl();
				Assert.assertEquals(twitter,
						"https://twitter.com/i/flow/login?redirect_after_login=%2Fintent%2Ffollow%3Fscreen_name%3Dseleniumeasy");
				System.out.println("Twitter link - " + twitter);

				driver.close();
				driver.switchTo().window(firstPage);
			}

			Window.facebookButton.click();
			iterate = driver.getWindowHandles().iterator();

			if (iterate.hasNext()) {

				String SecondPage = iterate.next();
				String SecondModal = iterate.next();
				driver.switchTo().window(SecondModal);
				String FB = driver.getCurrentUrl();
				Assert.assertEquals(FB, "https://www.facebook.com/seleniumeasy");
				System.out.println("Facebook link - " + FB);

				driver.close();
				driver.switchTo().window(SecondPage);
			}

			// Multiple Window Modal
			System.out.println("\nMultiple Window Modal:\n");
			Window.twitterandfacebookButton.click();

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();
			int windowCount = windowHandles.size() - 1;
			Assert.assertEquals(windowCount, 2);
			List<String> popupUrls = new ArrayList<>();
			for (String windowHandle : windowHandles) {
				if (!windowHandle.equals(mainWindowHandle)) {
					driver.switchTo().window(windowHandle);
					popupUrls.add(driver.getCurrentUrl());
					driver.close();
				}
			}

			driver.switchTo().window(mainWindowHandle);

			Window.followAll.click();

			windowHandles = driver.getWindowHandles();
			int windowCounts = windowHandles.size() - 1;
			Assert.assertEquals(windowCounts, 3);
			List<String> threePopupUrls = new ArrayList<>();
			for (String windowHandle : windowHandles) {
				if (!windowHandle.equals(mainWindowHandle)) {
					driver.switchTo().window(windowHandle);
					threePopupUrls.add(driver.getCurrentUrl());
					driver.close();
				}
			}

			Thread.sleep(3000);

			System.out.println("\nURLs of the first two pop-up windows:\n");
			;
			for (String url : popupUrls) {
				System.out.println(url);
			}
			System.out.println("\nURLs of the three new pop-up windows:\n");
			for (String url : threePopupUrls) {
				System.out.println(url);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
