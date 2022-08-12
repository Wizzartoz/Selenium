package selenium.form;

import org.openqa.selenium.By;

public class Field {
    private final String inputText;
    private final By selector;

    public Field(String inputText, By selector) {
        this.inputText = inputText;
        this.selector = selector;
    }

    public String getInputText() {
        return inputText;
    }

    public By getSelector() {
        return selector;
    }

}
