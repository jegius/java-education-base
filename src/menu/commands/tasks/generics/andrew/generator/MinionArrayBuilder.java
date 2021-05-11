package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.creatures.Minion;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MinionArrayBuilder {

    public static void generateObject(Class<? extends Minion> classToCreate) {
        List<String> allFields = getClassFields(classToCreate);

        for (String field : allFields) {
            System.out.println(field);
        }
    }

    private static List<String> getClassFields(Class<?> providedClass) {
        List<String> allFields = new ArrayList<>();
        Class<?> currentClass = providedClass;
        do {
            for (Field field : currentClass.getDeclaredFields()) {
                allFields.add(field.getName());
            }
            currentClass = currentClass.getSuperclass();
        } while (currentClass.getSuperclass() != null);
        return allFields;
    }

    private static void fillClassFields(List<String> fields){

    }
}
