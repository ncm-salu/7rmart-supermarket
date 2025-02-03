package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_core.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageUsersPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageUsersTest extends Base {
	@Test(groups = { "user" }, description = "add new user", priority = 1)
	public void addingNewUserToTheManageUserSection() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add user using faker utility
		FakerUtility faker = new FakerUtility();
		String newUsername = faker.generateNewUsername();
		String newPassword = faker.generateNewPassword();
		ManageUsersPage manageuserspage = new ManageUsersPage(driver);
		manageuserspage.clickOnAdminUsersFromNavigation();
		manageuserspage.clickOnManageUsersFromDropdown().clickOnNewUserButton().addNewUsername(newUsername)
				.addNewPassword(newPassword).selectUserTypeFromDropdown().clickOnSaveUserButton();
		boolean isAdminUserTitleDisplayed = manageuserspage.isAdminUsersTitleDisplayed();
		Assert.assertTrue(isAdminUserTitleDisplayed, Messages.HEADINGNOTFOUND);
	}

	@Test(groups = { "user" }, description = "search a user", priority = 2)
	public void searchAndVerifyNewlyAddedUser() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// search user
		String searchUsername = ExcelUtility.readStringData(2, 0, "User");
		ManageUsersPage manageuserspage = new ManageUsersPage(driver);
		manageuserspage.clickOnAdminUsersFromNavigation();
		manageuserspage.clickOnManageUsersFromDropdown().clickSearch().enterUsernameInSearch(searchUsername)
				.selectUserTypeFromDropdownInSearch().clickOnSearchButton();
		boolean isAdminUserTitleDisplayed = manageuserspage.isAdminUserTitleDisplayed();
		Assert.assertTrue(isAdminUserTitleDisplayed, Messages.HEADINGNOTFOUND);
	}
}
