package framework.ultralesson.webautomation.pages;

import framework.ultralesson.webautomation.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver webDriver;
    By searchBar=By.id("twotabsearchtextbox");

    By searchResults=By.cssSelector("div.s-suggestion-container");
    By searchResultsContainer=By.className("left-pane-results-container");
    By recentSearches=By.className("s-recentSearchDistinct");
    public HomePage(WebDriver driver) {
        this.webDriver=driver;
    }
    public HomePage search(String searchItem){
        webDriver.findElement(searchBar).click();
        webDriver.findElement(searchBar).sendKeys(searchItem);
        return this;

    }

    public List<Item> getSearchItems() {
        List<WebElement> elements =webDriver.findElements(recentSearches);
        List<Item> items = new ArrayList<>();
        for(WebElement element : elements) {
            String name = element.getText();
            Item item = new Item();
            item.setName(name);
            items.add(item);
        }
        return items;
    }
}
