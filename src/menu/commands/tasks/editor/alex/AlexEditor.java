package menu.commands.tasks.editor.alex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class AlexEditor {

    private static final String fileNameExample = "\\w+\\.txt";
    private Path file;
    private List<String> lines;
    private static AlexEditor instance;
    String fileName;
    private Text text;

    public AlexEditor() {
    }

    public static synchronized AlexEditor getInstance() {
        if (instance == null) {
            instance = new AlexEditor();
        }
        return instance;
    }

    public void getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name");
        fileName = scanner.nextLine();
        if (fileName.matches(fileNameExample)) {
            try {
                file = Paths.get(fileName);
                lines = Files.readAllLines(file, Charset.defaultCharset());
                System.out.println("Success");
            } catch (InvalidPathException | IOException e) {
                System.out.println("Tobi pizda: " + e);
            }
        } else {
            System.out.println("Only txt files available");
        }
    }

    public void chooseFile(String fileName) {
        try {
            this.fileName = fileName;
            file = Paths.get(fileName);
            lines = Files.readAllLines(file, Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLinesAmount() {

        if (lines != null) {
            try {
                lines = Files.readAllLines(file, Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }
            int amount = lines.size();
            if (amount == 1) {
                return fileName + ": " + amount + " line in the file";
            } else {
                return fileName + ": " + amount + " lines in the file";
            }
        }
        return "Choose file to edit";
    }

    public void addLine() {
        if (lines != null) {
            if (text == null) {
                text = new Text();
            }
            text.addLine();
        } else {
            System.out.println(" Choose FILE");
        }
    }

    public void showText() {
        if (text != null) {
            text.printText();
        } else {
            System.out.println("Nothing to show");
        }
    }

    public void saveText() {
        if (text != null) {
            try {
                PrintWriter out = new PrintWriter(fileName);
                for (String line : text.getText()) {
                    out.println(line);
                }
                out.close();
                createNewOption();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nothing to save");
        }
        exit();
    }

    public void exit() {
        lines = null;
        text = null;
        fileName = null;
    }

    private void createNewOption() {
        Options.addOption(fileName);
    }
}
