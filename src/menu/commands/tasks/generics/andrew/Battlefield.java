package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.generator.AttackGenerator;

public class Battlefield {

    private static Battlefield instance;

    public static synchronized Battlefield getInstance() {
        if (instance == null) {
            instance = new Battlefield();
//            lightSide = new ArrayListGeneric<>();
//            darkSide = new ArrayListGeneric<>();
        }
        return instance;
    }

    public void showBattlefield() {
        ArrayListGeneric<Minion> lightSide = Castle.getInstance().inToBattleField();
        ArrayListGeneric<Minion> darkSide = Horde.getInstance().inToBattleField();

        if (lightSide.size() == 0 && darkSide.size() != 0) {
            System.out.println("Castle is ruins!!!");
            System.out.println("Orcs leaves:");
            MinionUtils.minionsInfo(darkSide);
            System.out.println("Dark side WON!!!");
        }
        if (lightSide.size() != 0 && darkSide.size() == 0) {
            System.out.println("Horde, no more horde!!!");
            System.out.println("Troopers leaves:");
            MinionUtils.minionsInfo(lightSide);
            System.out.println("Light side WON!!!");
        }
        if (lightSide.size() == 0 && darkSide.size() == 0) {
            System.out.println("Battlefield is empty");
        }
        if (lightSide.size() != 0 && darkSide.size() != 0) {
            beginFight(lightSide, darkSide);
        }
    }

    private void beginFight(ArrayListGeneric<Minion> lightSide, ArrayListGeneric<Minion> darkSide) {
        AttackGenerator attackGenerator = new AttackGenerator();
        attackGenerator.calcFight(lightSide, darkSide);
    }
}
