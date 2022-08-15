package selenium.parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class ElementsParser {
    private final WebDriver driver;

    public ElementsParser(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> parse(By selector) {
        return driver.findElements(selector);
    }
}
