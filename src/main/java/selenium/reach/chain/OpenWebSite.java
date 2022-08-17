package selenium.reach.chain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import selenium.elements.WebSite;

public class OpenWebSite extends Reaching {

    private final WebSite site;

    public OpenWebSite(WebSite site) {
        this.site = site;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(WebDriver driver, Wait wait) throws ReachingException {
        try {
            driver.get(site.getUrl());
            wait.until(ExpectedConditions.visibilityOfElementLocated(site.getWaitSelector()));
        } catch (Exception e) {
            throw new ReachingException("Failed to open website");
        }
        checkNext(driver, wait);
    }
}
