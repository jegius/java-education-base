package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.creatures.Minion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MinionArrayBuilder {

    public static void generateObject(Class<? extends Minion> classToCreate) {
        List<String> allFields = getClassFields(classToCreate);
//        for (String field : allFields) {
//            System.out.println(field);
//        }
        try {
            Constructor<?> providedConstructor = classToCreate.getDeclaredConstructor(
                    String.class,
                    String.class,
                    int.class,
                    int.class,
                    int.class);
            providedConstructor.setAccessible(true);
            Object test = providedConstructor.newInstance("Light",
                    MinionUtils.generateName("Light"),
                    MinionUtils.generateAge(),
                    MinionUtils.generatePower(),
                    MinionIntEnum.MINION_HP.getValue());
            System.out.println(test);
        } catch (NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
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

    private static void fillClassFields(List<String> fields) {

    }
}
