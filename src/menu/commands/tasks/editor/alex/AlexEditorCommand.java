package menu.commands.tasks.editor.alex;

import menu.Command;
import menu.MainMenuCommand;
import menu.utils.MenuUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AlexEditorCommand implements Command {

    private static AlexEditorCommand instance;

    public static synchronized AlexEditorCommand getInstance() {
        if (instance == null) {
            instance = new AlexEditorCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "New file");
        MenuUtils.printOption("2", "Open previous file");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();
        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    return MainMenuCommand.getInstance();
                case 1:
                    return SelectFileService
                            .getInstance()
                            .getNewFile()
                            .execute();
                case 2:
                    return SelectFileService
                            .getInstance()
                            .getSelectedFile()
                            .execute();
                default:
                    System.out.println("Unexpected command!");
                    return this;
            }
        } catch (InputMismatchException e) {
            System.out.println("Only numbers");
        }
        return this;
    }
}
