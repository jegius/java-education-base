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

public class AlexEditorFileMenu {
    private static AlexEditorFileMenu instance;
    private static final String fileNameExample = "\\w+\\.txt";
    String fileName;
    private Path file;
    private List<String> lines;
    private int fileNumber =  0;
    public static synchronized AlexEditorFileMenu getInstance() {
        if (instance == null) {
            instance = new AlexEditorFileMenu();
        }
        return instance;
    }
    private List <String> usedFiles;

    private void getNewFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name");
        fileName = scanner.nextLine();
        if (fileName.matches(fileNameExample)) {
            usedFiles = new ArrayList<>();
            usedFiles.add(fileName);
            getFile(fileName);
        } else {
            System.out.println("Only txt files available");
        }
    }

    private void getUsedFile(){
        if (usedFiles != null){
            for(String fileName: usedFiles){
                System.out.println("Choose file");
                System.out.println(fileNumber+1 +" : "+ fileName);
            }
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            getFile(usedFiles.get(choice-1));
        }
    }

    private void getFile(String fileName){
        try {
            file = Paths.get(fileName);
            lines = Files.readAllLines(file, Charset.defaultCharset());
            System.out.println("Success");
        } catch (InvalidPathException | IOException e) {
            System.out.println("Tobi pizda: " + e);
        }
    }


}
