package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.generator.AttackGenerator;
import menu.commands.tasks.generics.andrew.generator.MinionIntConstant;
import menu.commands.tasks.generics.andrew.generator.MinionUtils;

public class Battlefield {

    private static Battlefield instance;

    public static synchronized Battlefield getInstance() {
        if (instance == null) {
            instance = new Battlefield();
        }
        return instance;
    }

    public void showBattlefield() {
        ArrayListGeneric<Minion> lightSide = Castle.getInstance().inToBattleField();
        ArrayListGeneric<Minion> darkSide = Horde.getInstance().inToBattleField();

        if (lightSide.size() == MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()
                && darkSide.size() != MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()) {

            System.out.println("Castle is ruins!!!");
            System.out.println("Orcs leaves:");

            MinionUtils.minionsInfo(darkSide);

            System.out.println("Dark side WON!!!");
        }
        if (lightSide.size() != MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()
                && darkSide.size() == MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()) {

            System.out.println("Horde, no more horde!!!");
            System.out.println("Troopers leaves:");

            MinionUtils.minionsInfo(lightSide);

            System.out.println("Light side WON!!!");
        }
        if (lightSide.size() == MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()
                && darkSide.size() == MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()) {

            System.out.println("Battlefield is empty");
        }
        if (lightSide.size() != MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()
                && darkSide.size() != MinionIntConstant.DEFEAT_ARMY_LENGTH.getValue()) {
            beginFight(lightSide, darkSide);
        }
    }

    private void beginFight(ArrayListGeneric<Minion> lightSide, ArrayListGeneric<Minion> darkSide) {
        AttackGenerator attackGenerator = new AttackGenerator();
        attackGenerator.calcFight(lightSide, darkSide);
    }
}
