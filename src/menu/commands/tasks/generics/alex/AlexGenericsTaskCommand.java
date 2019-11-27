package menu.commands.tasks.generics.alex;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.exceptions.OutOfArrayLength;

public class AlexGenericsTaskCommand implements Command {

    private static AlexGenericsTaskCommand instance;

    private AlexGenericsTaskCommand() {
    }

    public static synchronized AlexGenericsTaskCommand getInstance() {
        if (instance == null) {
            instance = new AlexGenericsTaskCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        try {
            AlexShowCase.getInstance().showCase();
        } catch (OutOfArrayLength outOfArrayLength) {
            outOfArrayLength.printStackTrace();
        }
        return TaskMenuCommand.getInstance();
    }
}
