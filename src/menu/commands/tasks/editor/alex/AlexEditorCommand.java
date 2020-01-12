package menu.commands.tasks.editor.alex;

import menu.Command;
import menu.MainMenuCommand;
import menu.utils.MenuUtils;

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

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return MainMenuCommand.getInstance();
            case 1:
                SelectFileService
                        .getInstance()
                        .getNewFile()
                        .execute();
                return this;
            case 2:
                SelectFileService
                        .getInstance()
                        .getSelectedFile()
                        .execute();
                return this;
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
