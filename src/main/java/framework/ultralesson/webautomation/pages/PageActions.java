package framework.ultralesson.webautomation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PageActions {
    private WebDriver webDriver;
    private PageWaits waits;

    public PageActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
    }

    public void click(By by) {
        waits.waitForElementToBeClickable(by).click();
    }
    public void click(WebElement webElement){
        waits.waitForElementToBeClickable(webElement).click();

    }
    public String getAttribute(WebElement element,String name){
        return element.getAttribute(name);
    }
    public void clickThroughJs(WebElement element){
        waits.waitForElementToBeClickable(element);
        JavascriptExecutor jse = (JavascriptExecutor) this.webDriver;
        jse.executeScript("arguments[0].click();", element);

    }
    public void clickWithKeyBoard(WebElement element){
        waits.waitForElementToBeClickable(element);
        element.sendKeys(Keys.ENTER);
    }
    public void type(By by, String value) {
        waits.waitForElementToBePresent(by).sendKeys(value);
    }
    public void type(WebElement webElement,String value){
        waits.waitForElementToBePresent(webElement).sendKeys(value);
    }
    public String getText(WebElement element) {
        return waits.waitForElementToBePresent(element).getText();
    }
    public void enter(By by){
        waits.waitForElementToBePresent(by).sendKeys(Keys.ENTER);
    }
    public void enter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }
    public void clearText(By by){
        waits.waitForElementToBePresent(by).clear();
    }
    public void clickBackSpaceUntilTextToBeClear(By by,String value){
        WebElement webElement= waits.waitForElementToBePresent(by);
        for(int i=0;i<value.length();i++){
            webElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clickChildLocator(WebElement webElement, By locator) {
       click(webElement.findElement(locator));
    }

    public String getText(WebElement element, By locatorValue) {
        return element.findElement(locatorValue).getText();
    }

    public String getJsText(WebElement element,By locatorValue) {
        return element.findElement(locatorValue).getAttribute("innerHTML");
    }
    public List<WebElement> getListOfElements(WebElement webElement,By locator){
        return webElement.findElements(locator);
    }
    public void moveToTheElementAndClick(WebElement element){
        Actions actions=new Actions(this.webDriver);
        actions.moveToElement(element).click();

    }
}
