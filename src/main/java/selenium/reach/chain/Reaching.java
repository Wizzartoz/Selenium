package selenium.reach.chain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;



public abstract class Reaching {
    private Reaching next;

    public abstract void execute(WebDriver driver, Wait wait);

    public static Reaching linkWith(Reaching first, Reaching... chain) {
        Reaching head = first;
        for (Reaching nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public void checkNext(WebDriver driver, Wait wait) {
        if (next != null) {
            next.execute(driver,wait);
        }
    }

}
