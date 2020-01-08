package menu.commands.tasks.editor.alex;

import menu.Command;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class AlexEditorPreviousFileMenu {

    private static AlexEditorPreviousFileMenu instance;

    public static synchronized AlexEditorPreviousFileMenu getInstance() {
        if (instance == null) {
            instance = new AlexEditorPreviousFileMenu();
        }
        return instance;
    }

    public void showMenu() {
        if (Options.getOptions().size() != 0) {
            System.out.println("Choose file");
            int optionNumber = 1;
            MenuUtils.printSeparator();
            for (String option : Options.getOptions()) {
                MenuUtils.printOption(optionNumber++, option);
            }
            chooseFileFromMenu();
        } else {
            System.out.println("You have no files to choose");
        }
    }

    public Command chooseFileFromMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice > Options.getOptions().size()) {
            System.out.println("No such file");
        } else {
            AlexEditor.getInstance().chooseFile(Options.getOptions().get(choice - 1));
        }
        return AlexEditorNewFileCommand.getInstance().execute();
    }
}

