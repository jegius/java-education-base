package menu.commands.tasks.generics;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.generics.andrew.Battlefield;
import menu.commands.tasks.generics.andrew.Castle;
import menu.commands.tasks.generics.andrew.Horde;
import menu.commands.tasks.generics.andrew.creatures.Human;
import menu.commands.tasks.generics.andrew.generator.MinionArrayBuilder;
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
        MenuUtils.printOption("4", "Generate Object");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Castle.getInstance().showCastle();
                return this;
            case 2:
                Horde.getInstance().showHorde();
                return this;
            case 3:
                Battlefield.getInstance().showBattlefield();
                return this;
            case 4:
                MinionArrayBuilder.generateObject(Human.class);
                return this;
            case 0:
                return TaskMenuCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
