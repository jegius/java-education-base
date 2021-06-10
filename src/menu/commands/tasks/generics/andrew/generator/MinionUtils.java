package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.creatures.Minion;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MinionUtils {

    private static final String[] humanNames =
            {"Alex", "Alan", "Bob", "Martin", "Sebastian", "Borris", "Donald", "Max", "Samson", "Ivan"};
    private static final String[] orcNames =
            {"Azog", "Lurk", "Ugluk", "Narzug", "Boldog", "Guzruk", "Loctar", "Usgod", "Marruk", "Zughog"};

    public static void minionsInfo(ArrayListGeneric<Minion> minions) {
        for (int i = 0; i < minions.size(); i++) {
            Minion trooper = minions.get(i);

            System.out.println(trooper.info());
        }
    }

    public static String generateName(MinionStringConstant side) {
        switch (side) {
            case LIGHT_SIDE:
                return humanNames[new Random().nextInt(humanNames.length)];
            case DARK_SIDE:
                return orcNames[new Random().nextInt(orcNames.length)];
        }
        return MinionStringConstant.EMPTY_STRING.getLine();
    }

    public static int generateAge() {
        return new Random()
                .nextInt(MinionIntConstant.MAX_AGE.getValue() - MinionIntConstant.MIN_AGE.getValue())
                + MinionIntConstant.MIN_AGE.getValue();
    }

    public static int generatePower() {
        return new Random()
                .nextInt(MinionIntConstant.MAX_POWER.getValue() - MinionIntConstant.MIN_POWER.getValue())
                + MinionIntConstant.MIN_POWER.getValue();
    }

    public static Map<String, String> generateMinionMap(MinionStringConstant side) {
        Map<String, String> minionMap = new HashMap<>();

        minionMap.put(MinionStringConstant.NAME.getLine(), generateName(side));
        minionMap.put(MinionStringConstant.AGE.getLine(), String.valueOf(generateAge()));
        minionMap.put(MinionStringConstant.POWER.getLine(), String.valueOf(generatePower()));
        minionMap.put(MinionStringConstant.HP.getLine(), String.valueOf(MinionIntConstant.MINION_HP.getValue()));
        return minionMap;
    }

    private static HashMap<Field, String> getFullFields(Class<?> providedClass) {
        Class<?> currentClass = providedClass;
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

    private static Object checkFieldOnCorrectType(Field field, String value) {
        Object typedValue;
        final Class<?> type = field.getType();

        if (int.class.isAssignableFrom(type)) {
            typedValue = Integer.parseInt(value);
        } else {
            typedValue = value;
        }
        return typedValue;
    }

    public static void juxtaposeFields(Object objectToComplete, Map<String, String> mapWithFields) {
        HashMap<Field, String> fields = getFullFields(objectToComplete.getClass());

        for (Field field : fields.keySet()) {
            field.setAccessible(true);
            String value = mapWithFields.get(fields.get(field));
            Object typedValue = checkFieldOnCorrectType(field, value);
            try {
                field.set(objectToComplete, typedValue);
            } catch (IllegalAccessException accessException) {
                accessException.printStackTrace();
            }
        }
    }
}
