package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import reusableMethods.Reports;
import reusableMethods.RequiredCapabilities;
import screenElements.NewUser;
import screenElements.Users;
import screenElements.Dashboard;

public class NewUsersAndFilters extends RequiredCapabilities {
	WebDriver driver;
	Dashboard dashboard;
	NewUser newuser;
	Users users;
	boolean result;
	ExtentReports report;
	ExtentTest test;

	@BeforeMethod
	@Parameters({ "browsername" })
	public void configurations(String browsername) {
		driver = setCapabilities(browsername);
		report = Reports.getInstance();
		dashboard = new Dashboard(driver);
		users = new Users(driver);
		newuser = new NewUser(driver);
	}

	@Test(groups = { "usertests"}, priority = 1)
	public void createNewUser() {
		test = report.startTest("New User Creation Test - Positive");
		result = dashboard.verifyDashboard();
		Assert.assertTrue(result, "Dashboard not present");
		result = dashboard.ClickUsersTab();
		Assert.assertTrue(result, "Unable to click Users tab");
		result = newuser.visibility_Newuser();
		Assert.assertTrue(result, "New User button not present");
		result = newuser.visibility_Username();
		Assert.assertTrue(result, "Username inputbox is not visible");
		result = newuser.visibility_Email();
		Assert.assertTrue(result, "Email input box is not visible");
		result = newuser.visibility_Password();
		Assert.assertTrue(result, "Password input box is not visible");
		newuser.enterNewUserDataAndSubmit("AnubhaMeS", "sharma", "anubha@abc.com");
		test.log(LogStatus.PASS, "User created successfully");
		}

	@Test(groups = { "usertests"}, priority = 2)
	@Parameters({ "filteroption", "textval" })
	public void userFilters(String filteroption, String textval) {
		test = report.startTest("Existing User Search Test");
		result = dashboard.verifyDashboard();
		Assert.assertTrue(result, "Dashboard not present");
		result = dashboard.ClickUsersTab();
		Assert.assertTrue(result, "Unable to click Users tab");
		result = users.userNameFilter(filteroption);
		Assert.assertTrue(result, "Username field not found");
		users.enterUserName(textval);
		result = users.clickFilterButton();
		Assert.assertTrue(result, "User search failed");
		test.log(LogStatus.PASS, "User Search Successful");
	}

	@Test(groups = { "usertests" }, priority = 3)
	public void negativeTest() {
		test = report.startTest("User Creation without valid password");
		result = dashboard.verifyDashboard();
		Assert.assertTrue(result, "Dashboard not present");
		result = dashboard.ClickUsersTab();
		Assert.assertTrue(result, "Unable to click Users tab");
		result = newuser.visibility_Newuser();
		Assert.assertTrue(result, "New User button not present");
		result = newuser.visibility_Username();
		Assert.assertTrue(result, "Username inputbox is not visible");
		result = newuser.visibility_Email();
		Assert.assertTrue(result, "Email input box is not visible");
		result = newuser.visibility_Password();
		Assert.assertTrue(result, "Password input box is not visible");
		newuser.enterNewUserDataAndSubmit("Anubha", "123", "anubha@test.com");
		result = newuser.checkErrorMessage();
		Assert.assertTrue(result, "Password error message not present");
		test.log(LogStatus.PASS, "Invalid password input validation done successfully");
	}

	@AfterMethod
	public void tearOff() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
