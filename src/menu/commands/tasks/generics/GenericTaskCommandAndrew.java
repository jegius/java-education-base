package menu.commands.tasks.generics;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.Battlefield;
import menu.commands.tasks.generics.andrew.Castle;
import menu.commands.tasks.generics.andrew.Horde;
import menu.commands.tasks.generics.andrew.creatures.Human;
import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.creatures.Orc;
import menu.commands.tasks.generics.andrew.generator.MinionArrayBuilder;
import menu.commands.tasks.generics.andrew.generator.MinionIntConstant;
import menu.commands.tasks.generics.andrew.generator.MinionStringConstant;
import menu.commands.tasks.generics.andrew.generator.MinionUtils;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class GenericTaskCommandAndrew implements Command {
    private static GenericTaskCommandAndrew instance;

    public static synchronized GenericTaskCommandAndrew getInstance() {
        if (instance == null) {
            instance = new GenericTaskCommandAndrew();
        }
        return instance;
    }


    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Generate Castle troopers");
        MenuUtils.printOption("2", "Generate Horde grunts");
        MenuUtils.printOption("3", "Show Battlefield");
        MenuUtils.printOption("4", "Generate Troopers with Reflection");
        MenuUtils.printOption("5", "Generate Grunts with Reflection");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Castle.getInstance().showBattleSide();
                return this;
            case 2:
                Horde.getInstance().showBattleSide();
                return this;
            case 3:
                Battlefield.getInstance().showBattlefield();
                return this;
            case 4:
                ArrayListGeneric<Minion> troopers = MinionArrayBuilder.generateObject(Human.class,
                        MinionStringConstant.LIGHT_SIDE,
                        MinionIntConstant.MINION_AMOUNT.getValue());
                MinionUtils.minionsInfo(troopers);
                Castle.getInstance().setMinions(troopers);
                return this;
            case 5:
                ArrayListGeneric<Minion> grunts = MinionArrayBuilder.generateObject(Orc.class,
                        MinionStringConstant.DARK_SIDE,
                        MinionIntConstant.MINION_AMOUNT.getValue());
                MinionUtils.minionsInfo(grunts);
                Horde.getInstance().setMinions(grunts);
                return this;
            case 0:
                return TaskMenuCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
