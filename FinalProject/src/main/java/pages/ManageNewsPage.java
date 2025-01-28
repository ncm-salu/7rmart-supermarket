package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public void clickOnManageNewsButton() {
		manageNewsButton.click();
	}

	public void clickOnNewButton() {
		clickNewButton.click();
	}

	public void addNews(String addnews) {
		enterNews.sendKeys(addnews);
	}

	public void clickOnSaveButton() {
		saveNews.click();
	}

	public boolean isNewsTitleDisplayed() {
		return newsTitleIsDisplayed.isDisplayed();
	}
}
