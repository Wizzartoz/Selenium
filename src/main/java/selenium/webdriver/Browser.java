package selenium.webdriver;

public enum Browser {
    FIREFOX("firefox"), CHROME("chrome");

    Browser(String nameBundle) {
        this.nameBundle = nameBundle;
    }

    private final String nameBundle;

    public String getNameBundle() {
        return nameBundle;
    }
}
