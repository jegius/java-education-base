package menu.commands.tasks.editor.alex.exceptions;

public class FileNotFoundException extends Exception {
    public FileNotFoundException() {
        super("File not found");
    }
}
