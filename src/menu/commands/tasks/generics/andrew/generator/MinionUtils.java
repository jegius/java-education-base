package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.creatures.Minion;

import java.util.Random;

public class MinionUtils {

    private static final String[] humanNames = {"Alex", "Alan", "Bob", "Martin", "Sebastian"};
    private static final String[] orcNames = {"Azog", "Lurk", "Ugluk", "Narzug", "Boldog"};

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
        return "";
    }

    public static int generateAge() {
        return new Random().nextInt(MinionIntEnum.MAX_AGE.getValue() + 1 -
                MinionIntEnum.MIN_AGE.getValue()) + MinionIntEnum.MIN_AGE.getValue();
    }

    public static int generatePower() {
        return new Random().nextInt(MinionIntEnum.MAX_POWER.getValue() + 1 -
                MinionIntEnum.MIN_POWER.getValue()) + MinionIntEnum.MIN_POWER.getValue();
    }
}
