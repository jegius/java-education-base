package menu.commands.tasks.generics;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.generics.max.Castle;
import menu.commands.tasks.generics.max.Cemetery;
import menu.commands.tasks.generics.max.Forest;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class GenericTaskCommandMax implements Command {

    private static GenericTaskCommandMax instance;

    private GenericTaskCommandMax(){
    }

    public static synchronized GenericTaskCommandMax getInstance() {
        if (instance == null) {
            instance = new GenericTaskCommandMax();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Show Castle");
        MenuUtils.printOption("2", "Show Cemetery");
        MenuUtils.printOption("3", "Show Forest");
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
                Cemetery.getInstance().showCemetery();
                return this;
            case 3:
                Forest.getInstance().showForest();
                return this;
            case 0:
                return TaskMenuCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
