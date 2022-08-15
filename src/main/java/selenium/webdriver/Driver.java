package selenium.webdriver;

import java.util.ResourceBundle;

public class Driver {
    private static final ResourceBundle errors = ResourceBundle.getBundle("errors");

    public static WebDriverFactory create(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return new FirefoxWebDriverFactory();
            case CHROME:
                throw new UnsupportedOperationException(errors.getString("chrome.factory.error"));
            default:
                throw new IllegalStateException(errors.getString("browser.factory.error"));
        }
    }
}
