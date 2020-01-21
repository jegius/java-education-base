package menu.commands.tasks.editor.alex.exceptions;

public class EmptyFileArrayException extends Exception {

    public EmptyFileArrayException() {
        super("Nothing to choose");
    }
}
