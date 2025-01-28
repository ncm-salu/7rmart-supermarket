package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_core.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(groups = { "login" }, description = "user login with valid username and valid password", priority = 1)
	public void userLoginWithValidUsernameandValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isDashboardDisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.ELEMENTNOTFOUND);

	}

	@Test(groups = { "login" }, description = "user login with valid username and invalid password", priority = 2)
	public void userLoginWithValidUsernameandInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "Login");
		String password = ExcelUtility.readStringData(2, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isErrorMessageDisplayed, Messages.ALERTMESSAGENOTFOUND);

	}

	@Test(groups = { "login" }, description = "user login with invalid username and valid password", priority = 3)
	public void userLoginWithInvalidUsernameandValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isErrorMessageDisplayed, Messages.ALERTMESSAGENOTFOUND);
	}

	@Test(groups = { "login" }, description = "user login with invalid username and invalid password", priority = 4)

	public void userLoginWithInvalidUsernameandInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(4, 0, "Login");
		String password = ExcelUtility.readStringData(4, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		boolean isErrorMessageDisplayed = loginpage.isAlertboxErrorMessageDisplayed();
		Assert.assertTrue(isErrorMessageDisplayed, Messages.ALERTMESSAGENOTFOUND);
	}

}
