package selenium.form;

import org.openqa.selenium.By;

public class Field {
    private final String inputText;
    private final By selector;
    private final Enum<Type> type;

    public Field(String inputText, By selector, Enum<Type> type) {
        this.inputText = inputText;
        this.selector = selector;
        this.type = type;
    }

    public String getInputText() {
        return inputText;
    }

    public By getSelector() {
        return selector;
    }

    public Enum<Type> getType() {
        return type;
    }
}
