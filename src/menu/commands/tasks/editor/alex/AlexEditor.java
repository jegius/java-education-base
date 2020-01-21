package menu.commands.tasks.editor.alex;

import menu.Command;
import menu.commands.tasks.editor.alex.exceptions.EmptyFileArrayException;
import menu.utils.MenuUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AlexEditor {

    private Path filePath;
    private List<String> lines;

    public AlexEditor(Path filePath) {
        this.filePath = filePath;
    }

    public Command execute() {
        try {
            if (filePath == null) {
                throw new EmptyFileArrayException();
            }
            lines = Files.readAllLines(filePath, Charset.defaultCharset());
            MenuUtils.printSeparator();
            selectChoice();
        } catch (IOException e) {
            System.out.println("Tobi pizda: tikai s gorodu ");
        } catch (EmptyFileArrayException e) {
            System.out.println(e.getMessage());
        }
        return AlexEditorCommand.getInstance().execute();
    }

    private void selectChoice() {
        System.out.println("Lines in the " + filePath.toString() + ": " + lines.size());
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Add line");
        MenuUtils.printOption("2", "Show text");
        MenuUtils.printOption("3", "Clear File");
        MenuUtils.printOption("4", "Save");
        MenuUtils.printOption("5", "Cancel Editing");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addLine();
                    selectChoice();
                case 2:
                    showText();
                    selectChoice();
                case 3:
                    clearFile();
                    selectChoice();
                case 4:
                    saveText();
                case 5:
                    AlexEditorCommand.getInstance().execute();
                default:
                    System.out.println("Unexpected command!");
            }
        } catch (InputMismatchException e) {
            System.out.println("only numbers");
        }
    }

    private void addLine() {
        System.out.println("Enter text for line " + (lines.size() + 1));
        Scanner scanner = new Scanner(System.in);
        lines.add(scanner.nextLine());
    }

    private void clearFile() {
        lines.clear();
        System.out.println("All lines were removed");
    }

    private void showText() {
        int lineNumber = 1;
        if (lines.size() > 0) {
            for (String line : lines) {
                System.out.print(lineNumber++ + ": ");
                System.out.println(line);
            }
        } else {
            System.out.println("File is empty");
        }
    }

    private void saveText() {
        try {
            PrintWriter out = new PrintWriter(filePath.toString());
            for (String line : lines) {
                out.println(line);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AlexEditorPaths.getInstance().addFile(filePath.toString());
    }
}
