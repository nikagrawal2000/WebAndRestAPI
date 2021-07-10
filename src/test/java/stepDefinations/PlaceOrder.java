package stepDefinations;

import java.util.Random;

import commonActions.CommonActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Catalog;
import pages.ContinueOrCheckout;
import pages.Home;
import pages.Login;
import pages.ManageAddress;
import pages.Payment;
import pages.ProdDetails;
import pages.Shipping;
import utils.GlobalBase;
import utils.ReadConfig;

public class PlaceOrder extends CommonActions {

	Login login;
	Home home;
	ManageAddress manageaddress;
	Catalog catalog;
	ContinueOrCheckout continueorcheckout;
	Payment payment;
	Shipping shipping;
	ProdDetails proddetails;

	ReadConfig conf = ReadConfig.getInstance();

	@Given("Customer Launches Application")
	public void customer_launches_application() {
		GlobalBase.getDriverInstance();
	}

	@When("Customer search {string} to buy")
	public void customer_search_to_buy(String productToBuy) {
		home = new Home();
		home.enterProceedToSearch(productToBuy);
		home.selectProduct(productToBuy);

	}

	@When("Customer Add selected product to cart")
	public void customer_add_selected_product_to_cart() {
		proddetails = new ProdDetails();
		proddetails.clickOnProductDetailAddToCart();
	}

	@When("Customer Continue to Shopping")
	public void customer_continue_to_shopping() {
		continueorcheckout = new ContinueOrCheckout();
		continueorcheckout.clickContinueShopping();
	}

	@When("Customer proceeds for checkout")
	public void customer_proceeds_for_checkout() {
		continueorcheckout = new ContinueOrCheckout();
		continueorcheckout.clickProceedToCheckout();
	}
	
	@When("Quits the browser")
	public void quits_the_browser() {
		driver.quit();
		logger.info("Browser closed Successfully");
	}

	@When("Customer Proceeds to checkout on Summary Page")
	public void customer_proceeds_to_checkout_on_summary_page() {
		shipping = new Shipping();
		shipping.clickOnProceedToCheckout();
	}
	
	@Then("^Checks Total value$")
    public void checks_total_value() throws Throwable {
		shipping = new Shipping();
		shipping.checkTotal();
    }
	
	@When("^Customer Deletes one product$")
    public void customer_deletes_one_product() throws Throwable {
		shipping = new Shipping();
		shipping.clickOnDeleteProduct();
    }

	@When("Customer SingIn by giving his credentials")
	public void customer_sing_in_by_giving_his_credentials() {
		login = new Login();
		String emailId = conf.getUsername();
		String pwd = conf.getPassword();
		login.enterEmail(emailId);
		login.enterPassword(pwd);
		login.clickOnSignIn();

	}

	@When("Custome selects {string}")
	public void custome_selects(String address) {
		manageaddress = new ManageAddress();
		manageaddress.chooseDeliveryAddress(address);
	}

	@When("Customer Proceeds to checkout on Address Page")
	public void customer_proceeds_to_checkout_on_address_page() {
		manageaddress = new ManageAddress();
		manageaddress.clickAddressProceedToCheckout();
	}

	@When("Customer Agrees terms on Shipping Page")
	public void customer_agrees_terms_on_shipping_page() {
		shipping = new Shipping();
		shipping.clickOnTermsCondition();
	}

	@When("Customer Proceeds to checkout on Shipping Page")
	public void customer_proceeds_to_checkout_on_shipping_page() {
		shipping = new Shipping();
		shipping.clickOnShippingProceedToCheckout();
	}

	@When("Customer select payment option {string}")
	public void customer_select_payment_option(String string) {
		payment = new Payment();
		payment.clickOnPayByBankWire();
	}

	@When("Customer confirm his order")
	public void customer_confirm_his_order() {
		payment = new Payment();
		payment.clickOnConfirmOrder();
	}

	@Then("Customer should get success message {string}")
	public void customer_should_get_success_message(String messageToVerify) {
		payment.verifyConfirmOrderMessage(messageToVerify);
	}

	@When("Customer select product by Women Category")
	public void customer_select_product_by_women_category()  {
		home = new Home();
		home.clickOnSearchProductByWomenCategory();
	}

	@Then("Customer Add his preferred product {string}")
	public void customer_add_his_preferred_product(String product) {
		catalog = new Catalog();
		catalog.selectProductFromCatalog(product);
	}

	@When("Customer Add popular product {string}")
	public void customer_add_popular_product(String PopularProduct) {
		catalog = new Catalog();
		catalog.selectProductByPopularity(PopularProduct);
	}

	@When("Customer Add his preferred product {string} Category")
	public void customer_add_his_preferred_product_from_women_category(String CatagoryProduct) {
		catalog = new Catalog();
		catalog.selectProductFromCategory(CatagoryProduct);
	}

	@When("Customer select product by Dresses Category")
	public void customer_select_product_by_dresses_category() {
		home = new Home();
		home.clickOnSearchProductByDressCategory();
	}

	@Then("Customer enter email {string} for creating account")
	public void customer_enter_email_for_creating_account(String emailAddress) {
		Random ran = new Random(); 
		int value = ran.nextInt(50000);
		String custEmailAddress = value+emailAddress;
		System.out.println(custEmailAddress);
		login = new Login();
		login.enterEmailAddress(custEmailAddress);
	}

	@Then("Customer Create his account")
	public void customer_create_his_account() {
		login = new Login();
		login.clickOnCreateAccount();
	}

	@Then("Customer select his gender {string}")
	public void customer_select_his_gender(String string) {
		login = new Login();
		login.clickOnMaleMr();
	}

	@Then("Customer enter his firstname {string}")
	public void customer_enter_his_firstname(String firstName) {
		login = new Login();
		login.enterFirstName(firstName);
	}

	@Then("Customer enter his lastname {string}")
	public void customer_enter_his_lastname(String lastName) {
		login = new Login();
		login.enterLastName(lastName);
	}

	@Then("Customer enter his password {string}")
	public void customer_enter_his_password(String password) {
		login = new Login();
		login.enterPassword(password);
	}

	@Then("Customer enter his DateOfBirth {string}")
	public void customer_enter_his_date_of_birth(String Dob) {
		login = new Login();
		String[] splitedDob = Dob.split(" ");
		login.selectDay(splitedDob[0].trim());
		login.selectMonth(splitedDob[1].trim());
		login.selectYear(splitedDob[2].trim());
	}

	@Then("Customer enter his company {string}")
	public void customer_enter_his_company(String comapnyName) {
		login = new Login();
		login.enterCompany(comapnyName);
	}

	@Then("Customer enter his address {string}")
	public void customer_enter_his_address(String address) {
		login = new Login();
		login.enterAddress1(address);
	}

	@Then("Customer enter his city {string}")
	public void customer_enter_his_city(String city) {
		login = new Login();
		login.enterCity(city);
	}

	@Then("Customer enter his state {string}")
	public void customer_enter_his_state(String state) {
		login = new Login();
		login.selectState(state);
	}

	@Then("Customer enter his postcode {string}")
	public void customer_enter_his_postcode(String postcode) {
		login = new Login();
		login.enterPostalcode(postcode);
	}

	@Then("Customer select his country {string}")
	public void customer_select_his_country(String country) {
		login = new Login();
		login.selectCountry(country);
	}

	@Then("Customer enter additional information {string}")
	public void customer_enter_additional_information(String otherinfo) {
		login = new Login();
		login.enterOther(otherinfo);
	}

	@Then("Customer enter mobile no {string}")
	public void customer_enter_mobile_no(String mobno) {
		login = new Login();
		login.enterMobilePhone(mobno);
	}

	@Then("Customer registered himself")
	public void customer_registered_himself() {
		login = new Login();
		login.clickOnRegister();
	}

	@When("Customer click on popular products")
	public void customer_click_on_popular_products() {
		home = new Home();
		home.clickOnSearchByPopularProducts();
	}

	@When("Customer click on Best Sellers")
	public void customer_click_on_best_sellers() {
		home = new Home();
		home.clickOnSearchByBestSellers();
	}

}
