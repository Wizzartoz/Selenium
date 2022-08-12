package selenium.chain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class OpenWebSite extends Reaching {
    private final String url;
    private final By waitSelector;

    public OpenWebSite(String url, By waitSelector) {
        this.url = url;
        this.waitSelector = waitSelector;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(WebDriver driver, Wait wait) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSelector));
        checkNext(driver,wait);
    }
}
