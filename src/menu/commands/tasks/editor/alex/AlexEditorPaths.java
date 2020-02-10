package menu.commands.tasks.editor.alex;

import menu.commands.tasks.editor.alex.exceptions.EmptyFileArrayException;
import menu.commands.tasks.editor.alex.exceptions.FileNotFoundException;
import menu.commands.tasks.editor.alex.exceptions.NoSuchOptionException;
import menu.utils.MenuUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlexEditorPaths {
    private static final String DEFAULT_PATH = "/Users/alexperminov/IdeaProjects/java-education-base/out/";
    private static final String INITIAL_ROOT = "/Users";
    private static final String FILE_VALIDATOR = ".+\\.txt$";
    private List<Path> files = new ArrayList();

    private static AlexEditorPaths instance;

    public static synchronized AlexEditorPaths getInstance() {
        if (instance == null) {
            instance = new AlexEditorPaths();
        }
        return instance;
    }

    public void addFile(Path fileName) {
        if (!files.contains(fileName)) {
            files.add(fileName);
        }
    }

    public Path newFile() {
        String fileName = "";
        System.out.println("Enter file name");
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine();
        while (!fileName.matches(FILE_VALIDATOR)) {
            System.out.println("Only txt files");
            scanner = new Scanner(System.in);
            fileName = scanner.nextLine();
        }
        Path filePath = Paths.get(DEFAULT_PATH + fileName);
        if (fileName.contains(INITIAL_ROOT)) {
            filePath = Paths.get(fileName);
        }
        addFile(filePath);
        return filePath;
    }

    public Path selectFile() {
        try {
            if (files.size() == 0) {
                throw new EmptyFileArrayException();
            }
            int fileNumber = 1;
            System.out.println("Choose file");
            for (Path file : files) {
                MenuUtils.printOption(fileNumber++, file.toString());
            }
            int choice = MenuUtils.getScannerChoice();
            if (choice > files.size() || choice < 0) {
                throw new NoSuchOptionException();
            }
            if (files.get(choice - 1) == null) {
                throw new FileNotFoundException();
            }
            Path filePath = files.get(choice - 1);
            checkPath(filePath, choice - 1);
            return filePath;
        } catch (EmptyFileArrayException e) {
            System.out.println(e.getMessage());
            return newFile();
        } catch (FileNotFoundException | NoSuchOptionException e) {
            System.out.println(e.getMessage());
            return selectFile();
        }
    }

    private void checkPath(Path path, int index) {
        try {
            Files.readAllLines(path);
        } catch (IOException e) {
            files.remove(index);
        }
    }
}
