package menu.commands.tasks.generics.max;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static menu.commands.tasks.generics.max.EnumForMonsters.*;

public class GeneratorMonster {

    private HashMap<String, String[]> values = fillValues();

    private HashMap<String, String[]> fillValues() {

        HashMap<String, String[]> completedValues = new HashMap<>();

        completedValues.put(MONSTERS_NAME.getFieldName(), new String[]{
                "Bob",
                "Rob",
                "Jimmy",
                "Hector",
                "Lars",
                "Rick"
        });
        completedValues.put(GHOSTS_NAME.getFieldName(), new String[]{
                "Satan Ass",
                "Hells Cock",
                "Pidr",
                "Kek",
                "Lol",
                "Pirozhok"
        });
        completedValues.put(ZOMBIES_DEGREE_DEATH.getFieldName(), new String[]{
                "Dead",
                "Undead",
                "Half-dead"
        });
        completedValues.put(VAMPIRE_VULNERABILITY.getFieldName(), new String[]{
                "Afraid of garlic",
                "Afraid of Sun"
        });
        completedValues.put(ANGEL_WINGS.getFieldName(), new String[]{
                "Pigeon wings",
                "Eagle wings"
        });
        completedValues.put(DEMON_HORNS.getFieldName(), new String[]{
                "Cropped horns",
                "Lamb horns"
        });
        return completedValues;
    }

    private int getRandomNumber (String field) {
        return (int) Math.floor(Math.random() * values.get(field).length);
    }

    public List<String> getAllFields(Class providedClass) {
        List<String> allFields = new ArrayList<>();
        Class currentClass = providedClass;
        do {
            Field[] fields = currentClass.getDeclaredFields();
                for (Field field : fields) {
                    allFields.add(field.getName());
                }
            currentClass = currentClass.getSuperclass();
        }
        while (currentClass.getSuperclass() != null);
        return allFields;
    }

    private List<String> fillAllFields(List<String> providedField) {
        List<String> filledFields = new ArrayList<>();
        for (String currentField : providedField) {
            filledFields.add(values.get(currentField)[getRandomNumber(currentField)]);
        }
        return filledFields;
    }

    private static ArrayBuilder arrayBuilder;

    public ArrayBuilder getArrayBuilder() {
        if (arrayBuilder == null) {
            arrayBuilder = new ArrayBuilder();
        }
        return arrayBuilder;
    }

    public class ArrayBuilder {
        MaxArrayListGeneric<Object> objects;

        public ArrayBuilder generateMonsters(int amount, Class providedClass) {
            if (objects == null) {
                objects = new MaxArrayListGeneric<>();
            }
            List<String> fields = getAllFields(providedClass);
            try {
                Constructor providedConstructor = providedClass.getDeclaredConstructor(List.class);
                providedConstructor.setAccessible(true);
                for (int index = 0; index < amount; index++) {
                    List<String> filledFields = fillAllFields(fields);
                    objects.add(providedConstructor.newInstance(filledFields));
                }
            } catch (NoSuchMethodException
                    | IllegalAccessException
                    | InstantiationException
                    | InvocationTargetException
                    e) {
                e.printStackTrace();
            }
            return this;
        }

        public MaxArrayListGeneric<Object> build() {
            MaxArrayListGeneric<Object> tempObjects = objects;
            objects = null;
            return tempObjects;
        }
    }
}
