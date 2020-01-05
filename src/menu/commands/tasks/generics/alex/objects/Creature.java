package menu.commands.tasks.generics.alex.objects;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Creature {

    protected HashMap<Field, String> getFields(Class providedClass) {
        HashMap<Field, String> allClassesFields = new HashMap<>();
            Field[] fields = providedClass.getDeclaredFields();
            for (Field field : fields) {
                allClassesFields
                        .put(field, field
                                .getName());
            }
        return allClassesFields;
    }

    protected void fillFields(Class providedClass, Object objectToComplete, Map<String, String> values) {
        HashMap<Field, String> fields;
        fields = getFields(providedClass);
        for (Field field : fields.keySet()) {
            try {
                field.set(objectToComplete, values.get(fields.get(field)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
