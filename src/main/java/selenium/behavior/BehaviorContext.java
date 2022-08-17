package selenium.behavior;

import org.openqa.selenium.By;
import selenium.elements.Button;
import selenium.elements.Field;
import selenium.elements.Form;
import selenium.elements.WebSite;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BehaviorContext {
    private final ResourceBundle setting;
    public List<Form> forms;
    public WebSite webSite;
    public List<Button> buttons;

    public BehaviorContext(ResourceBundle setting) {
        forms = new ArrayList<>();
        buttons = new ArrayList<>();
        this.setting = setting;
    }

    public void init() {
        setupFormList();
        setupWebSite();
        setupButtonList();

    }

    private void setupFormList() {
        this.forms.add(new Form()
                .addField(new Field(setting.getString("form.login"),
                        By.xpath(setting.getString("form.login.wait"))))
                .addField(new Field(setting.getString("form.password"),
                        By.xpath(setting.getString("form.password.wait")))));
    }

    private void setupWebSite() {
        this.webSite = new WebSite(setting.getString("website"), By.id(setting.getString("website.wait")));
    }

    private void setupButtonList() {
        this.buttons.add(new Button(By.xpath(setting.getString("button.login")),
                By.xpath(setting.getString("button.login.wait"))));
        this.buttons.add(new Button(By.xpath(setting.getString("button.all.friends")),
                By.xpath(setting.getString("button.all.friends.wait"))));
        this.buttons.add(new Button(By.xpath(setting.getString("button.my.friends")),
                By.cssSelector(setting.getString("button.my.friends.wait"))));
    }
}
