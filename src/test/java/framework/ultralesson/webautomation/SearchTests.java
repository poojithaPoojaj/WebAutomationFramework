package framework.ultralesson.webautomation;

import framework.ultralesson.webautomation.drivers.DriverCreator;
import framework.ultralesson.webautomation.models.Item;
import framework.ultralesson.webautomation.pages.HomePage;
import framework.ultralesson.webautomation.pages.LauncherPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    @Test
    public void verifyIfSearchItemShowReleventResults() {

        String searchItem = "Jeans";
        String searchKey = "jeans";
        String browser = "edge";

        WebDriver webDriver = new DriverCreator().create(browser);
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://www.amazon.com/");
        HomePage homePage=new HomePage(webDriver);
        homePage.search(searchItem);
        List<Item> resultItems=homePage.getSearchItems();
        Assert.assertEquals(resultItems.size(),4);
//        Assert.assertTrue(resultItems.stream().allMatch(product -> product.getName().toLowerCase().contains(searchKey.toLowerCase())));
    }
}
