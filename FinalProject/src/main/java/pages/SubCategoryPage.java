package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	public void clickOnSubCategoryButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, subCategoryButton);
		PageUtility.clickOnElement(subCategoryButton);
	
	}

	public void clickOnNewSubCategoryButton() {
		PageUtility.clickOnElement(clickNewSubCategory);
	}

	public void selectCategoryFromDropdown() {
		Select select = new Select(selectCategoryName);
		select.selectByVisibleText("Chocolates");
	}

	public void addNewSubCategoryName(String subcategoryname) {
		enterSubCategoryName.sendKeys(subcategoryname);
	}

	public void addSubCategoryImage(String image) {
		imageChoosefilebutton.sendKeys(image);
	}

	public void clickOnSaveSubCategoryButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(saveSubCategory).click().perform();
	}

	public boolean isSubCategoryTitleDisplayed() {
		return viewAddSubCategoryTitle.isDisplayed();
	}

	public void clickSearch() {
		PageUtility.clickOnElement(searchButton);
	}

	public void selectCategoryFromDropdownInSearch() {
		Select select = new Select(selectCategoryNameInSearch);
		select.selectByVisibleText("Chocolates");
	}

	public void enterSubCategoryInSearch(String categoryname) {
		enterSubCategory.sendKeys(categoryname);
	}

	public void clickOnSearchButton() {
		PageUtility.clickOnElement(clickSearchButton);
	}

	public boolean isListSubCategoryTitleDisplayed() {
		return listSubCategoryTitle.isDisplayed();
	}
}
