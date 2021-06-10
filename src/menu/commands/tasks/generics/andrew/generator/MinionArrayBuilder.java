package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.creatures.Minion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinionArrayBuilder {

    public static ArrayListGeneric<Minion> generateObject(Class<? extends Minion> classToCreate, MinionStringConstant side, int amount) {
        ArrayListGeneric<Minion> minions = new ArrayListGeneric<>();
        List<String> allFields = getClassFields(classToCreate);

        for (int i = 0; i < amount; i++) {
            try {
                Map<String, String> fieldsToClass = fillClassFields(allFields, side);
                Constructor<?> providedConstructor = classToCreate.getDeclaredConstructor(Map.class);
                providedConstructor.setAccessible(true);
                Object generateObject = providedConstructor.newInstance(fieldsToClass);

                minions.add((Minion) generateObject);
            } catch (NoSuchMethodException |
                    InstantiationException |
                    IllegalAccessException |
                    InvocationTargetException reflectiveOperationException) {
                reflectiveOperationException.printStackTrace();
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

    private static Map<String, String> fillClassFields(List<String> fields, MinionStringConstant side) {
        Map<String, String> minionMap = MinionUtils.generateMinionMap(side);
        Map<String, String> objectMap = new HashMap<>();

        for (String field : fields) {
            objectMap.put(field, minionMap.get(field));
        }
        return objectMap;
    }
}
