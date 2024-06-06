package fly.pojo;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import com.utility.*;

public class ReviewDetailsPage extends FlyBuyUtility {

	public ReviewDetailsPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[@class='carrier-description ng-star-inserted']//label)[1]")

	private WebElement revDepFlight;

	@FindBy(xpath = "(//div[@class='flight-date departure-flight-date']//p)[1]")

	private WebElement revDepDate;

	@FindBy(xpath = "(//div[@class='flight-date arrival-flight-date']//p)[1]")

	private WebElement revArrDate;

	@FindBy(xpath = "(//div[@class='irops-tripDetails-name']/span/fz-static-label)[2]/label")

	private WebElement revDepLoc;

	@FindBy(xpath = "(//div[@class='irops-tripDetails-name']/span/fz-static-label)[4]/label")

	private WebElement revRetrnDepLoc;

	@FindBy(xpath = "(//div[@class='carrier-description ng-star-inserted']//label)[2]")

	private WebElement revRetrnFlight;

	@FindBy(xpath = "(//div[@class='flight-date departure-flight-date']//p)[2]")

	private WebElement revRetrnDepDate;

	@FindBy(xpath = "(//div[@class='flight-date arrival-flight-date']//p)[2]")

	private WebElement revRetrnArrDate;

	@FindBy(xpath = "(//div[@class='arrival-airport-info']/span/fz-static-label)[2]")

	private WebElement revArrLoc;

	@FindBy(xpath = "(//div[@class='arrival-airport-info']/span/fz-static-label)[4]")

	private WebElement revRetrnArrLoc;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[2]")

	private WebElement fare1stPassenger;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[3]")

	private WebElement tax1stPassenger;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[4]")

	private WebElement extras1stPassenger;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[1]")

	private WebElement totalPrice1stPassenger;

	@FindBy(xpath = "//span[@class='mat-content ng-tns-c95-75']/following-sibling::span")

	private WebElement exp2ndPassenger;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[6]")

	private WebElement fare2ndPassenger;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[7]")

	private WebElement tax2ndPassenger;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[8]")

	private WebElement extras2ndPassenger;

	@FindBy(xpath = "(//div[@id='fareAmt0']//fz-static-label/label[@id='lblAmount'])[5]")

	private WebElement totalPrice2ndPassenger;

	@FindBy(xpath = "//span[@class='mat-content ng-tns-c95-73']/following-sibling::span")

	private WebElement btnPass1RetrnFareDetails;

	@FindBy(id = "mat-tab-label-0-1")

	private WebElement arrowPass1Expand;

	@FindBy(xpath = "//span[@class='mat-content ng-tns-c95-75']/following-sibling::span")

	private WebElement btnPass2RetrnFareDetails;

	@FindBy(id = "mat-tab-label-1-1")

	private WebElement arrowPass2Expand;

	@FindBy(xpath = "//div[@id='totalAmount']//label[@id='lblAmount']")

	private WebElement bookingTotal;

	@FindBy(xpath = "//div[@class='noShowLabelTitle']//label")

	private List<WebElement> noOfPassengers;

	@FindBy(xpath = "//button[@class='mat-button mat-button-base reviewPagebutton']")

	private WebElement continuePayment;

	public WebElement getRevDepFlight() {

		return revDepFlight;

	}

	public WebElement getRevDepDate() {

		return revDepDate;

	}

	public WebElement getRevArrDate() {

		return revArrDate;

	}

	public WebElement getRevDepLoc() {

		return revDepLoc;

	}

	public WebElement getRevRetrnDepLoc() {

		return revRetrnDepLoc;

	}

	public WebElement getRevRetrnFlight() {

		return revRetrnFlight;

	}

	public WebElement getRevRetrnDepDate() {

		return revRetrnDepDate;

	}

	public WebElement getRevRetrnArrDate() {

		return revRetrnArrDate;

	}

	public WebElement getRevArrLoc() {

		return revArrLoc;

	}

	public WebElement getRevRetrnArrLoc() {

		return revRetrnArrLoc;

	}

	public WebElement getFare1stPassenger() {

		return fare1stPassenger;

	}

	public WebElement getTax1stPassenger() {

		return tax1stPassenger;

	}

	public WebElement getExtras1stPassenger() {

		return extras1stPassenger;

	}

	public WebElement getTotalPrice1stPassenger() {

		return totalPrice1stPassenger;

	}

	public WebElement getExp2ndPassenger() {

		return exp2ndPassenger;

	}

	public WebElement getFare2ndPassenger() {

		return fare2ndPassenger;

	}

	public WebElement getTax2ndPassenger() {

		return tax2ndPassenger;

	}

	public WebElement getExtras2ndPassenger() {

		return extras2ndPassenger;

	}

	public WebElement getTotalPrice2ndPassenger() {

		return totalPrice2ndPassenger;

	}

	public WebElement getBtnPass1RetrnFareDetails() {

		return btnPass1RetrnFareDetails;

	}

	public WebElement getArrowPass1Expand() {

		return arrowPass1Expand;

	}

	public WebElement getBtnPass2RetrnFareDetails() {

		return btnPass2RetrnFareDetails;

	}

	public WebElement getArrowPass2Expand() {

		return arrowPass2Expand;

	}

	public WebElement getBookingTotal() {

		return bookingTotal;

	}

	public List<WebElement> getNoOfPassengers() {

		return noOfPassengers;

	}

	public WebElement getContinuePayment() {

		return continuePayment;

	}

	public void reviewPageValidation(String depFlightName, String retFlightName, String depDate, String depArrDate,

			String retrnDate, String retrnArrDate, String depLoc, String arrLoc, String retrnDepLoc,
			String retrnArrLoc) {

		String revDepartFlight = getRevDepFlight().getText();

		String revDeptDate = getRevDepDate().getText();

		String revDepartLocation = getRevDepLoc().getText();

		String revArrivalLocation = getRevArrLoc().getText();

		String revArrivalDate = getRevArrDate().getText();

		String revReturnArrivlDate = getRevRetrnArrDate().getText();

		String revReturnFlight = getRevRetrnFlight().getText();

		String revReturnDepDate = getRevRetrnDepDate().getText();

		String revRetrnDeprtLocation = getRevRetrnDepLoc().getText();

		String revReturnArrivlLocation = getRevRetrnArrLoc().getText();

		// Flight Validation, Dep and Return

		Assert.assertEquals(depFlightName, revDepartFlight);

		Assert.assertEquals(retFlightName, revReturnFlight);

		// Date of Dep and Arrival for Outward and Inward

		Assert.assertTrue(revDeptDate.contains(depDate));

		Assert.assertTrue(revArrivalDate.contains(depArrDate));

		Assert.assertTrue(revReturnDepDate.contains(retrnDate));

		Assert.assertTrue(revReturnArrivlDate.contains(retrnArrDate));

		// Validation Route

		Assert.assertEquals(depLoc, revDepartLocation);

		Assert.assertEquals(arrLoc, revArrivalLocation);

		Assert.assertEquals(retrnDepLoc, revRetrnDeprtLocation);

		Assert.assertEquals(retrnArrLoc, revReturnArrivlLocation);

		String passenger1Fare = getFare1stPassenger().getText();

		System.out.println("passenger1Fare : " + passenger1Fare);

		String passenger1Tax = getTax1stPassenger().getText();

		System.out.println("passenger1Tax : " + passenger1Tax);

		String passenger1Extras = getExtras1stPassenger().getText();

		System.out.println("passenger1Extras : " + passenger1Extras);

		String passenger1TotPrice = getTotalPrice1stPassenger().getText();

		System.out.println("passenger1TotPrice : " + passenger1TotPrice);

		getExp2ndPassenger().click();

		String passenger2Fare = getFare2ndPassenger().getText();

		System.out.println("passenger2Fare : " + passenger2Fare);

		String passenger2Tax = getTax2ndPassenger().getText();

		System.out.println("passenger2Tax : " + passenger2Tax);

		String passenger2Extras = getExtras2ndPassenger().getText();

		System.out.println("passenger2Extras : " + passenger2Extras);

		String passenger2TotPrice = getTotalPrice2ndPassenger().getText();

		System.out.println("passenger2TotPrice : " + passenger2TotPrice);

		String totFarePassengers;

		if (passenger1Fare.contains(".") || passenger2Fare.contains(".")) {

			Double tot = Double.parseDouble(passenger1Fare) + Double.parseDouble(passenger2Fare);

			totFarePassengers = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1Fare) + Integer.parseInt(passenger2Fare);

			totFarePassengers = String.valueOf(tot);

		}

		System.out.println("totFarePassengers : " + totFarePassengers);

		String totTaxPassengers;

		if (passenger1Tax.contains(".") || passenger2Tax.contains(".")) {

			Double tot = Double.parseDouble(passenger1Tax) + Double.parseDouble(passenger2Tax);

			totTaxPassengers = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1Tax) + Integer.parseInt(passenger2Tax);

			totTaxPassengers = String.valueOf(tot);

		}

		System.out.println("totTaxPassengers : " + totTaxPassengers);

		String totExtrasPassengers;

		if (passenger1Extras.contains(".") || passenger2Extras.contains(".")) {

			Double tot = Double.parseDouble(passenger1Extras) + Double.parseDouble(passenger2Extras);

			totExtrasPassengers = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1Extras) + Integer.parseInt(passenger2Extras);

			totExtrasPassengers = String.valueOf(tot);

		}

		System.out.println("totExtrasPassengers : " + totExtrasPassengers);

		String totPricePassengers;

		if (passenger1TotPrice.contains(".") || passenger2TotPrice.contains(".")) {

			Double tot = Double.parseDouble(passenger1TotPrice) + Double.parseDouble(passenger2TotPrice);

			totPricePassengers = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1TotPrice) + Integer.parseInt(passenger2TotPrice);

			totPricePassengers = String.valueOf(tot);

		}

		System.out.println("totPricePassengers : " + totPricePassengers);

		// Fare validation for Passenger 1 and 2

		Assert.assertEquals(FlightSelectionPage.adltDeptFare, passenger1Fare);

		Assert.assertEquals(FlightSelectionPage.childDeptFare, passenger2Fare);

		// Tax validation for Passenger 1 and 2

		Assert.assertEquals(FlightSelectionPage.totTaxPriceDep, totTaxPassengers);

		javaScriptClick(getBtnPass1RetrnFareDetails());

		getArrowPass1Expand().click();

		String passenger1FareReturn = getFare1stPassenger().getText();

		System.out.println("passenger1FareReturn : " + passenger1FareReturn);

		String passenger1TaxReturn = getTax1stPassenger().getText();

		System.out.println("passenger1TaxReturn : " + passenger1TaxReturn);

		String passenger1ExtrasReturn = getExtras1stPassenger().getText();

		System.out.println("passenger1ExtrasReturn : " + passenger1ExtrasReturn);

		String passenger1TotPriceReturn = getTotalPrice1stPassenger().getText();

		System.out.println("passenger1TotPriceReturn : " + passenger1TotPriceReturn);

		getBtnPass2RetrnFareDetails().click();

		getArrowPass2Expand().click();

		String passenger2FareReturn = getFare2ndPassenger().getText();

		System.out.println("passenger2FareReturn : " + passenger2FareReturn);

		String passenger2TaxReturn = getTax2ndPassenger().getText();

		System.out.println("passenger2TaxReturn : " + passenger2TaxReturn);

		String passenger2ExtrasReturn = getExtras2ndPassenger().getText();

		System.out.println("passenger2ExtrasReturn : " + passenger2ExtrasReturn);

		String passenger2TotPriceReturn = getTotalPrice2ndPassenger().getText();

		System.out.println("passenger2TotPriceReturn : " + passenger2TotPriceReturn);

		String totFarePassengersRtrn;

		if (passenger1FareReturn.contains(".") || passenger2FareReturn.contains(".")) {

			Double tot = Double.parseDouble(passenger1FareReturn) + Double.parseDouble(passenger2FareReturn);

			totFarePassengersRtrn = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1FareReturn) + Integer.parseInt(passenger2FareReturn);

			totFarePassengersRtrn = String.valueOf(tot);

		}

		String totTaxPassengersRtrn;

		if (passenger1TaxReturn.contains(".") || passenger2TaxReturn.contains(".")) {

			Double tot = Double.parseDouble(passenger1TaxReturn) + Double.parseDouble(passenger2TaxReturn);

			totTaxPassengersRtrn = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1TaxReturn) + Integer.parseInt(passenger2TaxReturn);

			totTaxPassengersRtrn = String.valueOf(tot);

		}

		String totExtrasPassengersRtrn;

		if (passenger1ExtrasReturn.contains(".") || passenger2ExtrasReturn.contains(".")) {

			Double tot = Double.parseDouble(passenger1ExtrasReturn) + Double.parseDouble(passenger2ExtrasReturn);

			totExtrasPassengersRtrn = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1ExtrasReturn) + Integer.parseInt(passenger2ExtrasReturn);

			totExtrasPassengersRtrn = String.valueOf(tot);

		}

		String totPricePassengersRtrn;

		if (passenger1TotPriceReturn.contains(".") || passenger2TotPriceReturn.contains(".")) {

			Double tot = Double.parseDouble(passenger1TotPriceReturn) + Double.parseDouble(passenger2TotPriceReturn);

			totPricePassengersRtrn = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(passenger1TotPriceReturn) + Integer.parseInt(passenger2TotPriceReturn);

			totPricePassengersRtrn = String.valueOf(tot);

		}

		// Fare validation for Passenger 1 and 2 on Return

		Assert.assertEquals(FlightSelectionPage.adltReturnFare, passenger1FareReturn);

		Assert.assertEquals(FlightSelectionPage.childReturnFares, passenger2FareReturn);

		// Tax validation for Passenger 1 and 2 for Onward and Inward both

		Assert.assertEquals(FlightSelectionPage.totTaxPriceRetrn, totTaxPassengersRtrn);

		// Validation for Extras for Onward and Inward both

		String totlExtraOnIn = null;

		System.out.println("Total Extras for Passenger onward : " + totExtrasPassengers);

		System.out.println("Total Extras for Passenger Return : " + totExtrasPassengersRtrn);

		if (totExtrasPassengers.contains(".") || totExtrasPassengersRtrn.contains(".")) {

			Double tot = Double.parseDouble(totExtrasPassengers) + Double.parseDouble(totExtrasPassengersRtrn);

			totlExtraOnIn = String.valueOf(tot);

		} else {

			Integer tot = Integer.parseInt(totExtrasPassengers) + Integer.parseInt(totExtrasPassengersRtrn);

			totlExtraOnIn = String.valueOf(tot);

		}

		System.out.println("Total Extras for Onward and Return : " + totlExtraOnIn);

		Assert.assertEquals(FlightSelectionPage.totalExtras, totlExtraOnIn);

		// Final Booking Total

		String bookingTotal = getBookingTotal().getText();

		System.out.println("Booking Total : " + bookingTotal);

		Assert.assertEquals(FlightSelectionPage.cummulativeTotal, bookingTotal);

		// No of Passenger

		List<WebElement> elements = getNoOfPassengers();

		int noOfPassengers = elements.size();

		System.out.println("noOfPassengers : " + noOfPassengers);

		Assert.assertEquals(SearchPage.totPassAdded, String.valueOf(noOfPassengers));

		getContinuePayment().click();

	}

}