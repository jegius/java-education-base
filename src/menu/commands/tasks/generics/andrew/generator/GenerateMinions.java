package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.creatures.Human;
import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.creatures.Orc;

import java.util.Random;

public class GenerateMinions {

    private final String[] humanNames = {"Alex", "Alan", "Bob", "Martin", "Sebastian"};
    private final String[] orcNames = {"Azog", "Lurk", "Ugluk", "Narzug", "Boldog"};

    public ArrayListGeneric<Minion> createMinions(String side, int quantity) {
        Minion minions;
        ArrayListGeneric<Minion> arrayListGeneric = new ArrayListGeneric<>();
        if (side.equals(MinionStringEnum.LIGHT_SIDE.getLine())) {
            for (int i = 0; i < quantity; i++) {
                minions = new Human(side,
                        generateName(side),
                        generateAge(),
                        generatePower(),
                        MinionIntEnum.MINION_HP.getValue());
                arrayListGeneric.add(minions);
            }
        }
        if (side.equals(MinionStringEnum.DARK_SIDE.getLine())) {
            for (int i = 0; i < quantity; i++) {
                minions = new Orc(side,
                        generateName(side),
                        generateAge(),
                        generatePower(),
                        MinionIntEnum.MINION_HP.getValue());
                arrayListGeneric.add(minions);
            }
        }
        return arrayListGeneric;
    }

    private String generateName(String side) {
        if (side.equals(MinionStringEnum.LIGHT_SIDE.getLine())) {
            return humanNames[new Random().nextInt(humanNames.length)];
        } else if (side.equals(MinionStringEnum.DARK_SIDE.getLine())) {
            return orcNames[new Random().nextInt(orcNames.length)];
        }
        return "";
    }

    private int generateAge() {
        return new Random().nextInt(MinionIntEnum.MAX_AGE.getValue() + 1 -
                MinionIntEnum.MIN_AGE.getValue()) + MinionIntEnum.MIN_AGE.getValue();
    }

    private int generatePower() {
        return new Random().nextInt(MinionIntEnum.MAX_POWER.getValue() + 1 -
                MinionIntEnum.MIN_POWER.getValue()) + MinionIntEnum.MIN_POWER.getValue();
    }
}
