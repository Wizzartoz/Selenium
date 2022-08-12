package selenium.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Form {
    private final List<Field> fields;
    private final Button button;

    public Form(Button button, Field field, Field... fields) {
        this.button = button;
        this.fields = new ArrayList<>();
        this.fields.add(field);
        this.fields.addAll(convertArrayToList(fields));
    }

    private List<Field> convertArrayToList(Field[] fields) {
        return Arrays.stream(fields)
                .sequential()
                .collect(Collectors.toList());
    }

    public List<Field> getFields() {
        return fields;
    }

    public Button getButton() {
        return button;
    }
}
