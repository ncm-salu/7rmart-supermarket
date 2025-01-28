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
	@Test(description = "add sub category", priority = 1)
	public void addSubCategory() throws IOException {
		// login
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		// add sub category
		String subcategoryName = ExcelUtility.readStringData(2, 0, "SubCategory");
		String subcategoryImage = Constants.SUBCATEGORYIMAGE1;
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickOnSubCategoryButton();
		subcategorypage.clickOnNewSubCategoryButton();
		subcategorypage.selectCategoryFromDropdown();
		subcategorypage.addNewSubCategoryName(subcategoryName);
		subcategorypage.addSubCategoryImage(subcategoryImage);
		subcategorypage.clickOnSaveSubCategoryButton();
		boolean isAddSubCategoryDisplayed = subcategorypage.isSubCategoryTitleDisplayed();
		Assert.assertTrue(isAddSubCategoryDisplayed, Messages.HEADINGNOTFOUND);

	}

	@Test(description = " search sub category", priority = 2)
	public void searchSubCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickRememberCheckbox();
		loginpage.clickSignInButton();
		// sub category search
		String categoryname = ExcelUtility.readStringData(2, 0, "SubCategory");
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickOnSubCategoryButton();
		subcategorypage.clickSearch();
		subcategorypage.selectCategoryFromDropdownInSearch();
		subcategorypage.enterSubCategoryInSearch(categoryname);
		subcategorypage.clickOnSearchButton();
		boolean isListSubCategoryTitleDisplayed = subcategorypage.isListSubCategoryTitleDisplayed();
		Assert.assertTrue(isListSubCategoryTitleDisplayed, Messages.HEADINGNOTFOUND);

	}
}
