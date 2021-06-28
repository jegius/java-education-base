package menu.commands.tasks.editor.Dmitrii;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.editor.max.MaxEditor;
import menu.commands.tasks.editor.max.MaxEditorManager;
import menu.utils.MenuUtils;

import java.io.IOException;

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
            case 1:
                DmitriiEditor DmitriiEditorNew = DmitriiEditor.getInstance().Newfile();
                return DmitriiEditorNew != null ?
                        DmitriiEditorNew.execute() :
                        this;
           /* case 2:
                MaxEditor maxEditorOpen = MaxEditorManager.getInstance().openFile();
                return maxEditorOpen != null ?
                        maxEditorOpen.execute() :
                        this;
            case 3:
                MaxEditor maxEditorSelect = MaxEditorManager.getInstance().selectPreviousFile();
                return maxEditorSelect != null ?
                        maxEditorSelect.execute() :
                        this;*/
            case 0:
                return TaskMenuCommand.getInstance().execute();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
