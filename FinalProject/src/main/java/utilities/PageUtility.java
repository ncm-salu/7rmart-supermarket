package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static WebDriver driver;

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public void righClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void draggableAction(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	public void dragAndDrop(WebElement element, WebElement dropzone) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element, dropzone).build().perform();
	}

	public void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void windowScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void windowScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public void selectFromDropdown(WebElement element) {
		Select select = new Select(element);
	 //	select.selectByIndex(1);
		select.selectByVisibleText("Chocolates");
     // select.selectByValue("");
	}

	public static void clickSubmitButton(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
}
