package menu.commands.tasks.editor.alex;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.tasks.calculator.CalculatorTaskCommand;
import menu.commands.tasks.objects.ObjectsTaskCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class AlexEditorCommand implements Command {

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "New file");
        MenuUtils.printOption("2", "Open previous file");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return MainMenuCommand.getInstance();
            case 1:
                return ObjectsTaskCommand.getInstance();
            case 2:
                return CalculatorTaskCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
