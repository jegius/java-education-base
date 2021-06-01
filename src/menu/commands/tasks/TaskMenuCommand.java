package menu.commands.tasks;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.tasks.calculator.CalculatorTaskCommand;
import menu.commands.tasks.calculatormode.CalculatorModeCommand;
import menu.commands.tasks.collections.CollectionTaskCommand;
import menu.commands.tasks.editor.alex.AlexEditorCommand;
import menu.commands.tasks.editor.max.MaxEditorCommand;
import menu.commands.tasks.generics.GenericTaskCommand;
import menu.commands.tasks.generics.GenericTaskCommandAndrew;
import menu.commands.tasks.generics.GenericTaskCommandMax;
import menu.commands.tasks.objects.ObjectsTaskCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class TaskMenuCommand implements Command {

    private static TaskMenuCommand instance;

    private TaskMenuCommand() {
    }

    public static synchronized TaskMenuCommand getInstance() {
        if (instance == null) {
            instance = new TaskMenuCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Show object theme task");
        MenuUtils.printOption("2", "Show simple calculator");
        MenuUtils.printOption("3", "Show calculator mode");
        MenuUtils.printOption("4", "Show collection task mode");
        MenuUtils.printOption("5", "Show Alex generics task mode");
        MenuUtils.printOption("6", "Show Alex Editor");
        MenuUtils.printOption("7", "Show Max Generics");
        MenuUtils.printOption("8", "Show Max Editor");
        MenuUtils.printOption("10", "Show Andrew Generic");
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
            case 3:
                return CalculatorModeCommand.getInstance();
            case 4:
                return CollectionTaskCommand.getInstance();
            case 5:
                return GenericTaskCommand.getInstance();
            case 6:
                return AlexEditorCommand.getInstance().execute();
            case 7:
                return GenericTaskCommandMax.getInstance();
            case 8:
                return MaxEditorCommand.getInstance().execute();
            case 10:
                return GenericTaskCommandAndrew.getInstance().execute();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
