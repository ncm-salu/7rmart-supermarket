package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {

	@Test(description = " add valid category", priority = 1)
	public void addValidCategory() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add category
		String categoryName = ExcelUtility.readStringData(1, 0, "Category");
		String categoryImage = Constants.CATEGORYIMAGE1;
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickOnCategoryButton();
		categorypage.clickOnNewCategoryButton();
		categorypage.addNewCategoryName(categoryName);
		categorypage.clickOnDiscount();
		categorypage.addCategoryImage(categoryImage);
		categorypage.clickOnSaveCategoryButton();
		boolean isAddCategoryDisplayed = categorypage.isCategoryTitleDisplayed();
		Assert.assertTrue(isAddCategoryDisplayed, Messages.HEADINGNOTFOUND);

	}

	@Test(description = "user able to search category", priority = 2)
	public void userAbleToSearchCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		// category search
		String categoryname = ExcelUtility.readStringData(1, 0, "Category");
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickOnCategoryButton();
		categorypage.clickSearch();
		categorypage.searchCategory(categoryname);
		categorypage.clickOnSearchButton();
		boolean isListCategoryDisplayed = categorypage.isListCategoryTitleDisplayed();
		Assert.assertTrue(isListCategoryDisplayed, Messages.HEADINGNOTFOUND);

	}
}
