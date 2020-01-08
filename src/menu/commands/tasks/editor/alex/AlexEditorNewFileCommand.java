package menu.commands.tasks.editor.alex;

import menu.Command;
import menu.commands.tasks.editor.EditorTaskCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class AlexEditorNewFileCommand implements Command {

    private static AlexEditorNewFileCommand instance;

    public static synchronized AlexEditorNewFileCommand getInstance() {
        if (instance == null) {
            instance = new AlexEditorNewFileCommand();
        }
        return instance;
    }

    public AlexEditorNewFileCommand() {
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        System.out.println(AlexEditor
                .getInstance()
                .getLinesAmount());
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Choose file");
        MenuUtils.printOption("2", "Add line");
        MenuUtils.printOption("3", "Show text");
        MenuUtils.printOption("4", "Save");
        MenuUtils.printOption("0", "Exit");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                AlexEditor.getInstance().getFile();
                return instance.execute();
            case 2:
                AlexEditor.getInstance().addLine();
                return instance.execute();
            case 3:
                AlexEditor.getInstance().showText();
                return instance.execute();
            case 4:
                AlexEditor.getInstance().saveText();
                return EditorTaskCommand.getInstance().execute();
            case 0:
                AlexEditor.getInstance().exit();
                return EditorTaskCommand
                        .getInstance()
                        .execute();
            default:
                System.out.println("Unexpected command!");
                return instance;
        }
    }
}
