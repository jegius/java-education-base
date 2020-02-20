package menu.commands.tasks.generics.max;

import menu.commands.tasks.generics.max.objects.Angel;
import menu.commands.tasks.generics.max.objects.Demon;

public class Castle {

    private static Castle instance;

    private GeneratorMonster generatorMonsterCastle = new GeneratorMonster();

    private MaxArrayListGeneric castle;

    public static synchronized Castle getInstance() {
        if (instance == null) {
            instance = new Castle();
        }
        return instance;
    }

    private Castle() {
        this.castle = generatorMonsterCastle
                .getArrayBuilder()
                .generateMonsters(3, Demon.class)
                .generateMonsters(5, Angel.class)
                .build();
    }

    public void showCastle() {
        castle.printElements();
    }
}
