package menu.commands.tasks.editor.alex;

import menu.utils.MenuUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AlexEditor {

    private Path filePath;
private List lines;


    public AlexEditor(Path filePath) {
        this.filePath = filePath;
    }

    public void execute(){
        try {
            lines = Files.readAllLines(filePath, Charset.defaultCharset());
            MenuUtils.printSeparator();
            MenuUtils.printOption("1", "Add line");
            MenuUtils.printOption("2", "Show text");
            MenuUtils.printOption("3", "Save");
            MenuUtils.printOption("4", "Cancel Editing");
        } catch (IOException e) {
            System.out.println("Tobi pizda: " + e);
        }

    }
}
