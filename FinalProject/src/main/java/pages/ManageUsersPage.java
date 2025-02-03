package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

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

	public HomePage clickOnAdminUsersFromNavigation() {
		WaitUtility.waitUntilElementToBeClickable(driver, adminUsersClick);
		PageUtility.clickOnElement(adminUsersClick);
		return new HomePage(driver);
	}

	public ManageUsersPage clickOnManageUsersFromDropdown() {
		PageUtility.clickOnElement(clickOnManageUsers);
		return this;
	}

	public ManageUsersPage clickOnNewUserButton() {
		PageUtility.clickOnElement(clickOnNewButton);
		return this;
	}

	public ManageUsersPage addNewUsername(String username) {
		enterUsername.sendKeys(username);
		return this;
	}

	public ManageUsersPage addNewPassword(String password) {
		enterPassword.sendKeys(password);
		return this;
	}

	public ManageUsersPage selectUserTypeFromDropdown() {
		PageUtility.selectFromDropdown(selectUserType, "Admin");
		return this;
	}

	public ManageUsersPage clickOnSaveUserButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, clickSaveUserButton);
		PageUtility.windowScrollDown(driver);
		PageUtility.submitButtonClick(driver, clickSaveUserButton);
		return this;
	}

	public boolean isAdminUsersTitleDisplayed() {
		return titleAdminUsers.isDisplayed();
	}

	public ManageUsersPage clickSearch() {
		PageUtility.clickOnElement(searchButton);
		return this;
	}

	public ManageUsersPage enterUsernameInSearch(String username) {
		enterUsernameInSearch.sendKeys(username);
		return this;
	}

	public ManageUsersPage selectUserTypeFromDropdownInSearch() {
		PageUtility.selectFromDropdown(selectUserTypeInSearch, "Admin");
		return this;
	}

	public ManageUsersPage clickOnSearchButton() {
		PageUtility.clickOnElement(clickSearchButton);
		return this;
	}

	public boolean isAdminUserTitleDisplayed() {
		return adminUserTitle.isDisplayed();
	}

}
