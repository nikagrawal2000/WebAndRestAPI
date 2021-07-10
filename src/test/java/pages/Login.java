package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonActions.CommonActions;

public class Login extends CommonActions {
	
	public Login() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "SubmitLogin")
	public static WebElement button_SignIn;

	@FindBy(id = "SubmitCreate")
	public static WebElement button_CreateAccount;

	@FindBy(id = "email_create")
	public static WebElement textBox_EmailAddress;

	@FindBy(id = "id_gender1")
	public static WebElement radioButton_MaleMr;

	@FindBy(id = "customer_firstname")
	public static WebElement textBox_FirstName;

	@FindBy(id = "customer_lastname")
	public static WebElement textBox_LastName;

	@FindBy(id = "email")
	public static WebElement textBox_Email;

	@FindBy(id = "passwd")
	public static WebElement textBox_Password;

	@FindBy(id = "days")
	public static WebElement dropDown_Day;

	@FindBy(id = "months")
	public static WebElement dropDown_Month;

	@FindBy(id = "years")
	public static WebElement dropDown_Year;

	@FindBy(id = "company")
	public static WebElement textBox_Company;

	@FindBy(id = "address1")
	public static WebElement textBox_Address1;

	@FindBy(id = "city")
	public static WebElement textBox_City;

	@FindBy(id = "id_state")
	public static WebElement dropDown_State;

	@FindBy(id = "postcode")
	public static WebElement textBox_Postalcode;

	@FindBy(id = "id_country")
	public static WebElement dropDown_Country;

	@FindBy(id = "other")
	public static WebElement textBox_Other;

	@FindBy(id = "phone_mobile")
	public static WebElement textBox_MobilePhone;

	@FindBy(id = "submitAccount")
	public static WebElement Button_Register;

	public void clickOnSignIn() {
		click(button_SignIn);

	}

	public void clickOnCreateAccount() {
		click(button_CreateAccount);

	}

	public void enterEmailAddress(String valueToSend) {
		enterValue(textBox_EmailAddress, valueToSend);

	}

	public void clickOnMaleMr() {
		click(radioButton_MaleMr);

	}

	public void enterFirstName(String valueToSend) {
		enterValue(textBox_FirstName, valueToSend);

	}

	public void enterLastName(String valueToSend) {
		enterValue(textBox_LastName, valueToSend);

	}

	public void enterEmail(String valueToSend) {
		enterValue(textBox_Email, valueToSend);

	}

	public void enterPassword(String valueToSend) {
		enterValue(textBox_Password, valueToSend);

	}

	public void selectDay(String valueToSelect) {
		selectDropdownByValue(dropDown_Day, valueToSelect);

	}

	public void selectMonth(String valueToSelect) {
		selectDropdownByValue(dropDown_Month, valueToSelect);

	}

	public void selectYear(String valueToSelect) {
		selectDropdownByValue(dropDown_Year, valueToSelect);

	}

	public void enterCompany(String valueToSend) {
		enterValue(textBox_Company, valueToSend);

	}

	public void enterAddress1(String valueToSend) {
		enterValue(textBox_Address1, valueToSend);

	}

	public void enterCity(String valueToSend) {
		enterValue(textBox_City, valueToSend);

	}

	public void selectState(String valueToSelect) {
		selectDropdown(dropDown_State, valueToSelect);

	}

	public void enterPostalcode(String valueToSend) {
		enterValue(textBox_Postalcode, valueToSend);

	}

	public void selectCountry(String valueToSelect) {
		selectDropdown(dropDown_Country, valueToSelect);

	}

	public void enterOther(String valueToSend) {
		enterValue(textBox_Other, valueToSend);

	}

	public void enterMobilePhone(String valueToSend) {
		enterValue(textBox_MobilePhone, valueToSend);

	}

	public void clickOnRegister() {
		click(Button_Register);

	}

}
