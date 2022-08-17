package selenium.reach.chain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import selenium.elements.Button;

public class OpenPage extends Reaching {
    private final Button button;

    public OpenPage(Button button) {
        this.button = button;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(WebDriver driver, Wait wait) throws ReachingException {
        try {
            WebElement element = driver.findElement(button.getSelector());
            element.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(button.getWaitSelector()));
        } catch (Exception e){
            throw new ReachingException("Failed to open page");
        }
        checkNext(driver,wait);
    }
}
