package menu.commands.tasks.generics.max;

import menu.commands.tasks.generics.max.objects.Vampire;
import menu.commands.tasks.generics.max.objects.Zombie;

public class Cemetery {

    private static Cemetery instance;

    private GeneratorMonster generatorMonsterCemetery = new GeneratorMonster();

    private MaxArrayListGeneric cemetery;

    public static synchronized Cemetery getInstance() {
        if (instance == null) {
            instance = new Cemetery();
        }
        return instance;
    }

    public Cemetery() {
        this.cemetery = generatorMonsterCemetery
                .getArrayBuilder()
                .generateMonsters(4, Zombie.class)
                .generateMonsters(3, Vampire.class)
                .build();
    }

    public void showCemetery() {
        cemetery.printElements();
    }
}
