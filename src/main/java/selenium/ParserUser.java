package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.chain.FillForm;
import selenium.chain.OpenPage;
import selenium.chain.OpenWebSite;
import selenium.chain.Reaching;
import selenium.form.Button;
import selenium.form.Form;
import selenium.form.FormFactory;
import selenium.form.StandardLoginFormFactory;
import selenium.webdriver.Drivers;
import selenium.webdriver.WebDriverFactory;

import java.time.Duration;
import java.util.ResourceBundle;

public class ParserUser {

    public void parse() {
        ResourceBundle config = ResourceBundle.getBundle("config");
        ResourceBundle setting = ResourceBundle.getBundle(config.getString("browser"));
        WebDriverFactory driverFactory = Drivers.create(config.getString("browser"));
        WebDriver driver = driverFactory.createWebDriver();

        FormFactory factory = new StandardLoginFormFactory();
        Form form = factory.createForm();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Reaching reaching = Reaching.linkWith(
                new OpenWebSite(setting.getString("website"), By.id(setting.getString("wait.website.page.selector"))),
                new FillForm(form, By.xpath(setting.getString("wait.fill.form"))),
                new OpenPage(new Button(By.xpath(setting.getString("all.friends.page.selector")),
                        By.xpath(setting.getString("wait.all.friends.selector")))),
                new OpenPage(new Button(By.xpath(setting.getString("my.friends.page.selector")),
                        By.id(setting.getString("wait.my.friends.page.selector")))));
        reaching.setDriver(driver);
        reaching.setWait(wait);
        reaching.execute();

//        List<WebElement> facebookFriends = driver.findElements(By.cssSelector(".sxpk6l6v a[href^=\"https://www.facebook.com/profile.php?id=\"]"));
//        for (WebElement element : facebookFriends) {
//            System.out.println(element.getAttribute("href"));

    }

}
