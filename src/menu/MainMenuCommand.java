package menu;

import menu.commands.ExitCommand;
import menu.commands.tasks.TaskMenuCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class MainMenuCommand implements Command{
    private static MainMenuCommand instance;

    private MainMenuCommand() {
    }

    public static synchronized MainMenuCommand getInstance() {
        if (instance == null) {
            instance = new MainMenuCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {

        MenuUtils.printSeparator();
        MenuUtils.printOption("0", "Exit");
        MenuUtils.printOption("1", "Show tasks");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return ExitCommand.getInstance();
            case 1:
                return TaskMenuCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }

}
