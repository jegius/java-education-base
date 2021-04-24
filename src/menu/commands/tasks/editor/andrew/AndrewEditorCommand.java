package menu.commands.tasks.editor.andrew;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.utils.MenuUtils;


public class AndrewEditorCommand implements Command {

    private static AndrewEditorCommand instance;

    public static synchronized AndrewEditorCommand getInstance() {
        if (instance == null) {
            instance = new AndrewEditorCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption(1, "Read File");
        MenuUtils.printOption(2, "Add new Line");
        MenuUtils.printOption(3, "Edit File");
        MenuUtils.printOption(4, "Save File");
        MenuUtils.printOption(5, "Select previous file");
        MenuUtils.printOption(6, "Print file");
        MenuUtils.printOption(0, "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        int choice = MenuUtils.getScannerChoice();

        switch (choice) {
            case 1:
                return AndrewEditorManager.getInstance().readFile();
            case 2:
                return AndrewEditorManager.getInstance().addNewLine();
            case 3:
                return AndrewEditorManager.getInstance().editFile();
            case 4:
                return AndrewEditorManager.getInstance().saveTextToFile();
            case 5:
                return AndrewEditorManager.getInstance().selectPreviousFile();
            case 6:
                return AndrewEditorManager.getInstance().printFile();
            case 0:
                return TaskMenuCommand.getInstance().execute();
            default:
                System.out.println("Unexpected command!");
                return AndrewEditorCommand.getInstance().execute();
        }
    }
}
