package runner;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utility.FlyBuyUtility;

import fly.pojo.FlightSelectionPage;
import fly.pojo.PassengersDetailsPage;
import fly.pojo.PaymentPage;
import fly.pojo.ReviewDetailsPage;
import fly.pojo.SearchPage;

public class FlightBooking extends FlyBuyUtility {

	SearchPage searchPage;

	FlightSelectionPage flightSelectionPage;

	PassengersDetailsPage passengersDetailsPage;

	ReviewDetailsPage reviewDetailsPage;

	PaymentPage paymentPage;

	@Test

	public void flightBooking() throws InterruptedException, IOException {

		searchPage = new SearchPage();

		searchPage.flightSearch(depLoc, arrLoc, depDate, retrnDate, adltPassengerCount, childPassengerCount,

				infantPassengerCount, cabin);

		flightSelectionPage = new FlightSelectionPage();

		flightSelectionPage.flightSelection(depflightName, arrFlightName, adltPassengerCount, childPassengerCount,

				infantPassengerCount);

		passengersDetailsPage = new PassengersDetailsPage();

		passengersDetailsPage.addPassengerDetails(pass1FirstName, pass1LastName, pass1EmailAddress, pass1MobCode,

				pass1MobNum, pass2FirstName, pass2LastName, dobPass2);

		reviewDetailsPage = new ReviewDetailsPage();

		reviewDetailsPage.reviewPageValidation(depflightName, arrFlightName, depDate, depArrDate, retrnDate,

				retrnArrDate, depLoc, arrLoc, retrnDepLoc, retrnArrLoc);

		paymentPage = new PaymentPage();

		paymentPage.processPayment();

	}

}