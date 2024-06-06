package fly.pojo;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.utility.FlyBuyUtility;

public class FlightSelectionPage extends FlyBuyUtility {

	public static String departureDate, arrivalDate, departureDateRtrn, arrivalDateRtrn, adltDeptFare, adltReturnFare,

			childDeptFare, childReturnFares, totTaxPriceDep, totTaxPriceRetrn, departureTotalPrice, returnTotalPrice,

			totBaggagePrice, totInsurPrice, cummulativeTotal, totalExtras;

	public FlightSelectionPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='flight-departure']//div[@id='divDate']/p[contains(text(),'day')]")

	private WebElement depDate;

	@FindBy(xpath = "//div[@class='flight-arrival']//div[@id='divDate']/p[contains(text(),'day')]")

	private WebElement arrDate;

	@FindBy(xpath = "//div[@class='close-btn']")

	private WebElement closeButtonFlghtPopUp;

	@FindBy(xpath = "(//button[@class='mat-button mat-button-base'])[2]")

	private WebElement fareBrandselection;

	@FindBy(xpath = "//span[@class='mat-expansion-indicator ng-tns-c95-5 ng-trigger ng-trigger-indicatorRotate ng-star-inserted']")

	private WebElement flightDetailsArrow;

	@FindBy(xpath = "(//div[@class='repeteData_class fareBreakdownSegments ng-star-inserted'])[1]//label[@id='lblAmount']")

	private WebElement adltDepFare;

	@FindBy(xpath = "(//div[@class='repeteData_class fareBreakdownSegments ng-star-inserted'])[2]//label[@id='lblAmount']")

	private WebElement adltFareReturn;

	@FindBy(xpath = "(//div[@class='fareBreakdownSegments ng-star-inserted'])[1]//label[@id='lblAmount']")

	private WebElement childDepFare;

	@FindBy(xpath = "(//div[@class='fareBreakdownSegments ng-star-inserted'])[3]//label[@id='lblAmount']")

	private WebElement childReturnFare;

	@FindBy(xpath = "(//div[@class='fareBreakdownSegments ng-star-inserted'])[2]//label[@id='lblAmount']")

	private WebElement taxPriceDeparture;

	@FindBy(xpath = "(//div[@class='fareBreakdownSegments ng-star-inserted'])[4]//label[@id='lblAmount']")

	private WebElement taxPriceReturn;

	@FindBy(xpath = "(//div[@class='fareBreakdownSegments sector-total ng-star-inserted'])[1]//label[@id='lblAmount']")

	private WebElement totPriceDep;

	@FindBy(xpath = "(//div[@class='fareBreakdownSegments sector-total ng-star-inserted'])[2]//label[@id='lblAmount']")

	private WebElement totPriceRetrn;

	@FindBy(xpath = "//div/fz-static-label/label[contains(text(),10)]/ancestor::div[@class='fixed-labels']/preceding-sibling::div/fz-image/img")

	private WebElement additionalBagg;

	@FindBy(xpath = "(//label[text()='Sub total']/ancestor::div[@class='OE-panel-container margin-top-5 ng-star-inserted']//label)[3]")

	private WebElement subTotBaggagePrice;

	@FindBy(xpath = "//label[text()='Sub total']/ancestor::div[@class='sub-total']//fz-static-label/label[@id='lblAmount']")

	private WebElement subTotInsurancePrice;

	@FindBy(xpath = "(//label[text()='Total']/ancestor::div[@class='totalNpr']//label)[3]")

	private WebElement totalCumulativePrice;

	@FindBy(xpath = "//div/fz-link[@class='navigateToPassengerDetails ng-star-inserted']/a")

	private WebElement navigatePassdetails;

	public WebElement getFlightDetailsPopUp(String flightName) {

		return driver.findElement(By.xpath("//label[text()='" + flightName

				+ "']/ancestor::div[@class='flight-aircraft-detail-wrapper']/preceding-sibling::div//a"));

	}

	public WebElement getFlightSelector(String flightName) {

		return driver.findElement(By.xpath(

				"//label[text()='" + flightName + "']/ancestor::div[@class='flex flight-list-item item-center']"));

	}

	public WebElement getDepDate() {

		return depDate;

	}

	public WebElement getArrDate() {

		return arrDate;

	}

	public WebElement getCloseButtonFlghtPopUp() {

		return closeButtonFlghtPopUp;

	}

	public WebElement getFareBrandselection() {

		return fareBrandselection;

	}

	public WebElement getFlightDetailsArrow() {

		return flightDetailsArrow;

	}

	public WebElement getAdltDepFare() {

		return adltDepFare;

	}

	public WebElement getAdltFareReturn() {

		return adltFareReturn;

	}

	public WebElement getChildDepFare() {

		return childDepFare;

	}

	public WebElement getChildReturnFare() {

		return childReturnFare;

	}

	public WebElement getTaxPriceDeparture() {

		return taxPriceDeparture;

	}

	public WebElement getTaxPriceReturn() {

		return taxPriceReturn;

	}

	public WebElement getTotPriceDep() {

		return totPriceDep;

	}

	public WebElement getTotPriceRetrn() {

		return totPriceRetrn;

	}

	public WebElement getAdditionalBagg() {

		return additionalBagg;

	}

	public WebElement getSubTotBaggagePrice() {

		return subTotBaggagePrice;

	}

	public WebElement getSubTotInsurancePrice() {

		return subTotInsurancePrice;

	}

	public WebElement getTotalCumulativePrice() {

		return totalCumulativePrice;

	}

	public WebElement getNavigatePassdetails() {

		return navigatePassdetails;

	}

	public void flightSelection(String depFlightName, String returnFlightName, int adltPassengerCount,

			int childPassengerCount, int infantPassengerCount) throws InterruptedException {

		implicitWait(30000);

		getFlightDetailsPopUp(depFlightName).click();

		departureDate = getDepDate().getText();

		arrivalDate = getArrDate().getText();

		getCloseButtonFlghtPopUp().click();

		getFlightSelector(depFlightName).click();

		getFareBrandselection().click();

		javaScriptClick(getFlightDetailsPopUp(returnFlightName));

		departureDateRtrn = getDepDate().getText();

		arrivalDateRtrn = getArrDate().getText();

		getCloseButtonFlghtPopUp().click();

		stopWebDriver(3000);

		javaScriptClick(getFlightSelector(returnFlightName));

		stopWebDriver(3000);

		// getFareBrandselection().click();

		javaScriptClick(getFareBrandselection());

		waitUntilVisibilityOf(30, getFlightDetailsArrow());

		javaScriptClick(getFlightDetailsArrow());

		stopWebDriver(3000);

		waitUntilVisibilityOf(30, getAdltDepFare());

		adltDeptFare = getAdltDepFare().getText();

		System.out.println("adltDeptFare - " + adltDeptFare);

		waitUntilVisibilityOf(30, getAdltFareReturn());

		adltReturnFare = getAdltFareReturn().getText();

		System.out.println("adltReturnFare - " + adltReturnFare);

		childDeptFare = getChildDepFare().getText();

		System.out.println("childDeptFare - " + childDeptFare);

		childReturnFares = getChildReturnFare().getText();

		System.out.println("childReturnFares - " + childReturnFares);

		totTaxPriceDep = getTaxPriceDeparture().getText();

		System.out.println("totTaxPriceDep - " + totTaxPriceDep);

		totTaxPriceRetrn = getTaxPriceReturn().getText();

		System.out.println("totTaxPriceRetrn - " + totTaxPriceRetrn);

		departureTotalPrice = getTotPriceDep().getText();

		System.out.println("departureTotalPrice - " + departureTotalPrice);

		returnTotalPrice = getTotPriceRetrn().getText();

		System.out.println("returnTotalPrice - " + returnTotalPrice);

		getAdditionalBagg().click();

		totBaggagePrice = getSubTotBaggagePrice().getText();

		System.out.println("totBaggagePrice - " + totBaggagePrice);

		totInsurPrice = getSubTotInsurancePrice().getText();

		System.out.println("totInsurPrice - " + totInsurPrice);

		if (totBaggagePrice.contains(".") || totInsurPrice.contains(".")) {

			Double tot = Double.parseDouble(totBaggagePrice) + Double.parseDouble(totInsurPrice);

			totalExtras = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(totBaggagePrice) + Integer.parseInt(totInsurPrice);

			totalExtras = String.valueOf(tot);

		}

		cummulativeTotal = getTotalCumulativePrice().getText();

		getNavigatePassdetails().click();

	}

}