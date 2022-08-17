package selenium.webdriver;

public class WebDriverException extends Exception{

    public WebDriverException() {
    }

    public WebDriverException(String message) {
        super(message);
    }

    public WebDriverException(String message, Throwable cause) {
        super(message, cause);
    }
}
