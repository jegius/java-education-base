package menu.commands.littletasks;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.littletasks.alexninetyninebottles.AlexNinetyNineBottles;
import menu.commands.littletasks.alexnurseryforcats.AlexNurseryForCats;
import menu.commands.littletasks.ninetyninebottles.NinetyNineBottles;
import menu.commands.littletasks.nurserycatsmax.NurseryForCatsMax;
import menu.commands.littletasks.nurseryforcats.NurseryForCats;
import menu.commands.littletasks.simpleenum.Executor;
import menu.commands.littletasks.simpleenum.TaskStore;
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
        MenuUtils.printOption("3", "Run Alex bottles");
        MenuUtils.printOption("4", "Run Alex cat service.");
        MenuUtils.printOption("5", "Run Max Cats");
        MenuUtils.printOption("9", "Run Ivan simple enum.");
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
            case 3:
                AlexNinetyNineBottles.run();
                return this;
            case 4:
                AlexNurseryForCats.run();
                return this;
            case 5:
                NurseryForCatsMax.run();
                return this;
            case 9:
                TaskStore
                        .getInstance()
                        .getTaskByExecutor(Executor.IVAN)
                        .runTask();
                return this;
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
