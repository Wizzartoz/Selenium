package selenium.form;

import org.openqa.selenium.By;

public class StandardLoginFormFactory implements FormFactory {
    @Override
    public Form createForm() {
        return new Form(
                new Button(By.xpath("//div[@class='_6ltg']/button[@name='login']"),By.xpath("//a[@href='/friends/']")),
                new Field("misha.maznichko@ukr.net", By.xpath("//input[@id='email']"), Type.FIELD),
                new Field("maznich40", By.xpath("//input[@id='pass']"), Type.FIELD));
    }
    ////div[@class='_6ltg']/button[@name='login']
    ////a[@href='/friends/']
}
