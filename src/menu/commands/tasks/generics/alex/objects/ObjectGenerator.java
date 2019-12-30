package menu.commands.tasks.generics.alex.objects;

import menu.commands.tasks.generics.alex.AlexGenArrayList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.commands.tasks.generics.alex.objects.FieldsNames.*;

public class ObjectGenerator {

    private static HashMap<String, String[]> valuesForObjects = completeMap();

    private static HashMap<String, String[]> completeMap() {
        HashMap<String, String[]> completedMap = new HashMap<>();
        completedMap.put(NAME.getName(),
                new String[]{
                        "Alex",
                        "John",
                        "Michale",
                        "Jessica",
                        "Max",
                        "Pidr"
                });
        completedMap.put(SUBJECT.getName(),
                new String[]{
                        "Math",
                        "English",
                        "History",
                        "Literature",
                        "Biology",
                        "Java"
                });
       completedMap.put(JOB.getName(),
                new String[]{
                        "Programmer",
                        "Teacher",
                        "Engineer",
                        "Actor",
                        "Football player",
                        "Whore"
                });
        completedMap.put(NICKNAME.getName(),
                new String[]{
                        "Barky",
                        "Luci",
                        "Max",
                        "Tyson",
                        "Spark",
                        "Sharky"
                });
        completedMap.put(AREA.getName(),
                new String[]{
                        "City",
                        "Forest",
                        "Village",
                        "Swamp",
                        "Shore",
                        "Near trash"
                });
        completedMap.put(FAMILY_NAME.getName(),
                new String[]{
                        "Jacksons",
                        "Nicksons",
                        "Willis",
                        "Aflecks",
                        "Andersons",
                        "Jolies"
                });
        return completedMap;
    }

    private static int getRandomNumber(String field) {
        int max = valuesForObjects.get(field).length;
        return (int) (Math.random() * max);
    }

    private static List<String> getAllFields(Class providedClass) {
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

    private static Map fillFields(List<String> fields) {
        Map<String, String> values = new HashMap<>();
        for (String field : fields) {
            values.put(field, valuesForObjects.get(field)[getRandomNumber(field)]);
        }
        return values;
    }

    public static <T> ArrayBuilder<T> newArrayBuilder() {
        return new ArrayBuilder<T>();
    }

    public static class ArrayBuilder<T> {
        private AlexGenArrayList objects = null;

        private ArrayBuilder() {
        }

        public ArrayBuilder<T> generateObjects(int amount, Class<? extends Creature> classToCreate) {
            if (objects == null) {
                objects = new AlexGenArrayList<>();
            }
            List allFields = getAllFields(classToCreate);
            try {
                Constructor providedConstructor = classToCreate.getDeclaredConstructor(Map.class);
                providedConstructor.setAccessible(true);
                for (int index = 0; index < amount; index++) {
                    Map values = fillFields(allFields);
                    objects.add(providedConstructor.newInstance(values));
                }
            } catch (NoSuchMethodException
                    | IllegalAccessException
                    | InstantiationException
                    | InvocationTargetException e) {
                e.printStackTrace();
            }
            return this;
        }

        public AlexGenArrayList<T> build() {
            AlexGenArrayList<T> generatedObjects = objects;
            objects = null;
            return generatedObjects;
        }
    }
}