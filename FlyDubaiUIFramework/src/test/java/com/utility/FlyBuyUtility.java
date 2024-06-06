package com.utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.InputStream;

import java.time.Duration;

import java.util.List;

import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FlyBuyUtility {

	public static WebDriver driver;

	String propertyFileName;

	Properties inputProperties;

	String currentWorkingDirectory;

	public String url, depLoc, arrLoc, retrnDepLoc, retrnArrLoc, depDate, depArrDate, retrnDate, retrnArrDate, cabin,
			depflightName,

			arrFlightName, pass1FirstName, pass1LastName, pass1EmailAddress, pass1MobCode, pass1MobNum, pass2FirstName,

			pass2LastName, dobPass2;

	public int adltPassengerCount, childPassengerCount, infantPassengerCount;

	@BeforeClass

	public void setUp() throws IOException {

		currentWorkingDirectory = System.getProperty("user.dir");

		propertyFileName = currentWorkingDirectory + "/src/test/resources/properties/input.properties";

		inputProperties = readPropertiesFile(propertyFileName);

		url = inputProperties.getProperty("url");

		depLoc = inputProperties.getProperty("depLoc");

		arrLoc = inputProperties.getProperty("arrLoc");

		retrnDepLoc = inputProperties.getProperty("retrnDepLoc");

		retrnArrLoc = inputProperties.getProperty("retrnArrLoc");

		depDate = inputProperties.getProperty("depDate");

		depArrDate = inputProperties.getProperty("depArrDate");

		retrnDate = inputProperties.getProperty("retrnDate");

		retrnArrDate = inputProperties.getProperty("retrnArrDate");

		adltPassengerCount = Integer.parseInt(inputProperties.getProperty("adltPassengerCount"));

		childPassengerCount = Integer.parseInt(inputProperties.getProperty("childPassengerCount"));

		infantPassengerCount = Integer.parseInt(inputProperties.getProperty("infantPassengerCount"));

		cabin = inputProperties.getProperty("cabin");

		depflightName = inputProperties.getProperty("depflightName");

		arrFlightName = inputProperties.getProperty("arrFlightName");

		pass1FirstName = inputProperties.getProperty("pass1FirstName");

		pass1LastName = inputProperties.getProperty("pass1LastName");

		pass1EmailAddress = inputProperties.getProperty("pass1EmailAddress");

		pass1MobCode = inputProperties.getProperty("pass1MobCode");

		pass1MobNum = inputProperties.getProperty("pass1MobNum");

		pass2FirstName = inputProperties.getProperty("pass2FirstName");

		pass2LastName = inputProperties.getProperty("pass2LastName");

		dobPass2 = inputProperties.getProperty("dobPass2");

		ChromeLaunch();

		urlLaunch(url);

	}

	@AfterClass

	public void teardown() {

		driver.quit();

	}

	public static Properties readPropertiesFile(String fileName) throws IOException {

		FileInputStream fis = null;

		Properties prop = null;

		try {

			fis = new FileInputStream(fileName);

			prop = new Properties();

			prop.load(fis);

		} catch (FileNotFoundException fnfe) {

			fnfe.printStackTrace();

		} catch (IOException ioe) {

			ioe.printStackTrace();

		} finally {

			fis.close();

		}

		return prop;

	}

	public void ChromeLaunch() {

		WebDriverManager.chromedriver().clearDriverCache().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	public void implicitWait(int seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	public void urlLaunch(String url) {

		driver.get(url);

	}

	public static void travelDateSelector(String date) throws InterruptedException {

		String[] split = date.split(" ");

		int day = Integer.parseInt(split[0]);

		for (int i = 0; i < 2; i++) {

			Boolean dateSelected = false;

			List<WebElement> selectedMonths = driver.findElements(By.xpath(

					"//section[@class='lightpick__month']//select[contains(@class,'months')]/option[@selected='selected']"));

			for (int j = 0; j < selectedMonths.size(); j++) {

				if (selectedMonths.get(j).getText().equals(split[1])) {

					dateSelected = true;

					Thread.sleep(5000);

					driver.findElement(By.xpath("(//section[@class='lightpick__month'])[1+" + j

							+ "]//div[contains(@class,'lightpick__day is-available')][contains(text(),'" + day + "')]"))

							.click();

					break;

				} else if ((j == selectedMonths.size() - 1) && !(selectedMonths.get(j).getText().equals(split[1]))) {

					driver.findElement(By.xpath("(//button[@class='lightpick__next-action'])[2]")).click();

				}

			}

			if (dateSelected) {

				System.out.println("Travel Date Selected as : " + date);

				break;

			}

		}

	}

	public void stopWebDriver(long milliSec) throws InterruptedException {

		Thread.sleep(milliSec);

	}

	public void javaScriptClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}

	public WebElement waitUntilElementToBeClick(int seconds, By loc) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		return wait.until(ExpectedConditions.elementToBeClickable(loc));

	}

	public Boolean waitUntilInvisibilityOfElement(int seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		return wait.until(ExpectedConditions.invisibilityOf(element));

	}

	public WebElement waitUntilVisibilityOfElementLoc(int seconds, By loc) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));

	}

	public WebElement waitUntilVisibilityOf(int seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	public String javaScriptGetText(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		return js.executeScript("return arguments[0].text", element).toString();

	}

	public void passengerSelectionAdult(int adltPassengerCount, By plusBtn, By minusBtn) {

		for (int i = 0; i <= adltPassengerCount; i++) {

			if ((i + 1) < adltPassengerCount) {

				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

				WebElement plsBtnAdult = wait1.until(ExpectedConditions.presenceOfElementLocated(plusBtn));

				plsBtnAdult.click();

				// driver.findElement(By.xpath("//div[@class='plus adult']")).click();

			} else if (i == adltPassengerCount) {

				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

				WebElement minusBtnAdult = wait2.until(ExpectedConditions.presenceOfElementLocated(minusBtn));

				minusBtnAdult.click();

				// driver.findElement(By.xpath("//div[@class='minus adult']")).click();

			} else {

				break;

			}

		}

	}

	public void childOrInfantSelection(int passengerCount, By locator) {

		for (int i = 0; i <= passengerCount; i++) {

			if (i < passengerCount) {

				WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

				WebElement plsBtnChild = wait3.until(ExpectedConditions.presenceOfElementLocated(locator));

				// Thread.sleep(3000);

				plsBtnChild.click();

				// driver.findElement(By.xpath("//div[@class='plus child']")).click();

			} else {

				break;

			}

		}

	}

}