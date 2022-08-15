package selenium;

import selenium.parser.FacebookFriendsParser;

public class Main {
    public static void main(String[] args) {
        FacebookFriendsParser parser = new FacebookFriendsParser();
        parser.parse()
                .forEach(System.out::println);
    }
}
