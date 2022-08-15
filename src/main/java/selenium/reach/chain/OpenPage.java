package selenium.reach.chain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import selenium.form.Button;

public class OpenPage extends Reaching {
    private final Button button;

    public OpenPage(Button button) {
        this.button = button;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(WebDriver driver, Wait wait) {
        WebElement element = driver.findElement(button.getSelector());
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(button.getWaitSelector()));
        checkNext(driver,wait);
    }
}
