package selenium.parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.behavior.Behavior;
import selenium.behavior.BehaviorImpl;
import selenium.webdriver.Browser;
import selenium.webdriver.Drivers;
import selenium.webdriver.WebDriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FacebookFriendsParser {
    private WebDriver driver;
    private static final int MAX_FRIENDS_COUNT = 20;
    private static final String TARGET_ATTRIBUTE = "aria-label";
    private static final String TARGET_SELECTOR = ".sxpk6l6v .pzggbiyp [aria-label]";

    public List<String> parse() {
        setWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Behavior behavior = new BehaviorImpl(ResourceBundle.getBundle("firefox_behavior"));
        behavior.setup().execute(driver,wait);
        List<WebElement> elements = new ElementsParser(driver).parse(By.cssSelector(TARGET_SELECTOR));
        return parseFriends(elements);
    }

    private void setWebDriver() {
        WebDriverFactory driverFactory = Drivers.create(Browser.FIREFOX);
        this.driver = driverFactory.createWebDriver();
    }

    private List<String> parseFriends(List<WebElement> elements) {
        return elements.stream()
                .map(element -> element.getAttribute(TARGET_ATTRIBUTE))
                .limit(MAX_FRIENDS_COUNT)
                .collect(Collectors.toList());
    }
}
