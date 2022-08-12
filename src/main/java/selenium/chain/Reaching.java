package selenium.chain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public abstract class Reaching {
    protected static WebDriver driver;
    protected static Wait wait;
    private Reaching next;

    public abstract void execute();

    public static Reaching linkWith(Reaching first, Reaching... chain) {
        Reaching head = first;
        for (Reaching nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public void setDriver(WebDriver driver) {
        Reaching.driver = driver;
    }

    public void setWait(Wait wait) {
        Reaching.wait = wait;
    }

    public void checkNext() {
        if (next != null) {
            next.execute();
        }
    }

}
