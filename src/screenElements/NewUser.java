package screenElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableMethods.ElementVerificationsAndActions;

public class NewUser {
	WebDriver driver;
	ElementVerificationsAndActions elementverifications;
	boolean res;
	
	@FindBy(xpath = "//a[@href='/admin/users/new']")
	WebElement newuserbtn;
	
	@FindBy(id="user_username")
	WebElement username;
	
	@FindBy(id="user_email")
	WebElement useremail;
	
	@FindBy(id="user_password")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@name='commit']")
	WebElement createuser_button;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancel_creation_button;
	
	public NewUser(WebDriver driver) {
		this.driver = driver;
		elementverifications = new ElementVerificationsAndActions(driver); 
		PageFactory.initElements(driver, this);
	}
	
	public boolean visibility_Newuser() {
		res = elementverifications.verifyElementVisible(createuser_button);
		if(res) {
			newuserbtn.click();
		}
		return res;
	}
	
	public boolean visibility_Username() {
		res = elementverifications.verifyElementVisible(username);
		return res;
	}
	public boolean visibility_Password() {
		res = elementverifications.verifyElementVisible(pwd);
		return res;
	}
	public boolean visibility_Email() {
		res = elementverifications.verifyElementVisible(useremail);
		return res;
	}
	public void enterNewUserDataAndSubmit(String uname, String upwd, String email) {
		username.clear();
		useremail.clear();
		pwd.clear();
		username.sendKeys(uname);
		pwd.sendKeys(upwd);
		useremail.sendKeys(email);
		createuser_button.click();
	}
	
	public boolean checkErrorMessage() {
		if(driver.getPageSource().contains("is too short (minimum is 4 characters)")) 
		{
		res = true;	
		}
		else {
			res = false;
		}
		return res;
	}

}
