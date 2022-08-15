package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.behavior.Behavior;
import selenium.behavior.BehaviorImpl;
import selenium.parser.ElementListParser;
import selenium.webdriver.Browser;
import selenium.webdriver.Driver;
import selenium.webdriver.WebDriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FacebookFriendListParser {
    private WebDriver driver;
    private final ResourceBundle setting;

    public FacebookFriendListParser() {
        setting = ResourceBundle.getBundle(Browser.FIREFOX.getNameBundle());
    }

    public List<String> parse() {
        setWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Behavior behavior = new BehaviorImpl(ResourceBundle.getBundle("firefox_behavior"));
        behavior.setup().execute(driver, wait);
        List<WebElement> elements = new ElementListParser(driver).parse(By.cssSelector(setting.getString("target.selector")));
        return parseFriendList(elements);
    }

    private void setWebDriver() {
        WebDriverFactory driverFactory = Driver.create(Browser.FIREFOX);
        this.driver = driverFactory.createWebDriver();
    }

    private List<String> parseFriendList(List<WebElement> elements) {
        return elements.stream()
                .map(element -> element.getAttribute(setting.getString("target.attribute")))
                .limit(Integer.parseInt(setting.getString("max.friends")))
                .collect(Collectors.toList());
    }
}
