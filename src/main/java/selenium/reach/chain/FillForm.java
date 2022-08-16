package selenium.reach.chain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import selenium.elements.Field;
import selenium.elements.Form;

public class FillForm extends Reaching {
    private final Form form;

    public FillForm(Form form) {
        this.form = form;
    }

    @Override
    public void execute(WebDriver driver, Wait wait) {
        for (Field field : form.getFields()) {
            WebElement element = driver.findElement(field.getSelector());
            element.sendKeys(field.getInputText());
        }
        checkNext(driver,wait);
    }
}
