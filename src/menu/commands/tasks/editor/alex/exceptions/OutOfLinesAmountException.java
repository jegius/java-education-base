package menu.commands.tasks.editor.alex.exceptions;

public class OutOfLinesAmountException extends Exception {
    public OutOfLinesAmountException() {
        super("no such line found");
    }

}
