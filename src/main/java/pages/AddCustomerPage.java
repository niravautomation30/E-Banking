package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage {

	private WebDriver driver;
	
	private By addCustomerPageHeading = By.xpath("//p[normalize-space()='Add New Customer']");
	
	private By name = By.xpath("//input[@name='name']");
	private By gender_male = By.xpath("//input[@value='m']");
	private By gender_female = By.xpath("//input[@value='f']");
	private By dob = By.xpath("//input[@id='dob']");
	private By addr = By.xpath("//textarea[@name='addr']");
	private By city = By.xpath("//input[@name='city']");
	private By state = By.xpath("//input[@name='state']");
	private By pinno = By.xpath("//input[@name='pinno']");
	private By telephoneno = By.xpath("//input[@name='telephoneno']");
	private By emailid = By.xpath("//input[@name='emailid']");
	private By password = By.xpath("//input[@name='password']");
	private By submit = By.xpath("//input[@name='sub']");
	
	private By successAdd = By.xpath("//p[@align='center']");
	private By cutomerID = By.xpath("(//td[normalize-space()='Customer ID']//following::td)[1]");
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHeader() {
		return driver.findElement(addCustomerPageHeading).getText();
	}

	public void enterName(String cname) {
		driver.findElement(name).sendKeys(cname);
	}

	public void enterGender(String cgender) {
		if (cgender.equalsIgnoreCase("m")) {
			driver.findElement(gender_male).click();
		} else {
			driver.findElement(gender_female).click();
		}
	}

	public void enterDob(String cdob) {
		driver.findElement(dob).sendKeys(cdob);
	}
	
	public void enterAdd(String cadd) {
		driver.findElement(addr).sendKeys(cadd);
	}
	
	public void enterCity(String ccity) {
		driver.findElement(city).sendKeys(ccity);
	}
	
	public void enterState(String cstate) {
		driver.findElement(state).sendKeys(cstate);
	}
	
	public void enterPinno(String cpin) {
		driver.findElement(pinno).sendKeys(cpin);
	}
	
	public void enterTelephoneno(String ctelephoneno) {
		driver.findElement(telephoneno).sendKeys(ctelephoneno);
	}
	
	public void enterEmailid(String cemailid) {
		driver.findElement(emailid).sendKeys(cemailid);
	}
	
	public void enterPassword(String cpassword) {
		driver.findElement(password).sendKeys(cpassword);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	public String getSuccessMsg() {
		return driver.findElement(successAdd).getText();
	}
	
	public String getCustomerID() {
		return driver.findElement(cutomerID).getText();
	} 
}
