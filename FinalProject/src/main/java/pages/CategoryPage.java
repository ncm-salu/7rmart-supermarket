package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()=\"Category\"]")
	private WebElement categoryButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickNewCategory;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement enterCategoryName;
	@FindBy(xpath = "//span[text()=\"discount\"]")
	private WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefilebutton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveCategory;
	@FindBy(xpath = "//h1[text()='Add Category']")
	private WebElement addCategoryTitle;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement enterCategory;
	@FindBy(xpath = "//button[@name=\"Search\"]")
	private WebElement clickSearchButton;
	@FindBy(xpath = "//h1[text()=\"List Categories\"]")
	private WebElement listCategoryTitle;

	public CategoryPage clickOnCategoryButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, categoryButton);
		PageUtility.clickOnElement(categoryButton);
		return this;
	}

	public CategoryPage clickOnNewCategoryButton() {
		PageUtility.clickOnElement(clickNewCategory);
		return this;
	}

	public CategoryPage addNewCategoryName(String categoryname) {
		enterCategoryName.sendKeys(categoryname);
		return this;
	}

	public CategoryPage clickOnDiscount() {
		PageUtility.clickOnElement(discount);
		return this;
	}

	public CategoryPage addCategoryImage(String image) {
		choosefilebutton.sendKeys(image);
		return this;
	}

	public CategoryPage clickOnSaveCategoryButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, categoryButton);
		PageUtility.windowScrollDown(driver);
		PageUtility.submitButtonClick(driver, saveCategory);
		return this;
	}

	public boolean isCategoryTitleDisplayed() {
		return addCategoryTitle.isDisplayed();
	}

	public CategoryPage clickSearch() {
		PageUtility.clickOnElement(searchButton);
		return this;
	}

	public CategoryPage searchCategory(String categoryname) {
		enterCategory.sendKeys(categoryname);
		return this;
	}

	public CategoryPage clickOnSearchButton() {
		PageUtility.clickOnElement(clickSearchButton);
		return this;
	}

	public boolean isListCategoryTitleDisplayed() {
		return listCategoryTitle.isDisplayed();
	}
}
