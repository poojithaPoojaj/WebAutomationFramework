package framework.ultralesson.webautomation.drivers.managers;

import framework.ultralesson.webautomation.drivers.managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class FireFoxDriverManager implements DriverManager<WebDriver> {

    @Override
    public WebDriver create() {
        return new io.github.bonigarcia.wdm.managers.FirefoxDriverManager().create();
    }
}
