package fly.pojo;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.utility.*;

public class SearchPage extends FlyBuyUtility {

	public static String totPassAdded;

	public SearchPage() {

		PageFactory.initElements(driver, this);

	}

//

//           @FindBy(xpath = "//button[@class=' osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept ']")

//           private WebElement acceptBtn;

	@FindBy(id = "airport-origin")

	private WebElement fromTxtBox;

	@FindBy(id = "airport-destination")

	private WebElement toTxtBox;

	@FindBy(id = "dateRangeWrapper")

	private WebElement dateSelector;

	@FindBy(xpath = "//section[@class='lightpick__month']")

	private List<WebElement> displayableMonths;

	@FindBy(xpath = "(//div[@class='btn-group '])[1]")

	private WebElement cabinType;

	@FindBy(xpath = "//div/span[@class='flyPassengerNumber']")

	private WebElement passengerCount;

	@FindBy(xpath = "//input[@class='btn btn_yellow search-btn-style'][@value='Search']")

	private WebElement flightSearchButton;

	By passengerArrowBtn = By.xpath(

			"//div[@class='mat-form-group traveller-details mr-grid-space']//div/span[@class='flyPassengerNumber']");

	By adltPassengerAddBtn = By.xpath("//div[@class='plus adult']");

	By adltPassengerMinusBtn = By.xpath("//div[@class='minus adult']");

	By childPassengerAddBtn = By.xpath("//div[@class='plus child']");

	By infantPassengerAddBtn = By.xpath("//div[@class='plus infant']");

	By acceptCookBtn = By.xpath(
			"//button[@class=' osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept ']");

//           public WebElement getAcceptBtn() {

//                          return acceptBtn;

//           }

	public WebElement getFromTxtBox() {

		return fromTxtBox;

	}

	public WebElement getToTxtBox() {

		return toTxtBox;

	}

	public WebElement getDateSelector() {

		return dateSelector;

	}

	public List<WebElement> getDisplayableMonths() {

		return displayableMonths;

	}

	public WebElement getCabinType() {

		return cabinType;

	}

	public WebElement getDynamicCabinType(String cabin) {

		return cabinType.findElement(By.xpath("//input[@id='" + cabin + "']"));

	}

	public WebElement getPassengerCount() {

		return passengerCount;

	}

	public WebElement getFlightSearchButton() {

		return flightSearchButton;

	}

	public void flightSearch(String depLoc, String arrLoc, String depDate, String retrnDate, int adltPassengerCount,

			int childPassCount, int infantPassCount, String cabin) throws InterruptedException {

		waitUntilElementToBeClick(20, acceptCookBtn).click();

		getFromTxtBox().sendKeys(depLoc);

		getFromTxtBox().sendKeys(Keys.ENTER);

		getToTxtBox().sendKeys(arrLoc);

		getToTxtBox().sendKeys(Keys.ENTER);

		getDateSelector().click();

		travelDateSelector(depDate);

		travelDateSelector(retrnDate);

		WebElement arrowBtn = waitUntilElementToBeClick(30, passengerArrowBtn);

		arrowBtn.click();

		passengerSelectionAdult(adltPassengerCount, adltPassengerAddBtn, adltPassengerMinusBtn);

		stopWebDriver(3000);

		childOrInfantSelection(childPassCount, childPassengerAddBtn);

		childOrInfantSelection(infantPassCount, infantPassengerAddBtn);

		javaScriptClick(getDynamicCabinType(cabin));

		totPassAdded = getPassengerCount().getText();

		System.out.println("Total Number Passengers added : " + totPassAdded);

		getFlightSearchButton().click();

	}

}