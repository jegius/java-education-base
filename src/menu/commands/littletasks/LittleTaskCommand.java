package menu.commands.littletasks;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.littletasks.ninetyninebottles.NinetyNineBottles;
import menu.commands.littletasks.ninetyninebottlesmax.NinetyNineBottlesMax;
import menu.commands.littletasks.nurseryforcats.NurseryForCats;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class LittleTaskCommand implements Command {

    private static LittleTaskCommand instance;

    private LittleTaskCommand() {}

    public static synchronized LittleTaskCommand getInstance() {
        if (instance == null) {
            instance = new LittleTaskCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Run ninety nine bottles.");
        MenuUtils.printOption("2", "Run cat service.");
        MenuUtils.printOption("6", "Run Max Bottles");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return MainMenuCommand.getInstance();
            case 1:
                NinetyNineBottles.run();
                return this;
            case 2:
                NurseryForCats.run();
                return this;
            case 6:
                NinetyNineBottlesMax.run();
                return this;
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
