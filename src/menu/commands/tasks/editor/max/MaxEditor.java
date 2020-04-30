package menu.commands.tasks.editor.max;

import menu.Command;
import menu.commands.tasks.editor.max.exceptions.NotSuchLineException;
import menu.utils.MenuUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static menu.commands.tasks.editor.max.NumbersForMaxEditor.*;

public class MaxEditor {

    private Path filePath;
    private Scanner scanner;
    private List<String> lines;

    public MaxEditor(Path path) {
      this.filePath = path;
      this.scanner = new Scanner(System.in);
    }

    public Command execute() {
        try {
            lines = Files.readAllLines(filePath, Charset.defaultCharset());
            MenuUtils.printSeparator();
            printMenuOptions();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return MaxEditorCommand
                .getInstance()
                .execute();
    }

    private void addNewLine() {
        System.out.println("Enter text for " + (lines.size() + NUMBER_OF_LINE.getValue()) + " line:");
        lines.add(scanner.nextLine());
        showText();
    }

    private void editLine() {
        try {
            showText();
            MenuUtils.printSeparator();
            System.out.println("Enter the line number for edit:");
            int numberOfLine = MenuUtils.getScannerChoice();
            if (numberOfLine < INITIAL_AMOUNT_OF_LINES.getValue() || numberOfLine > lines.size()) {
                throw new NotSuchLineException();
            } else {
                System.out.println("Enter text for line:");
                lines.set(numberOfLine - LAST_INDEX_OF_SIZE.getValue(), scanner.nextLine());
                showText();
            }
        } catch (NotSuchLineException e) {
            System.out.println(e.getMessage());
        }
    }

    private void clearFile() {
        lines.clear();
        System.out.println("File is cleared");
    }

    private void saveText() {
        try (PrintWriter printWriter = new PrintWriter(filePath.toString())) {
            for (String text : lines) {
                printWriter.println(text);
            }
            System.out.println("Text is saved");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        showText();
    }

    private void showText() {
        for (String line : lines) {
            System.out.println((lines.indexOf(line) + LAST_INDEX_OF_SIZE.getValue()) + " - " + line);
        }
    }

    private void printMenuOptions() {
        System.out.println("File - " + filePath.toString() + ", size of file - " + lines.size());
        MenuUtils.printSeparator();
        MenuUtils.printOption(1, "Add New Line");
        MenuUtils.printOption(2, "Edit Line");
        MenuUtils.printOption(3, "Clear file");
        MenuUtils.printOption(4, "Save text");
        MenuUtils.printOption(5, "Show text");
        MenuUtils.printOption(0, "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        switch (MenuUtils.getScannerChoice()) {
            case 1:
                addNewLine();
                break;
            case 2:
                editLine();
                break;
            case 3:
                clearFile();
                break;
            case 4:
                saveText();
                break;
            case 5:
                showText();
                break;
            case 0:
                MaxEditorCommand
                        .getInstance()
                        .execute();
            default:
                System.out.println("Unexpected command!");
        }
        printMenuOptions();
    }
}