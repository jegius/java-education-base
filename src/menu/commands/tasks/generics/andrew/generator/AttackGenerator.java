package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.Battlefield;
import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.utils.MenuUtils;

import java.util.Random;

public class AttackGenerator {

    public boolean lightSideAttacking() {
        return new Random().nextBoolean();
    }

    public void calcFight(ArrayListGeneric<Minion> calcLightSide, ArrayListGeneric<Minion> calcDarkSide) {
        Random random = new Random();
        boolean breakPoint = true;
        int round = MinionIntEnum.ROUND_OF_FIGHT.getValue();
        while (breakPoint) {

            System.out.println("Round: " + round++);

            int trooperIndex = random.nextInt(calcLightSide.size());
            int gruntIndex = random.nextInt(calcDarkSide.size());
            Minion trooper = calcLightSide.get(trooperIndex);
            Minion grunt = calcDarkSide.get(gruntIndex);

            if (lightSideAttacking()) {
                calcHP(trooper, grunt);
                calcLeavesMinions(calcLightSide, calcDarkSide, trooper, grunt, trooperIndex, gruntIndex);
            } else {
                calcHP(grunt, trooper);
                calcLeavesMinions(calcDarkSide, calcLightSide, grunt, trooper, gruntIndex, trooperIndex);
            }
            if (calcLightSide.size() == 0 || calcDarkSide.size() == 0) {
                breakPoint = false;
            }
        }
        Battlefield.getInstance().showBattlefield();
    }

    private void calcHP(Minion firstMinion, Minion secondMinion) {
        printBattle(firstMinion, secondMinion);
        secondMinion.setHp(secondMinion.getHp() - firstMinion.getPower());

        if (secondMinion.getHp() > 0) {
            printBattle(secondMinion,firstMinion);
            firstMinion.setHp(firstMinion.getHp() - secondMinion.getPower());
        }
    }

    private void printBattle(Minion firstMinion, Minion secondMinion){
        StringBuilder minionAttackPrint = new StringBuilder();
        minionAttackPrint
                .append(firstMinion.getName())
                .append("(")
                .append(firstMinion.getHp())
                .append(")")
                .append(" attacking ")
                .append(secondMinion.getName())
                .append("(")
                .append(secondMinion.getHp())
                .append(")")
                .append(" on ")
                .append(firstMinion.getPower())
                .append(" damage.");

        System.out.println(minionAttackPrint.toString());
    }

    private void calcLeavesMinions(ArrayListGeneric<Minion> firstSide,
                                   ArrayListGeneric<Minion> secondSide,
                                   Minion firstMinion,
                                   Minion secondMinion,
                                   int firstMinionIndex,
                                   int secondMinionIndex) {
        if (firstMinion.getHp() <= 0) {

            System.out.println(firstMinion.getName() + " is dead!");

            MenuUtils.printSeparator();
            firstSide.remove(firstMinionIndex);
        }
        if (secondMinion.getHp() <= 0) {

            System.out.println(secondMinion.getName() + " is dead!");

            MenuUtils.printSeparator();
            secondSide.remove(secondMinionIndex);
        }
        if (firstMinion.getHp() > 0 && secondMinion.getHp() > 0) {
            firstSide.set(firstMinion, firstMinionIndex);
            secondSide.set(secondMinion, secondMinionIndex);
            MenuUtils.printSeparator();
        }
    }

}
