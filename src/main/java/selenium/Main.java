package selenium;

import selenium.webdriver.Browser;

public class Main {
    public static void main(String[] args) {
        FacebookFriendListParser parser = new FacebookFriendListParser(Browser.FIREFOX);
        try {
            parser.parse()
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
