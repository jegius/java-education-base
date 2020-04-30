package menu.commands.tasks.editor.max;

import menu.commands.tasks.editor.max.exceptions.NoFilesException;
import menu.commands.tasks.editor.max.exceptions.NoSuchSelectException;
import menu.utils.MenuUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static menu.commands.tasks.editor.max.NumbersForMaxEditor.*;

public class MaxEditorManager {

    private final static String FILE_FULL_NAME = "[a-zA-Zа-яА-Я0-9]+\\.txt$";
    private final static String FILE_PATH = "./out/";
    private static final String FILE_EXTENSION = ".+\\.txt$";
    private MaxEditorPaths maxEditorPaths;

    private static MaxEditorManager instance;

    private MaxEditorManager() {
        this.maxEditorPaths = MaxEditorPaths.getInstance();
    }

    public static synchronized MaxEditorManager getInstance() {
        if (instance == null) {
            instance = new MaxEditorManager();
        }
        return instance;
    }

    public MaxEditor newFile() {
        Path path = enterPath();
        if (path != null) {
            return new MaxEditor(path);
        }
        return null;
    }

    public MaxEditor openFile() {
        String pathToFile = getFileName();
        Path path = checkFullFileName(pathToFile);
        return new MaxEditor(path);
    }

    public MaxEditor selectPreviousFile() {
        int choice;
        try {
            if (maxEditorPaths.getSize() == INITIAL_AMOUNT_OF_PATHS.getValue()) {
                throw new NoFilesException();
            }
            maxEditorPaths.printFile();
            choice = MenuUtils.getScannerChoice();
            if (choice > maxEditorPaths.getSize() || choice < INITIAL_AMOUNT_OF_PATHS.getValue()) {
                throw new NoSuchSelectException();
            }
            if (choice == 0) {
                return (MaxEditor) MaxEditorCommand
                        .getInstance()
                        .execute();
            }
        } catch (NoFilesException e) {
            System.out.println(e.getMessage());
            System.out.println("Create a new file");
            return newFile();
        } catch (NoSuchSelectException e) {
            System.out.println(e.getMessage());
            return (MaxEditor) MaxEditorCommand
                    .getInstance()
                    .execute();
        }
        Path path = Paths.get(maxEditorPaths
                .getPaths()
                .get(choice - LAST_INDEX_OF_SIZE.getValue()));
        checkPath(path, choice - LAST_INDEX_OF_SIZE.getValue());
        return new MaxEditor(path);
    }

    private void checkPath(Path path, int index) {
        if (Files.exists(path)) {
            new MaxEditor(path);
        } else {
            maxEditorPaths.removePath(index);
        }
    }

    private Path enterPath() {
        String fileName = getFileName();
        Path path = checkFullFileName(fileName);
        return Files.exists(path) ?
                menuForFile(path) :
                createFile(path, fileName);
    }

    private Path checkFullFileName(String pathToFile) {
        if (pathToFile.matches(FILE_FULL_NAME)) {
            return Paths.get(FILE_PATH + pathToFile);
        } else {
            return Paths.get(pathToFile);
        }
    }

    private String getFileName() {
        String fileName = enterFileName("Enter file name:");
        while (!fileName.matches(FILE_EXTENSION)) {
            fileName = enterFileName("Enter only txt format");
        }
        return fileName;
    }

    private String enterFileName(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private Path menuForFile(Path path) {
        System.out.println("File with the same name already exists. You can create a file with a different name or open an existing file.");
        MenuUtils.printOption(1, "Create new");
        MenuUtils.printOption(2, "Open file");
        MenuUtils.printOption(0, "Cancel");
        int choice = MenuUtils.getScannerChoice();
        switch (choice) {
            case 1:
                return enterPath();
            case 2:
                return path;
            case 0:
                return null;
            default:
                return menuForFile(path);
        }
    }

    private Path createFile(Path providedPath, String providedFileName) {
        try {
            Files.createFile(providedPath);
            MaxEditorPaths
                    .getInstance()
                    .addPath(providedPath.toString());
            System.out.println("File " + providedFileName + " is created");
            return providedPath;
        } catch (IOException e) {
            System.out.println("Incorrect file path!");;
        }
        return null;
    }
}
