package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageUsersPage {
	public WebDriver driver;

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsersClick;
	@FindBy(xpath = "//p[text()=\"Manage Users\"]")
	private WebElement clickOnManageUsers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickOnNewButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement enterUsername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement enterPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectUserType;
	@FindBy(xpath = "//button[@name='Create'] ")
	private WebElement clickSaveUserButton;
	@FindBy(xpath = "//h1[text()=\"Admin Users\"]")
	private WebElement titleAdminUsers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement enterUsernameInSearch;
	@FindBy(xpath = "//select[@name='ut']")
	private WebElement selectUserTypeInSearch;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement clickSearchButton;
	@FindBy(xpath = "//h1[text()=\"Admin Users\"]")
	private WebElement adminUserTitle;

	public void clickOnAdminUsersFromNavigation() {
		adminUsersClick.click();
	}

	public void clickOnManageUsersFromDropdown() {
		clickOnManageUsers.click();
	}

	public void clickOnNewUserButton() {
		clickOnNewButton.click();
	}

	public void addNewUsername(String username) {
		enterUsername.sendKeys(username);
	}

	public void addNewPassword(String password) {
		enterPassword.sendKeys(password);
	}

	public void selectUserTypeFromDropdown() {
		Select select = new Select(selectUserType);
		select.selectByVisibleText("Admin");
	}

	public void clickOnSaveUserButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(clickSaveUserButton).click().perform();
	}

	public boolean isAdminUsersTitleDisplayed() {
		return titleAdminUsers.isDisplayed();
	}

	public void clickSearch() {
		searchButton.click();
	}

	public void enterUsernameInSearch(String username) {
		enterUsernameInSearch.sendKeys(username);
	}

	public void selectUserTypeFromDropdownInSearch() {
		Select select = new Select(selectUserTypeInSearch);
		select.selectByVisibleText("Admin");
	}

	public void clickOnSearchButton() {
		clickSearchButton.click();
	}

	public boolean isAdminUserTitleDisplayed() {
		return adminUserTitle.isDisplayed();
	}

}
