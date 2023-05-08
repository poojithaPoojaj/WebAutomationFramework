package framework.ultralesson.webautomation.drivers.managers;

import framework.ultralesson.webautomation.drivers.managers.DriverManager;
import framework.ultralesson.webautomation.internal.Toggles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements DriverManager<WebDriver> {
    @Override
    public WebDriver create() {

        if (Toggles.HEADLESS.isOn()) {
            return createHeadlessChromeDriver();
        }
        return new ChromeDriver(getChromeDriver());
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
    public ChromeOptions getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}


