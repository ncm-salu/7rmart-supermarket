package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(groups = { "smoke" }, description = "add sub category", priority = 1)
	public void addingANewSubCategoryInSubcategoryField() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add sub category
		String subcategoryName = ExcelUtility.readStringData(2, 0, "SubCategory");
		String subcategoryImage = Constants.SUBCATEGORYIMAGE1;
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickOnSubCategoryButton().clickOnNewSubCategoryButton().selectCategoryFromDropdown()
				.addNewSubCategoryName(subcategoryName).addSubCategoryImage(subcategoryImage);
		subcategorypage.clickOnSaveSubCategoryButton();
		boolean isAddSubCategoryDisplayed = subcategorypage.isSubCategoryTitleDisplayed();
		Assert.assertTrue(isAddSubCategoryDisplayed, Messages.HEADINGNOTFOUND);

	}

	@Test(groups = { "smoke" }, description = " search sub category", priority = 2)
	public void searchNewlyAddedSubCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickRememberCheckbox();
		loginpage.clickSignInButton();
		// search sub category
		String categoryname = ExcelUtility.readStringData(2, 0, "SubCategory");
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickOnSubCategoryButton().clickSearch().selectCategoryFromDropdownInSearch()
				.enterSubCategoryInSearch(categoryname).clickOnSearchButton();
		boolean isListSubCategoryTitleDisplayed = subcategorypage.isListSubCategoryTitleDisplayed();
		Assert.assertTrue(isListSubCategoryTitleDisplayed, Messages.HEADINGNOTFOUND);

	}
}
