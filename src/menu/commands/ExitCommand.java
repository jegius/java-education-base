package menu.commands;

import menu.Command;

public class ExitCommand implements Command {
    
    private ExitCommand() {
    }
    
    private static ExitCommand instance;

    public Command execute() {
        return null;
    }
    
    public static synchronized ExitCommand getInstance() {
        if (instance == null) {
                instance = new ExitCommand();
        }
        return instance;
    }
}
