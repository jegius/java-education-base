package menu.commands.tasks.editor.alex;

import menu.commands.tasks.editor.alex.exceptions.EmptyFileArrayException;
import menu.commands.tasks.editor.alex.exceptions.FileNotFoundException;
import menu.commands.tasks.editor.alex.exceptions.NoSuchOptionException;
import menu.commands.tasks.editor.alex.exceptions.SerializerException;
import menu.utils.MenuUtils;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static menu.commands.tasks.editor.alex.SerializationKind.JAVA;

public class AlexEditorPaths implements Serializable {
    private static final String DEFAULT_PATH = "./out/";
    private static final String INITIAL_ROOT = "/Users";
    private static final String FILE_VALIDATOR = ".+\\.txt$";
    private List<String> files = loadFiles();

    private static AlexEditorPaths instance;

    private List<String> loadFiles() {
        try {
            List<String> files = SerializationFactory
                    .getInstance()
                    .getSerializer(JAVA)
                    .load();
            if (files == null) {
                return new ArrayList<>();
            } else {
                return files;
            }
        } catch (SerializerException e) {
            e.getMessage();
            return new ArrayList<>();
        }
    }

    private void saveFiles(List<String> providedFiles) {
        try {
            SerializationFactory
                    .getInstance()
                    .getSerializer(JAVA)
                    .save(providedFiles);
        } catch (SerializerException e) {
            e.printStackTrace();
        }
    }

    public static synchronized AlexEditorPaths getInstance() {
        if (instance == null) {
            instance = new AlexEditorPaths();
        }
        return instance;
    }

    public void addFile(String fileName) {
        if (files == null) {
            files = loadFiles();
        }
        if (!files.contains(fileName)) {
            files.add(fileName);
            saveFiles(files);
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
        addFile(filePath.toString());
        return filePath;
    }

    public Path selectFile() {
        try {
            if (files.size() == 0) {
                throw new EmptyFileArrayException();
            }
            int fileNumber = 1;
            System.out.println("Choose file");
            for (String file : files) {
                MenuUtils.printOption(fileNumber++, file);
            }
            int choice = MenuUtils.getScannerChoice();
            if (choice > files.size() || choice <= 0) {
                throw new NoSuchOptionException();
            }
            if (files.get(choice - 1) == null) {
                throw new FileNotFoundException();
            }
            Path filePath = Paths.get(files.get(choice - 1));
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
