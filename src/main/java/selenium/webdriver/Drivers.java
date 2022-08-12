package selenium.webdriver;

import java.util.ResourceBundle;

public class Drivers {
    private static final ResourceBundle errors = ResourceBundle.getBundle("errors");

    public static WebDriverFactory create(String browser) {
        switch (browser) {
            case "firefox":
                return new FirefoxWebDriverFactory();
            case "chrome":
                throw new UnsupportedOperationException(errors.getString("chrome.factory.error"));
            default:
                throw new IllegalStateException(errors.getString("browser.factory.error"));
        }
    }
}
