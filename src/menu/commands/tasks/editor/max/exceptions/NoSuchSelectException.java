package menu.commands.tasks.editor.max.exceptions;

public class NoSuchSelectException extends Exception {
    public NoSuchSelectException() {
        super("Not such file in the list");
    }
}
