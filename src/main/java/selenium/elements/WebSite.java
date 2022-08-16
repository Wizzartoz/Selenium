package selenium.elements;

import org.openqa.selenium.By;

public class WebSite {
    private String url;
    private By waitSelector;

    public WebSite(String url, By waitSelector) {
        this.url = url;
        this.waitSelector = waitSelector;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public By getWaitSelector() {
        return waitSelector;
    }

    public void setWaitSelector(By waitSelector) {
        this.waitSelector = waitSelector;
    }
}
