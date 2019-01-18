package screenElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableMethods.ElementVerificationsAndActions;

public class Users {
	
	WebDriver driver;
	ElementVerificationsAndActions elementverifications;
	boolean res; 
	
	@FindBy(xpath = "//div[@id='q_username_input']/select")
	WebElement searchbyusername_options;
	
	@FindBy(xpath = "//div[@id='q_email_input']/select")
	WebElement searchbyemail_options;
	
	@FindBy(css = "input[type='submit']")
	WebElement filter_button;
	
	@FindBy(xpath = "//a[@class='clear_filters_btn']")
	WebElement clearfilters_button;
	
	@FindBy(id = "q_created_at_gteq_datetime")
	WebElement searchbycreationdate_start;
	
	@FindBy(id = "q_created_at_lteq_datetime")
	WebElement searchbycreationdate_end;
	
	@FindBy(id="q_username")
	WebElement usernametextbox;

	public Users(WebDriver driver){
		this.driver=driver; 
		elementverifications =new ElementVerificationsAndActions(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean userNameFilter(String filter) {
		res = elementverifications.selectDropDownValue(searchbyusername_options, filter);
		return res;
	}
	public void enterUserName(String uname) {
		res = elementverifications.verifyElementVisible(usernametextbox);
		elementverifications.enterText(usernametextbox, uname);
	}
	public boolean clickFilterButton() {
		res = elementverifications.clickElement(filter_button);
		return res;
	}

}
