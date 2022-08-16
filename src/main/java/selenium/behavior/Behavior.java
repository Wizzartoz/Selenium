package selenium.behavior;

import selenium.reach.chain.Reaching;

import java.util.ResourceBundle;

public abstract class
Behavior {
    protected ResourceBundle setting;

    public Behavior(ResourceBundle setting) {
        this.setting = setting;
    }

    public abstract Reaching setup();
}
