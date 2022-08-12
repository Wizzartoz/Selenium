package selenium.chain;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.form.Button;

public class OpenPage extends Reaching {
    private final Button button;

    public OpenPage(Button button) {
        this.button = button;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute() {
        WebElement element = driver.findElement(button.getSelector());
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(button.getWaitSelector()));
        checkNext();
    }
}
