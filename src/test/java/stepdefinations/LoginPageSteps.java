package stepdefinations;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import configreader.ConfigPropReader;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ManagerHomepage;

public class LoginPageSteps {
	
	private ConfigPropReader configReader = new ConfigPropReader();
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private ManagerHomepage mngrHomePage;
	public static Logger logger;

	@Given("user navigates to Guru99Bank url")
	public void user_navigates_to_guru99bank_url() {
		logger = Logger.getLogger("E-Banking");
		PropertyConfigurator.configure("./log4j.properties");
		
		logger.info("URL is opened.");		
		loginpage.goToURL(configReader.getURL());
	}
	
	@When("user enters {string} and {string}")
	public void user_enters_and(String uname, String pwd) {
		loginpage.enterUsername(uname);
		logger.info("Entered username.");
		
		loginpage.enterPassword(pwd);
		logger.info("Entered password.");
	}
	
	@When("click on Submit")
	public void click_on_submit() {
		mngrHomePage = loginpage.clickLoginBtn();
		logger.info("Clicked on Submit.");
	}
	
	@Then("user on the Manager Home Page")
	public void user_on_the_manager_home_page() {
		String actMngrHomePageTitle = mngrHomePage.getManagerHomePageTitle().trim();
		Assert.assertTrue(actMngrHomePageTitle.contains("Guru99 Bank Manager HomePage"));
	}
	
	@Then("Verify ManagerId is mngr355479 display on the manager home page")
	public void verify_manager_id_is_mngr355479_display_on_the_manager_home_page() {

	}
	
	
	@When("user enters following data")
	public void user_enters_following_data(DataTable dataTable) {
		List<List<String>> userList= dataTable.asLists(String.class);
		
		for(List<String> e: userList) {
			loginpage.enterUsername(e.get(0));
			loginpage.enterPassword(e.get(1));
		}

	}
	
	@Then("Verify ManagerId is {string} display on the manager home page")
	public void verify_manager_id_is_display_on_the_manager_home_page(String expMngrID) {
		String actMngrID = mngrHomePage.getManagerID();
		Assert.assertTrue(actMngrID.contains(expMngrID));
	}
	
	@Then("Verify Alert Message for invalid username and password")
	public void verify_alert_message_for_invalid_username_and_password() {
		String actAlertText = LoginPage.altText;
		Assert.assertTrue(actAlertText.contains("User or Password is not valid"));
	}

	@When("user enters following data with column name")
	public void user_enters_following_data_with_column_name(io.cucumber.datatable.DataTable dataTable) {
	
	}

}
