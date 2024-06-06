package fly.pojo;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.utility.*;

public class PassengersDetailsPage extends FlyBuyUtility {

	public PassengersDetailsPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "First_Name")

	private WebElement passFirstName;

	@FindBy(id = "Last_Name")

	private WebElement passLastName;

	@FindBy(id = "Email_Address")

	private WebElement passEmailAddress;

	@FindBy(id = "Male.Text")

	private WebElement pass1Gender;

	@FindBy(id = "Code")

	private WebElement dropdwnCode;

	@FindBy(id = "Mobile_Number")

	private WebElement pass1MobNumber;

	@FindBy(xpath = "(//span[text()='Next passenger']/ancestor::button)[1]")

	private WebElement nextPassenger;

	@FindBy(id = "Female.Text-input")

	private WebElement pass2Gender;

	@FindBy(id = "dayId")

	private WebElement pass2DOBDay;

	@FindBy(id = "monthId")

	private WebElement pass2DOBMonth;

	@FindBy(id = "yearId")

	private WebElement pass2DOBYear;

	@FindBy(xpath = "(//span[text()='Review booking']/ancestor::button)[1]")

	private WebElement btnRevBooking;

	public WebElement getPassFirstName() {

		return passFirstName;

	}

	public WebElement getPassLastName() {

		return passLastName;

	}

	public WebElement getPassEmailAddress() {

		return passEmailAddress;

	}

	public WebElement getPass1Gender() {

		return pass1Gender;

	}

	public WebElement getDropdwnCode() {

		return dropdwnCode;

	}

	public WebElement getPass1MobNumber() {

		return pass1MobNumber;

	}

	public WebElement getNextPassenger() {

		return nextPassenger;

	}

	public WebElement getPass2Gender() {

		return pass2Gender;

	}

	public WebElement getPass2DOBDay() {

		return pass2DOBDay;

	}

	public WebElement getPass2DOBMonth() {

		return pass2DOBMonth;

	}

	public WebElement getPass2DOBYear() {

		return pass2DOBYear;

	}

	public WebElement getBtnRevBooking() {

		return btnRevBooking;

	}

	public void addPassengerDetails(String pass1FirstName, String pass1LastName,

			String pass1EmailAddress, String pass1MobCode, String pass1MobNum,

			String pass2FirstName, String pass2LastName, String dobPass2) {

		getPassFirstName().sendKeys(pass1FirstName);

		getPassLastName().sendKeys(pass1LastName);

		getPassEmailAddress().sendKeys(pass1EmailAddress);

		getPass1Gender().click();
		;

		javaScriptClick(getDropdwnCode());

		getDropdwnCode().sendKeys(pass1MobCode);

		getDropdwnCode().sendKeys(Keys.ARROW_DOWN);

		getDropdwnCode().sendKeys(Keys.ENTER);

		getPass1MobNumber().sendKeys(pass1MobNum);

		getNextPassenger().click();

		getPassFirstName().sendKeys(pass2FirstName);

		getPassLastName().sendKeys(pass2LastName);

		javaScriptClick(getPass2Gender());

		javaScriptClick(getPass2DOBDay());

		String[] dob;

		if (dobPass2.contains(" ")) {

			dob = dobPass2.split(" ");

		} else if (dobPass2.contains("-")) {

			dob = dobPass2.split("-");

		} else {

			dob = dobPass2.split("/");

		}

		getPass2DOBDay().sendKeys(dob[0]);

		getPass2DOBDay().sendKeys(Keys.ARROW_DOWN);

		getPass2DOBDay().sendKeys(Keys.ENTER);

		javaScriptClick(getPass2DOBMonth());

		getPass2DOBMonth().sendKeys(dob[1]);

		getPass2DOBMonth().sendKeys(Keys.ARROW_DOWN);

		getPass2DOBMonth().sendKeys(Keys.ENTER);

		javaScriptClick(getPass2DOBYear());

		getPass2DOBYear().sendKeys(dob[2]);

		getPass2DOBYear().sendKeys(Keys.ARROW_DOWN);

		getPass2DOBYear().sendKeys(Keys.ENTER);

		getBtnRevBooking().click();

	}

}
