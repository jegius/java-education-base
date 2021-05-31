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
        if (path.equals(AndrewEditorFields.EMPTY_PATH.getField())) {
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
        String path = AndrewEditorFields.EMPTY_PATH.getField();

        File selectFile = selectFileExplorer();
        if (selectFile == null){
            return path;
        }
        path = selectFile.getAbsolutePath();
        return path;
    }

    private File selectFileExplorer(){
        File selectedFile;
        final JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                AndrewEditorFields.FILE_NAME_DESCRIPTION.getField(),
                AndrewEditorFields.FILE_NAME_EXTENSIONS.getField());
        fileChooser.addChoosableFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(frame);
        frame.dispose();
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            return selectedFile;
        }
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            MenuUtils.printSeparator();

            System.out.println("Please select file!");
        }
        return null;
    }

    private void checkFilePath() {
        String pathToFile = AndrewEditorModel.getPath();
        if (pathToFile.equals(AndrewEditorFields.EMPTY_PATH.getField())) {
            MenuUtils.printSeparator();

            System.out.println("Please read file first!");

            AndrewEditorCommand.getInstance().execute();
        }
    }

    private void checkEmptyFile() {
        List<String> fileLines = AndrewEditorModel.getInstance().getLines();
        if (fileLines.size() == 0) {
            MenuUtils.printSeparator();

            System.out.println("File is empty");

            AndrewEditorCommand.getInstance().execute();
        }
    }
}
