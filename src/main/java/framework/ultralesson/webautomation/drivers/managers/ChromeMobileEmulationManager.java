package framework.ultralesson.webautomation.drivers.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class ChromeMobileEmulationManager implements DriverManager<WebDriver> {
    public WebDriver create() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        return new ChromeDriver(options);
    }
}