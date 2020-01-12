package menu.commands.tasks.editor.alex;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        files.add(fileName);
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
        int fileNumber = 1;
        System.out.println("Choose file");
        for (String file : files) {
            System.out.println((fileNumber++) + " : " + file);
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Path filePath = Paths.get(files.get(choice - 1));
        return filePath;
    }

}
