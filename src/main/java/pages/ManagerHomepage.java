package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerHomepage {

	private WebDriver driver;
	private By managerID = By.xpath("//td[normalize-space()='Manger Id : mngr355479']"); 
	private By logoutBtn = By.xpath("//a[normalize-space()='Log out']");
	private By newCustomerLink = By.xpath("//a[normalize-space()='New Customer']");
	
	public ManagerHomepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getManagerHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getManagerID() {
		String managerid = driver.findElement(managerID).getText().split(":")[1].trim();
		return managerid;
	}
	
	public void clickLogout() throws InterruptedException {
		driver.findElement(logoutBtn).click();
		String logoutAltText = driver.switchTo().alert().getText();
		System.out.println("Logout Alert Text : "+logoutAltText);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}
	
	public AddCustomerPage clickNewCustomerLink() {
		driver.findElement(newCustomerLink).click();
		return new AddCustomerPage(driver);
	}
}
