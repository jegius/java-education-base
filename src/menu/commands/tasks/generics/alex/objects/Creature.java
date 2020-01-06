package menu.commands.tasks.generics.alex.objects;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Creature {

    protected HashMap<Field, String> getFields(Class providedClass) {
        Class currentClass = providedClass;
        HashMap<Field, String> allClassesFields = new HashMap<>();
        do {
            Field[] fields = currentClass.getDeclaredFields();
            for (Field field : fields) {
                allClassesFields.put(field, field.getName());
            }
            currentClass = currentClass.getSuperclass();
        } while (currentClass != null);
        return allClassesFields;
    }

    protected void fillFields(Object objectToComplete, Map<String, String> values) {
        HashMap<Field, String> fields = getFields(objectToComplete.getClass());
        for (Field field : fields.keySet()) {
            try {
                field.set(objectToComplete, values.get(fields.get(field)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
