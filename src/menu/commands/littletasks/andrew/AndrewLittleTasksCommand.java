package menu.commands.littletasks.andrew;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.littletasks.andrew.ninetyninebottles.NinetyNineBottles;
import menu.commands.littletasks.andrew.nurseryforcats.NurseryForCats;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class AndrewLittleTasksCommand implements Command {
    private static AndrewLittleTasksCommand instance;

    private AndrewLittleTasksCommand() {
    }

    public static synchronized AndrewLittleTasksCommand getInstance() {
        if (instance == null) {
            instance = new AndrewLittleTasksCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Run ninety nine bottles.");
        MenuUtils.printOption("2", "Run nursery for cats.");
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
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
