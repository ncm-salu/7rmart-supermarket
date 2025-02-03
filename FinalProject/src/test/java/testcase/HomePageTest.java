package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_core.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	@Test(description = " logout from website", priority = 1)
	public void adminLogoutAfterAdminLoginToHomePage() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// logout
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminButton().clickOnLogoutButton();
		boolean isSigninButtonDisplayed = homepage.isSigninButtonDisplayed();
		Assert.assertTrue(isSigninButtonDisplayed, Messages.ELEMENTNOTFOUND);

	}

}
