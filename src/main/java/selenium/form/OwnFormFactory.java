package selenium.form;

public class OwnFormFactory implements FormFactory {
    @Override
    public Form createForm() {
        return new Form();
    }
}
