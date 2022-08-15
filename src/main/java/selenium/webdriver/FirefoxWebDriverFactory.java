package selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ResourceBundle;

public class FirefoxWebDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver createWebDriver() {
        ResourceBundle rb = ResourceBundle.getBundle(Browser.FIREFOX.getNameBundle());
        System.setProperty("webdriver.gecko.driver", rb.getString("web.driver.path"));
        return new FirefoxDriver();
    }
}
