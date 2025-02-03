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
	@Test(groups = { "news" }, description = "add news", priority = 1)
	public void addingNewNewsToManageNewsSection() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add news
		String addNews = ExcelUtility.readStringData(1, 0, "News");
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickOnManageNewsButton().clickOnNewButton().addNews(addNews).clickOnSaveButton();
		boolean isnewsDisplayed = managenewspage.isNewsTitleDisplayed();
		Assert.assertTrue(isnewsDisplayed, Messages.HEADINGNOTFOUND);
	}
}
