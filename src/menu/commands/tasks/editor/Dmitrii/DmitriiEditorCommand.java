package menu.commands.tasks.editor.Dmitrii;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.tasks.TaskMenuCommand;
import menu.utils.MenuUtils;

public class DmitriiEditorCommand implements Command {

    private static DmitriiEditorCommand instance;

    public static synchronized DmitriiEditorCommand getInstance() {

        if (instance == null) {
            instance = new DmitriiEditorCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption(1, "Create New file");
        MenuUtils.printOption(2, "Open file");
        MenuUtils.printOption(3, "Select previous file");
        MenuUtils.printOption(0, "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        int choice = MenuUtils.getScannerChoice();

        switch (choice) {
            case 0:
                return MainMenuCommand.getInstance().execute();
            case 1:
                DmitriiEditor.getInstance().getFilePath();
                return this;
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
