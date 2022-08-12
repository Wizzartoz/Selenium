package selenium.chain;

import org.openqa.selenium.WebElement;
import selenium.form.Field;
import selenium.form.Form;

public class FillForm extends Reaching {
    private final Form form;

    public FillForm(Form form) {
        this.form = form;
    }

    @Override
    public void execute() {
        for (Field field : form.getFields()) {
            WebElement element = driver.findElement(field.getSelector());
            element.sendKeys(field.getInputText());
        }
        checkNext();
    }
}
