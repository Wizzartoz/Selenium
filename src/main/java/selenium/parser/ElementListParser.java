package selenium.parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ElementListParser {
    private final WebDriver driver;

    public ElementListParser(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> parse(By selector) throws ParserException {
        List<WebElement> elements;
        try {
            elements = driver.findElements(selector);
        } catch (Exception e) {
            throw new ParserException("Failed to parse page");
        }
        return elements;
    }
}
