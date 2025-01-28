package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_core.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageUsersPage;
import utilities.ExcelUtility;

public class ManageUsersTest extends Base {
	@Test(description = "add new user", priority = 1)
	public void addNewUser() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add user
		String newUsername = ExcelUtility.readStringData(2, 0, "User");
		String newPassword = ExcelUtility.readStringData(2, 1, "User");
		ManageUsersPage manageuserspage = new ManageUsersPage(driver);
		manageuserspage.clickOnAdminUsersFromNavigation();
		manageuserspage.clickOnManageUsersFromDropdown();
		manageuserspage.clickOnNewUserButton();
		manageuserspage.addNewUsername(newUsername);
		manageuserspage.addNewPassword(newPassword);
		manageuserspage.selectUserTypeFromDropdown();
		manageuserspage.clickOnSaveUserButton();
		boolean isAdminUserTitleDisplayed = manageuserspage.isAdminUsersTitleDisplayed();
		Assert.assertTrue(isAdminUserTitleDisplayed, Messages.HEADINGNOTFOUND);
	}

	@Test(description = "search a user", priority = 2)
	public void searchNewUser() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		// search user
		String searchUsername = ExcelUtility.readStringData(2, 0, "User");
		ManageUsersPage manageuserspage = new ManageUsersPage(driver);
		manageuserspage.clickOnAdminUsersFromNavigation();
		manageuserspage.clickOnManageUsersFromDropdown();
		manageuserspage.clickSearch();
		manageuserspage.enterUsernameInSearch(searchUsername);
		manageuserspage.selectUserTypeFromDropdownInSearch();
		manageuserspage.clickOnSearchButton();
		boolean isAdminUserTitleDisplayed = manageuserspage.isAdminUserTitleDisplayed();
		Assert.assertTrue(isAdminUserTitleDisplayed, Messages.HEADINGNOTFOUND);
	}
}
