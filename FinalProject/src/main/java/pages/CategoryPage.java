package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	public void clickOnCategoryButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, categoryButton);
		PageUtility.clickOnElement(categoryButton);
	}

	public void clickOnNewCategoryButton() {
		PageUtility.clickOnElement(clickNewCategory);
	}

	public void addNewCategoryName(String categoryname) {
		enterCategoryName.sendKeys(categoryname);
	}

	public void clickOnDiscount() {
		PageUtility.clickOnElement(discount);
	}

	public void addCategoryImage(String image) {
		choosefilebutton.sendKeys(image);
	}

	public void clickOnSaveCategoryButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, categoryButton);
		Actions actions = new Actions(driver);
		actions.moveToElement(saveCategory).click().perform();
	}

	public boolean isCategoryTitleDisplayed() {
		return addCategoryTitle.isDisplayed();
	}

	public void clickSearch() {
		PageUtility.clickOnElement(searchButton);
	}

	public void searchCategory(String categoryname) {
		enterCategory.sendKeys(categoryname);
	}

	public void clickOnSearchButton() {
		PageUtility.clickOnElement(clickSearchButton);
	}

	public boolean isListCategoryTitleDisplayed() {
		return listCategoryTitle.isDisplayed();
	}
}
