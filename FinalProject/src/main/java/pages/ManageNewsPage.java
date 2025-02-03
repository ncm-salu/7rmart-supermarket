package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()=\"Manage News\"]")
	private WebElement manageNewsButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickNewButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterNews;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveNews;
	@FindBy(xpath = "//h3[text()=\"Enter News Informations\"]")
	private WebElement newsTitleIsDisplayed;

	public ManageNewsPage clickOnManageNewsButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, manageNewsButton);
		PageUtility.clickOnElement(manageNewsButton);
		return this;
	}

	public ManageNewsPage clickOnNewButton() {
		PageUtility.clickOnElement(clickNewButton);
		return this;
	}

	public ManageNewsPage addNews(String addnews) {
		enterNews.sendKeys(addnews);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		WaitUtility.waitUntilElementToBeClickable(driver, saveNews);
		PageUtility.clickOnElement(saveNews);
		return this;
	}

	public boolean isNewsTitleDisplayed() {
		return newsTitleIsDisplayed.isDisplayed();
	}
}
