package selenium.elements;

import org.openqa.selenium.By;

public class Button {
    private final By selector;
    private final By waitSelector;

    public Button(By selector, By waitSelector) {
        this.selector = selector;
        this.waitSelector = waitSelector;
    }

    public By getSelector() {
        return selector;
    }

    public By getWaitSelector() {
        return waitSelector;
    }
}
