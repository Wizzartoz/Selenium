package selenium.webdriver;

import java.util.ResourceBundle;

public class Driver {
    private static final ResourceBundle errors = ResourceBundle.getBundle("errors");

    public static WebDriverFactory create(Browser browser) throws WebDriverException {
        switch (browser) {
            case FIREFOX:
                return new FirefoxWebDriverFactory();
            case CHROME:
                throw new WebDriverException(errors.getString("chrome.factory.error"));
            default:
                throw new WebDriverException(errors.getString("browser.factory.error"));
        }
    }
}
