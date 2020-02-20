package menu.commands.tasks.generics.max;

import menu.commands.tasks.generics.max.objects.*;

public class Forest {

    private static Forest instance;

    private GeneratorMonster generatorMonsterForest = new GeneratorMonster();

    private MaxArrayListGeneric forest;

    public static synchronized Forest getInstance() {
        if (instance == null) {
            instance = new Forest();
        }
        return instance;
    }

    public Forest() {
        this.forest = generatorMonsterForest
                .getArrayBuilder()
                .generateMonsters(1, Vampire.class)
                .generateMonsters(1, Zombie.class)
                .generateMonsters(1, Demon.class)
                .generateMonsters(1, Angel.class)
                .build();
    }

    public void showForest() {
        forest.printElements();
    }
}
