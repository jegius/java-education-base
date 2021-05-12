package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.creatures.Minion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MinionArrayBuilder {

    public static ArrayListGeneric<Minion> generateObject(Class<? extends Minion> classToCreate, String side, int amount) {
        ArrayListGeneric<Minion> minions = new ArrayListGeneric<>();
//        List<String> allFields = getClassFields(classToCreate);
        for (int i = 0; i < amount; i++) {
            try {
                Map<String, String> minionMap = MinionUtils.generateMinionMap(side);
                Constructor<?> providedConstructor = classToCreate.getDeclaredConstructor(Map.class);
                providedConstructor.setAccessible(true);
                Object generateObject = providedConstructor.newInstance(minionMap);
                minions.add((Minion) generateObject);
            } catch (NoSuchMethodException |
                    InstantiationException |
                    IllegalAccessException |
                    InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return minions;
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

    private static void fillClassFields(List<String> fields, String side) {
        Map<String, String> minionMap = MinionUtils.generateMinionMap(side);

    }
}
