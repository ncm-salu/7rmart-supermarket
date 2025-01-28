package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_core.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description = "add news", priority = 1)
	public void addNews() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add news
		String addNews = ExcelUtility.readStringData(1, 0, "News");
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickOnManageNewsButton();
		managenewspage.clickOnNewButton();
		managenewspage.addNews(addNews);
		managenewspage.clickOnSaveButton();
		boolean isnewsDisplayed = managenewspage.isNewsTitleDisplayed();
		Assert.assertTrue(isnewsDisplayed, Messages.HEADINGNOTFOUND);
	}
}
