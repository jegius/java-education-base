package menu.commands.tasks.editor.andrew;

import menu.utils.MenuUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AndrewEditorModel {

    private static AndrewEditorModel instance;
    private static String path = "";
    private List<String> lines = null;
    private List<String> previousPaths = new ArrayList<>();

    public static synchronized AndrewEditorModel getInstance() {
        if (instance == null) {
            instance = new AndrewEditorModel();
        }
        return instance;
    }

    public static String getPath() {
        return path;
    }

    public List<String> getLines() {
        return lines;
    }

    public List<String> getPreviousPaths() {
        return previousPaths;
    }

    public void readFile(String path) {
        try {
            lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
            MenuUtils.printSeparator();
            printOptions("Lines:", lines);
            AndrewEditorModel.path = path;
            addPreviousPaths();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        MenuUtils.printSeparator();
        printOptions("Lines:", lines);
    }

    public void addNewLine(String newText) {
        lines.add(newText);
    }

    public List<String> editFile(int lineNumber, String newValue) {
        if (lineNumber >= lines.size()) {
            return null;
        }
        lines.set(lineNumber, newValue);
        return lines;
    }

    public void saveTextToFile() {
        try {
            PrintWriter out = new PrintWriter(path);
            for (String line : lines) {
                out.println(line);
            }
            out.close();
            MenuUtils.printSeparator();

            System.out.println("New strings successful writes");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addPreviousPaths() {
        previousPaths.add(path);
        previousPaths = previousPaths.stream().distinct().collect(Collectors.toList());
    }

    protected void printOptions(String name, List<String> options) {
        System.out.println(name);

        int indexNumber = 1;

        for (String option : options) {
            System.out.println(indexNumber + ": " + option);
            indexNumber++;
        }
    }
}
