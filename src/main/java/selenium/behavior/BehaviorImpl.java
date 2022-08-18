package selenium.behavior;

import selenium.reach.chain.FillForm;
import selenium.reach.chain.OpenPage;
import selenium.reach.chain.OpenWebSite;
import selenium.reach.chain.Reaching;

import java.util.ResourceBundle;

public class BehaviorImpl implements Behavior {

    private final ResourceBundle setting;

    public BehaviorImpl(ResourceBundle setting) {
        this.setting = setting;
    }

    @Override
    public Reaching setup() {
        BehaviorContext elements = new BehaviorContext(setting);
        elements.init();
        return Reaching.linkWith(
                new OpenWebSite(elements.webSite),
                new FillForm(elements.forms.get(0)),
                new OpenPage(elements.buttons.get(0)),
                new OpenPage(elements.buttons.get(1)),
                new OpenPage(elements.buttons.get(2)));
    }
}
