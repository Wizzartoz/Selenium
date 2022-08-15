package selenium;

public class Main {
    public static void main(String[] args) {
        FacebookFriendListParser parser = new FacebookFriendListParser();
        parser.parse()
                .forEach(System.out::println);
    }
}
