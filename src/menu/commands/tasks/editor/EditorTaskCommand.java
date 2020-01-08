package menu.commands.tasks.editor;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.editor.alex.AlexEditorNewFileCommand;
import menu.commands.tasks.editor.alex.AlexEditorPreviousFileMenu;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class EditorTaskCommand implements Command {
    private static EditorTaskCommand instance;

    public EditorTaskCommand() {
    }

    public static synchronized EditorTaskCommand getInstance() {
        if (instance == null) {
            instance = new EditorTaskCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("2", "Previous files");
        MenuUtils.printOption("1", "New file");
        MenuUtils.printOption("0", "Back");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                AlexEditorNewFileCommand
                        .getInstance()
                        .execute();
                return this;
            case 2:
                AlexEditorPreviousFileMenu
                        .getInstance()
                        .showMenu();
            case 0:
                return TaskMenuCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
