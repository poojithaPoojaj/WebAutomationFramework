package framework.ultralesson.webautomation.drivers.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxMobileEmulationManager implements DriverManager<WebDriver> {
    public WebDriver create() {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-width=375", "-height=812");
        options.setCapability("moz:firefoxOptions", options);
        return new FirefoxDriver(options);
    }
}
