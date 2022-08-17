package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.behavior.Behavior;
import selenium.behavior.BehaviorImpl;
import selenium.parser.ElementListParser;
import selenium.parser.ParserException;
import selenium.reach.chain.ReachingException;
import selenium.webdriver.Browser;
import selenium.webdriver.Driver;
import selenium.webdriver.WebDriverException;
import selenium.webdriver.WebDriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FacebookFriendListParser {

    private final ResourceBundle setting;

    public FacebookFriendListParser(Browser browser) {
        setting = ResourceBundle.getBundle(browser.getNameBundle());
    }

    public List<String> parse() throws Exception {
        WebDriver driver = getWebDriver();
        reachFriendList(driver);
        List<WebElement> elements = getHtmlElementList(driver);
        return parseFriendList(elements);
    }

    private List<WebElement> getHtmlElementList(WebDriver driver) throws ParserException {
        return new ElementListParser(driver)
                .parse(By.cssSelector(setting.getString("target.selector")));
    }

    private void reachFriendList(WebDriver driver) throws ReachingException {
        int duration;
        try {
            duration = Integer.parseInt(setting.getString("wait.duration"));
        } catch (IllegalArgumentException e) {
            duration = 10;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        Behavior behavior = new BehaviorImpl(ResourceBundle.getBundle(setting.getString("behavior.bundle")));
        behavior.setup().execute(driver, wait);
    }

    private WebDriver getWebDriver() throws WebDriverException {
        WebDriverFactory driverFactory = Driver.create(Browser.FIREFOX);
        WebDriver driver;
        try {
            driver = driverFactory.createWebDriver();
        } catch (Exception e) {
            throw new WebDriverException(e.getMessage());
        }
        return driver;
    }

    private List<String> parseFriendList(List<WebElement> elements) {
        return elements.stream()
                .map(element -> element.getAttribute(setting.getString("target.attribute")))
                .limit(Integer.parseInt(setting.getString("max.friends")))
                .collect(Collectors.toList());
    }
}
