package menu.commands.tasks.generics.alex.objects;

import menu.commands.tasks.generics.alex.AlexGenArrayList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjectGenerator {

    HashMap<String, String[]> valuesForObjects = new HashMap<>();

    private void completeMap() {
        valuesForObjects.put("name",
                new String[]{
                        "Alex",
                        "John",
                        "Michale",
                        "Jessica",
                        "Max",
                        "Pidr"
                });
        valuesForObjects.put("subject",
                new String[]{
                        "Math",
                        "English",
                        "History",
                        "Literature",
                        "Biology",
                        "Java"
                });
        valuesForObjects.put("job",
                new String[]{
                        "Programmer",
                        "Teacher",
                        "Engineer",
                        "Actor",
                        "Football player",
                        "Whore"
                });
        valuesForObjects.put("nickName",
                new String[]{
                        "Barky",
                        "Luci",
                        "Max",
                        "Tyson",
                        "Spark",
                        "Sharky"
                });
        valuesForObjects.put("area",
                new String[]{
                        "City",
                        "Forest",
                        "Village",
                        "Swamp",
                        "Shore",
                        "Near trash"
                });
        valuesForObjects.put("familyName",
                new String[]{
                        "Jacksons",
                        "Nicksons",
                        "Willis",
                        "Aflecks",
                        "Andersons",
                        "Jolies"
                });
    }

    private int getRandomNumber() {
        int max = 5;
        return (int) (Math.random() * max);
    }

    public ObjectGenerator() {
        completeMap();
    }

    private List<String> getAllFields(Class cls) {
        List<String> allFields = new ArrayList<>();
        Class currentClass = cls;
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

    private List fillFields(List<String> fields) {
        List<String> values = new ArrayList();
        for (String field : fields) {
            values.add(valuesForObjects.get(field)[getRandomNumber()]);
        }
        return values;
    }

    public ObjectGenerator generateObjects(AlexGenArrayList list, int amount, Class<? extends Creature> cls) {
        List allFields = getAllFields(cls);
        try {
            Constructor ctor = cls.getDeclaredConstructor(List.class);
            ctor.setAccessible(true);
            for (int index = 0; index < amount; index++) {
                List values = fillFields(allFields);
                list.add(ctor.newInstance(values));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return this;
    }
}