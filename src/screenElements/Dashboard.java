package screenElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableMethods.ElementVerificationsAndActions;

public class Dashboard {

	WebDriver driver;
	ElementVerificationsAndActions elementverifications;
	boolean res;
	
	@FindBy(id="page_title")
	WebElement page_header;
	
	@FindBy(xpath="//a[@href='/admin/users']")
	WebElement users_tab;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		elementverifications = new ElementVerificationsAndActions(driver);
		PageFactory.initElements(driver, this); 
		
	}
	
	public boolean verifyDashboard() {
		res = elementverifications.verifyElementVisible(page_header);
		return res;
		}
	public boolean ClickUsersTab() {
		res = elementverifications.clickElement(users_tab);
		return res;
		}
}
