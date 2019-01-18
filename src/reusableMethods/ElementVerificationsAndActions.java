package reusableMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementVerificationsAndActions {
	WebDriver driver;
	Object result;
	WebDriverWait wait;
	
	public ElementVerificationsAndActions(WebDriver driver) {
		this.driver = driver; // initialing the driver of this class
		wait = new WebDriverWait(driver, 10);// declaring or defining the ex wait
	}

	public boolean clickElement(WebElement element) {
		boolean elementstate = false;
		result = wait.until(ExpectedConditions.elementToBeClickable(element));
		if (!result.equals(null)) {
			elementstate = true;
			element.click();
		} else {
			System.out.println("Incorrect element state issue");
		}

		return elementstate;
	}

	public boolean verifyElementVisible(WebElement element) {
		boolean elementstate = false;
		result = wait.until(ExpectedConditions.visibilityOf(element));
		if (!result.equals(null)) {
			elementstate = true;
		} else {
			System.out.println("Element not visible");
		}
		return elementstate;
	}
	
	public boolean selectDropDownValue(WebElement element, String filtertp) {
		boolean elementstate = false;
		result = wait.until(ExpectedConditions.visibilityOf(element));
				if(!(result==null)) {
			elementstate=true;
		}
		Select sel = new Select(element);
		sel.selectByVisibleText(filtertp);
		return elementstate;
	}
	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

}
