package selenium.behavior;

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
