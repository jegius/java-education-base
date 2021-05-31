package menu.commands.tasks.editor.andrew;

import menu.Command;
import menu.utils.MenuUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AndrewEditorManager {

    private static AndrewEditorManager instance;

    public static synchronized AndrewEditorManager getInstance() {
        if (instance == null) {
            instance = new AndrewEditorManager();
        }
        return instance;
    }

    public Command readFile() {
        String path = filePath();
        if (path.equals("")) {
            return AndrewEditorCommand.getInstance().execute();
        }
        AndrewEditorModel.getInstance().readFile(path);
        return AndrewEditorCommand.getInstance().execute();
    }

    public Command addNewLine() {
        checkFilePath();
        MenuUtils.printSeparator();

        System.out.println("Write new text:");

        Scanner scanner = new Scanner(System.in);
        String newText = scanner.nextLine();
        AndrewEditorModel.getInstance().addNewLine(newText);
        return AndrewEditorCommand.getInstance().execute();
    }

    public Command editFile() {
        checkFilePath();
        checkEmptyFile();
        MenuUtils.printSeparator();

        System.out.println("Select line to edit:");

        int choiceLine = MenuUtils.getScannerChoice();

        System.out.println("Write new text:");

        Scanner scanner = new Scanner(System.in);
        String newText = scanner.nextLine();

        List<String> editedText = AndrewEditorModel.getInstance().editFile(choiceLine - 1, newText);
        if (editedText == null) {
            MenuUtils.printSeparator();

            System.out.println("Selected line out of range:");

            return AndrewEditorManager.getInstance().editFile();
        }
        return AndrewEditorCommand.getInstance().execute();
    }

    public Command saveTextToFile() {
        checkFilePath();
        checkEmptyFile();
        AndrewEditorModel.getInstance().saveTextToFile();
        return AndrewEditorCommand.getInstance().execute();
    }

    public Command selectPreviousFile() {
        checkFilePath();

        int choice;

        List<String> previousPaths = AndrewEditorModel.getInstance().getPreviousPaths();

        MenuUtils.printSeparator();

        AndrewEditorModel.getInstance().printOptions("Previous path:", previousPaths);

        System.out.println("0 - Back");

        choice = MenuUtils.getScannerChoice();
        if (choice == 0) {
            return AndrewEditorCommand.getInstance().execute();
        }
        if (choice > previousPaths.size() || choice <= 0) {

            System.out.println("Unknown choice");

            return AndrewEditorManager.getInstance().selectPreviousFile();
        }
        AndrewEditorModel.getInstance().readFile(previousPaths.get(choice - 1));
        MenuUtils.printSeparator();

        System.out.println("Previous file opened: (" + previousPaths.get(choice - 1) + ")");

        return AndrewEditorCommand.getInstance().execute();
    }

    public Command printFile() {
        checkFilePath();
        checkEmptyFile();
        AndrewEditorModel.getInstance().print();
        return AndrewEditorCommand.getInstance().execute();
    }

    private String filePath() {
        String path = "";
        final JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(frame);
        frame.dispose();
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            path = selectedFile.getAbsolutePath();
        }
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            MenuUtils.printSeparator();

            System.out.println("Please select file!");
        }
        return path;
    }

    private Command checkFilePath() {
        if (AndrewEditorModel.getPath().equals("")) {
            MenuUtils.printSeparator();

            System.out.println("Please read file first!");

            return AndrewEditorCommand.getInstance().execute();
        }
        return null;
    }

    private Command checkEmptyFile() {
        if (AndrewEditorModel.getInstance().getLines().size() == 0) {
            MenuUtils.printSeparator();

            System.out.println("File is empty");

            return AndrewEditorCommand.getInstance().execute();
        }
        return null;
    }
}
