package framework.ultralesson.webautomation.drivers.managers;

import framework.ultralesson.webautomation.drivers.managers.DriverManager;
import framework.ultralesson.webautomation.internal.Toggles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManager<WebDriver> {
    @Override
    public WebDriver create() {

        if (Toggles.HEADLESS.isOn()) {
            return createHeadlessChromeDriver();
        }
        return new io.github.bonigarcia.wdm.managers.ChromeDriverManager().create();
    }

    private ChromeDriver createHeadlessChromeDriver() {
        new io.github.bonigarcia.wdm.managers.ChromeDriverManager().setup();
        ChromeOptions chromeOptions = getHeadlessChromeOptions();
        return new ChromeDriver(chromeOptions);
    }

    private ChromeOptions getHeadlessChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        return chromeOptions;
    }
}


