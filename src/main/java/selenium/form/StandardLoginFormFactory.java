package selenium.form;

import org.openqa.selenium.By;

public class StandardLoginFormFactory implements FormFactory {
    @Override
    public Form createForm() {
        return new Form(
                new Field("misha.maznichko@ukr.net", By.xpath("//input[@id='email']")),
                new Field("maznich40", By.xpath("//input[@id='pass']")));
    }
}
