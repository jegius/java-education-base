package menu.commands.tasks.editor.alex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text {
    private List<String> textLines = new ArrayList<>();
    Scanner scanner;

    public void addLine() {
        System.out.println("Enter text for line " + (textLines.size() + 1));
        scanner = new Scanner(System.in);
        textLines.add(scanner.nextLine());
    }

    public void printText() {
        for (String line : textLines) {
            System.out.println(line);
        }
    }

    public List<String> getText() {
        return textLines;
    }
}
