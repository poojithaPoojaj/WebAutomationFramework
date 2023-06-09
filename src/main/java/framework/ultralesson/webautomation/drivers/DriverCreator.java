package framework.ultralesson.webautomation.drivers;

import framework.ultralesson.webautomation.drivers.managers.*;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DriverCreator {

    public WebDriver create(String browser) {
        browser = setDefaultBrowser(browser);
        switch (browser.toLowerCase()) {
            case "firefox":
               return new FireFoxDriverManager().create();

            case "edge":
                return new EdgeDriverManager().create();
            default:
                WebDriver driver = new ChromeDriverManager().create();
                return driver;
        }
    }

        private String setDefaultBrowser(String browser) {
            if(Objects.isNull(browser) || browser.isEmpty()) {
                browser = "chrome";
            }
            return browser;
        }
    public WebDriverContext createDriverContext(String browser) {
        browser = setDefaultBrowser(browser);
        DriverManager<WebDriver> webDriverDriverManager = getBrowserManagers().get(browser);
        return new WebDriverContext(webDriverDriverManager);
    }

    // Build a Browser Managers Map
    public Map<String, DriverManager<WebDriver>> getBrowserManagers() {
        Map<String,DriverManager<WebDriver>> driverManagerMap = new HashMap<>();
        driverManagerMap.put("chrome", new framework.ultralesson.webautomation.drivers.managers.ChromeDriverManager());
        driverManagerMap.put("firefox", new FireFoxDriverManager());
        driverManagerMap.put("edge", new framework.ultralesson.webautomation.drivers.managers.EdgeDriverManager());
        driverManagerMap.put("chrome-mobile",new ChromeMobileEmulationManager());
        driverManagerMap.put("firefox-mobile",new FireFoxMobileEmulationManager());
        return driverManagerMap;
    }


}
