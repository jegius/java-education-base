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
        switch (side) {
            case "Light":
                for (int i = 0; i < quantity; i++) {
                    minions = new Human(MinionEnum.LIGHT_SIDE.getLine(),
                            generateName(side),
                            generateAge(),
                            generatePower(),
                            MinionEnum.MINION_HP.getValue());
                    arrayListGeneric.add(minions);
                }
                break;
            case "Dark":
                for (int i = 0; i < quantity; i++) {
                    minions = new Orc(MinionEnum.DARK_SIDE.getLine(),
                            generateName(side),
                            generateAge(),
                            generatePower(),
                            MinionEnum.MINION_HP.getValue());
                    arrayListGeneric.add(minions);
                }
                break;
            default:
                arrayListGeneric = null;
        }
        return arrayListGeneric;
    }

    private String generateName(String side) {
        if (side.equals(MinionEnum.LIGHT_SIDE.getLine())) {
            return humanNames[new Random().nextInt(humanNames.length)];
        } else if (side.equals(MinionEnum.DARK_SIDE.getLine())) {
            return orcNames[new Random().nextInt(orcNames.length)];
        }
        return "";
    }

    private int generateAge() {
        return new Random().nextInt(MinionEnum.MAX_AGE.getValue() + 1 -
                MinionEnum.MIN_AGE.getValue()) + MinionEnum.MIN_AGE.getValue();
    }

    private int generatePower() {
        return new Random().nextInt(MinionEnum.MAX_POWER.getValue() + 1 -
                MinionEnum.MIN_POWER.getValue()) + MinionEnum.MIN_POWER.getValue();
    }
}
