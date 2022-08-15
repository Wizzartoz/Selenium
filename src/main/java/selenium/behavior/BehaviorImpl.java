package selenium.behavior;

import org.openqa.selenium.By;
import selenium.form.*;
import selenium.reach.chain.FillForm;
import selenium.reach.chain.OpenPage;
import selenium.reach.chain.OpenWebSite;
import selenium.reach.chain.Reaching;

import java.util.ResourceBundle;

public class BehaviorImpl extends Behavior {


    public BehaviorImpl(ResourceBundle setting) {
        super(setting);
    }

    @Override
    public Reaching setup() {
        Form loginForm = new Form()
                .addField(new Field(
                        setting.getString("form.login"),
                        By.xpath(setting.getString("form.login.wait"))))
                .addField(new Field(
                        setting.getString("form.password"),
                        By.xpath(setting.getString("form.password.wait"))));
        Button loginButton = new Button(By.xpath(
                setting.getString("button.login")),
                By.xpath(setting.getString("button.login.wait")));
        Button allFriendButton = new Button(By.xpath(setting.getString("button.all.friends")),
                By.xpath(setting.getString("button.all.friends.wait")));
        Button myFriendsButton = new Button(By.xpath(setting.getString("button.my.friends")),
                By.cssSelector(setting.getString("button.my.friends.wait")));
        return Reaching.linkWith(
                new OpenWebSite(
                        setting.getString("website"),
                        By.id(setting.getString("website.wait"))),
                new FillForm(loginForm),
                new OpenPage(loginButton),
                new OpenPage(allFriendButton),
                new OpenPage(myFriendsButton));
    }
}
