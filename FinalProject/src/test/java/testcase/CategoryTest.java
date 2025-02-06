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

	@Test(groups = { "smoke" }, description = " add valid category", priority = 1)
	public void addingANewProductToTheCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add category
		String categoryName = ExcelUtility.readStringData(1, 0, "Category");
		String categoryImage = Constants.CATEGORYIMAGE1;
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickOnCategoryButton().clickOnNewCategoryButton().addNewCategoryName(categoryName)
				.clickOnDiscount().addCategoryImage(categoryImage).clickOnSaveCategoryButton();
		boolean isAddCategoryDisplayed = categorypage.isCategoryTitleDisplayed();
		Assert.assertTrue(isAddCategoryDisplayed, Messages.CATEGORYERROR);

	}

	@Test(groups = { "smoke" }, description = "user able to search category", priority = 2)
	public void searchAndVerifyTheNewlyAddedProductInCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// category search
		String categoryname = ExcelUtility.readStringData(1, 0, "Category");
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickOnCategoryButton().clickSearch().searchCategory(categoryname).clickOnSearchButton();
		boolean isListCategoryDisplayed = categorypage.isListCategoryTitleDisplayed();
		Assert.assertTrue(isListCategoryDisplayed, Messages.CATEGORYSEARCHERROR);

	}
}
