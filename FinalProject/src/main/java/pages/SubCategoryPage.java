package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement subCategoryButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickNewSubCategory;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement selectCategoryName;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement enterSubCategoryName;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageChoosefilebutton;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveSubCategory;
	@FindBy(xpath = "//h1[text()=\"Add Sub Category\"]")
	private WebElement viewAddSubCategoryTitle;
	@FindBy(xpath = " //a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = " //select[@id='un']")
	private WebElement selectCategoryNameInSearch;
	@FindBy(xpath = "//input[@name='ut']")
	private WebElement enterSubCategory;
	@FindBy(xpath = " //button[@name='Search']")
	private WebElement clickSearchButton;
	@FindBy(xpath = " //h1[text()=\"List Sub Categories\"]")
	private WebElement listSubCategoryTitle;

	public SubCategoryPage clickOnSubCategoryButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, subCategoryButton);
		PageUtility.clickOnElement(subCategoryButton);
		return this;
	}

	public SubCategoryPage clickOnNewSubCategoryButton() {
		PageUtility.clickOnElement(clickNewSubCategory);
		return this;
	}

	public SubCategoryPage selectCategoryFromDropdown() {

		PageUtility.selectFromDropdown(selectCategoryName, "Chocolates");
		return this;
	}

	public SubCategoryPage addNewSubCategoryName(String subcategoryname) {
		enterSubCategoryName.sendKeys(subcategoryname);
		return this;
	}

	public SubCategoryPage addSubCategoryImage(String image) {
		imageChoosefilebutton.sendKeys(image);
		return this;
	}

	public SubCategoryPage clickOnSaveSubCategoryButton() {

		WaitUtility.waitUntilElementToBeClickable(driver, saveSubCategory);
		PageUtility.windowScrollDown(driver);
		PageUtility.submitButtonClick(driver, saveSubCategory);
		return this;
	}

	public boolean isSubCategoryTitleDisplayed() {
		return viewAddSubCategoryTitle.isDisplayed();
	}

	public SubCategoryPage clickSearch() {
		PageUtility.clickOnElement(searchButton);
		return this;
	}

	public SubCategoryPage selectCategoryFromDropdownInSearch() {
		PageUtility.selectFromDropdown(selectCategoryNameInSearch, "Chocolates");
		return this;
	}

	public SubCategoryPage enterSubCategoryInSearch(String categoryname) {
		enterSubCategory.sendKeys(categoryname);
		return this;
	}

	public SubCategoryPage clickOnSearchButton() {
		PageUtility.clickOnElement(clickSearchButton);
		return this;
	}

	public boolean isListSubCategoryTitleDisplayed() {
		return listSubCategoryTitle.isDisplayed();
	}
}
