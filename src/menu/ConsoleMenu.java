package menu;

public class ConsoleMenu {
    private Command command;

    public ConsoleMenu(Command startCommand) {
        this.command = startCommand;
    }

    public void run() {
        while (command != null) {
            command = command.execute();
        }
    }
}
