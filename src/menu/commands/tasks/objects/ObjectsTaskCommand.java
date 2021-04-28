package menu.commands.tasks.objects;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.objects.exercises.Exercise;
import menu.commands.tasks.objects.exercises.ExerciseObjectFactory;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class ObjectsTaskCommand implements Command {

    private static ObjectsTaskCommand instance;

    private ObjectsTaskCommand() {
    }

    public static synchronized ObjectsTaskCommand getInstance() {
        if (instance == null) {
            instance = new ObjectsTaskCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Run DNS example");
        MenuUtils.printOption("2", "Run Factory Example");
        MenuUtils.printOption("3", "Run School Example");
        MenuUtils.printOption("4", "Run Pub Example");
        MenuUtils.printOption("5", "Run Stu Example");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return TaskMenuCommand.getInstance();
            case 1:
                ExerciseObjectFactory
                        .getInstance()
                        .createOrganization(Exercise.DNS)
                        .start();
                return this;
            case 2:
                ExerciseObjectFactory
                        .getInstance()
                        .createOrganization(Exercise.FACTORY)
                        .start();
                return this;
            case 3:
                ExerciseObjectFactory
                        .getInstance()
                        .createOrganization(Exercise.SCHOOL)
                        .start();
                return this;
            case 4:
                ExerciseObjectFactory
                        .getInstance()
                        .createOrganization(Exercise.PUB)
                        .start();
                return this;
            case 5:
                ExerciseObjectFactory
                        .getInstance()
                        .createOrganization(Exercise.STU)
                        .start();
                return this;
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
