package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitHelper;

public class LoginPage {

	private WebDriver driver;
	private By username = By.xpath("//input[@name='uid']");
	private By password = By.xpath("//input[@name='password']");
	private By login = By.xpath("//input[@name='btnLogin']");
	public static String altText = null;
	public WaitHelper wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WaitHelper(this.driver);
	}

	public void goToURL(String url) {
		driver.get(url);
	}

	public void enterUsername(String uname) {
		wait.waitForElement(driver.findElement(username));
		driver.findElement(username).sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		wait.waitForElement(driver.findElement(password));
		driver.findElement(password).sendKeys(pwd);
	}

	public void enterInvalidCredential(String un, String pass) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pass);
	}

	public ManagerHomepage clickLoginBtn() {
		wait.waitForElement(driver.findElement(login));
		driver.findElement(login).click();
		boolean alert = isAlertPresent();
		if (alert) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		return new ManagerHomepage(driver);
	}

	public boolean isAlertPresent() {
		boolean flag = false;
		try {
			altText = driver.switchTo().alert().getText();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

}
