package menu.commands.tasks.editor.alex;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AlexEditorPaths {
    private static final String FILE_VALIDATOR = "\\w+\\.txt";
    private List<String> files = new ArrayList();

    private static AlexEditorPaths instance;

    public static synchronized AlexEditorPaths getInstance() {
        if (instance == null) {
            instance = new AlexEditorPaths();
        }
        return instance;
    }

    public void addFile(String fileName) {
        if (!files.contains(fileName)) {
            files.add(fileName);
        }
    }

    public Path newFile() {
        String fileName = "";
        while (!fileName.matches(FILE_VALIDATOR)) {
            System.out.println("Enter file name");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.nextLine();
        }
        Path filePath = Paths.get(fileName);
        return filePath;
    }

    public Path selectFile() {
        if (files.size() == 0) {
            return null;
        } else {
            int fileNumber = 1;
            System.out.println("Choose file");
            for (String file : files) {
                System.out.println((fileNumber++) + " : " + file);
            }
            try {
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                while (choice > files.size() || choice < 1) {
                    System.out.println("no such option, try again");
                    choice = scanner.nextInt();
                }
                Path filePath = Paths.get(files.get(choice - 1));
                return filePath;
            } catch (InputMismatchException e) {
            }
            return null;
        }
    }
}
