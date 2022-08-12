package selenium.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class Form {
    private final List<Field> fields;

    public Form(Field field, Field... fields) {
        this.fields = new ArrayList<>();
        this.fields.add(field);
        this.fields.addAll(convertArrayToList(fields));
    }

    private List<Field> convertArrayToList(Field[] fields) {
        return Arrays.stream(fields)
                .sequential()
                .collect(Collectors.toList());
    }

    public void addField(Field field){
        fields.add(field);
    }


    public List<Field> getFields() {
        return Collections.unmodifiableList(fields);
    }

}
