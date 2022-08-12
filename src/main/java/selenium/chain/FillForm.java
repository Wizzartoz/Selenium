package selenium.chain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.form.Field;
import selenium.form.Form;

public class FillForm extends Reaching {
    private final Form form;
    private final By waitSelector;

    public FillForm(Form form, By waitSelector) {
        this.form = form;
        this.waitSelector = waitSelector;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute() {
        for (Field field : form.getFields()) {
            WebElement element = driver.findElement(field.getSelector());
            element.sendKeys(field.getInputText());
        }
        driver.findElement(form.getButton().getSelector()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSelector));
        checkNext();
    }
}
