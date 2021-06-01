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

    public static String generateName(String side) {
        if (side.equals(MinionStringEnum.LIGHT_SIDE.getLine())) {
            return humanNames[new Random().nextInt(humanNames.length)];
        } else if (side.equals(MinionStringEnum.DARK_SIDE.getLine())) {
            return orcNames[new Random().nextInt(orcNames.length)];
        }
        return MinionStringEnum.EMPTY_STRING.getLine();
    }

    public static int generateAge() {
        int maxAge = MinionIntEnum.MAX_AGE.getValue();
        int minAge = MinionIntEnum.MIN_AGE.getValue();
        return new Random().nextInt(maxAge - minAge) + minAge;
    }

    public static int generatePower() {
        int maxPower = MinionIntEnum.MAX_POWER.getValue();
        int minPower = MinionIntEnum.MIN_POWER.getValue();
        return new Random().nextInt(maxPower - minPower) + minPower;
    }

    public static Map<String, String> generateMinionMap(String side) {
        Map<String, String> minionMap = new HashMap<>();

        minionMap.put(MinionStringEnum.NAME.getLine(), generateName(side));
        minionMap.put(MinionStringEnum.AGE.getLine(), String.valueOf(generateAge()));
        minionMap.put(MinionStringEnum.POWER.getLine(), String.valueOf(generatePower()));
        minionMap.put(MinionStringEnum.HP.getLine(), String.valueOf(MinionIntEnum.MINION_HP.getValue()));
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
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
