package fly.pojo;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import com.utility.*;

public class PaymentPage extends FlyBuyUtility {

	public PaymentPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(@class,'payLaterTitle tranBlueBtn')]")

	private WebElement btnPayLater;

	@FindBy(xpath = "//button[@class='primary pay-now']")

	private WebElement btnPrimaryPay;

	@FindBy(xpath = "//div[@class='modal-body farecontainer__body']/following-sibling::div//button[@class='btnOrange btn btn-default']")

	private WebElement btnContinue;

	@FindBy(xpath = "//div[@class='confirm-tick']//label")

	private WebElement successMessgage;

	@FindBy(id = "flightBookingReferenceText")

	private WebElement bookingReference;

	@FindBy(id = "flightPaymentReferenceText")

	private WebElement paymentReference;

	public WebElement getBtnPayLater() {

		return btnPayLater;

	}

	public WebElement getBtnPrimaryPay() {

		return btnPrimaryPay;

	}

	public WebElement getBtnContinue() {

		return btnContinue;

	}

	public WebElement getSuccessMessgage() {

		return successMessgage;

	}

	public WebElement getBookingReference() {

		return bookingReference;

	}

	public WebElement getPaymentReference() {

		return paymentReference;

	}

	public void processPayment() throws InterruptedException {

		getBtnPayLater().click();

		javaScriptClick(getBtnPrimaryPay());

		getBtnContinue().click();

		String successMessage = getSuccessMessgage().getText();

		Assert.assertEquals("Booking on hold", successMessage);

		String bookingRef = getBookingReference().getText();

		System.out.println("Booking Reference : " + bookingRef);

		String paymentRef = getPaymentReference().getText();

		System.out.println("Payment Reference : " + paymentRef);

	}

}