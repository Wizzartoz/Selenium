package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.webdriver.Drivers;
import selenium.webdriver.WebDriverFactory;

import java.util.List;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle config = ResourceBundle.getBundle("config");
        ResourceBundle setting = ResourceBundle.getBundle(config.getString("browser"));
        WebDriverFactory driverFactory = Drivers.create(config.getString("browser"));
        WebDriver driver = driverFactory.createWebDriver();
        ReachPage page = new ReachPage(driver,setting);
        page.reach();
        Parser user = new Parser(driver);
        List<WebElement> elements = user.parse(By.cssSelector(".sxpk6l6v .pzggbiyp [aria-label]"));
        for (WebElement element : elements) {
            System.out.println(element.getAttribute("aria-label"));
        }
    }
}
