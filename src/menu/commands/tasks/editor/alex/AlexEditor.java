package menu.commands.tasks.editor.alex;

import menu.Command;
import menu.commands.tasks.editor.alex.exceptions.OutOfLinesAmountException;
import menu.utils.MenuUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class AlexEditor {

    private Path filePath;
    private List<String> lines;
    private Scanner scanner;

    public AlexEditor(Path filePath) {
        this.filePath = filePath;
        this.scanner = new Scanner(System.in);
    }

    public Command execute() {
        try {
            lines = Files.readAllLines(filePath, Charset.defaultCharset());
            MenuUtils.printSeparator();
            selectChoice();
        } catch (IOException e) {
            System.out.println("File doesn't exist");
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
        MenuUtils.printOption("5", "Edit line");
        MenuUtils.printOption("6", "Cancel Editing");
        switch (MenuUtils.getScannerChoice()) {
            case 1:
                addLine();
                selectChoice();
                break;
            case 2:
                showText();
                selectChoice();
                break;
            case 3:
                clearFile();
                selectChoice();
                break;
            case 4:
                saveText();
                break;
            case 5:
                editLine();
                selectChoice();
                break;
            case 6:
                AlexEditorCommand.getInstance().execute();
                break;
            default:
                System.out.println("Unexpected command!");
        }
    }

    private void addLine() {
        System.out.println("Enter text for line " + (lines.size() + 1));
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
                MenuUtils.printOption(lineNumber++, line);
            }
        } else {
            System.out.println("File is empty");
        }
    }

    private void editLine() {
        try {
            System.out.println("enter line number");
            int lineNumber = MenuUtils.getScannerChoice();
            if (lineNumber < 0 || lineNumber > lines.size()) {
                throw new OutOfLinesAmountException();
            }
            System.out.println("enter text");
            lines.set(lineNumber - 1, scanner.nextLine());
        } catch (OutOfLinesAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveText() {
        try (PrintWriter out = new PrintWriter(filePath.toString())) {
            for (String line : lines) {
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Mistake while saving, File not found");
        }
    }
}
