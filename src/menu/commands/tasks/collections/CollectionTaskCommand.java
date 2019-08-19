package menu.commands.tasks.collections;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.collections.arraylist.StubArrayList;
import menu.commands.tasks.collections.fillingoututil.FillingOutUtil;
import menu.commands.tasks.collections.linkedlist.StubLinkedList;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class CollectionTaskCommand implements Command {

    private static CollectionTaskCommand instance;

    private CollectionTaskCommand() {
    }

    public static synchronized CollectionTaskCommand getInstance() {
        if (instance == null) {
            instance = new CollectionTaskCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Stub check task");
        MenuUtils.printOption("2", "Max check task");
        MenuUtils.printOption("3", "Alex check task");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return TaskMenuCommand.getInstance();
            case 1:
                return CollectionChecker
                        .getInstance()
                        .checkTask(
                                new List[]{
                                        new StubArrayList(),
                                        new StubLinkedList()
                                },
                                new FillingOutUtil()
                        );
            case 2:
                return CollectionChecker
                        .getInstance()
                        .checkTask(
                                new List[]{
                                        new StubArrayList(),
                                        new StubLinkedList()
                                },
                                new FillingOutUtil()
                        );
            case 3:
                return CollectionChecker
                        .getInstance()
                        .checkTask(
                                new List[]{
                                        new StubArrayList(),
                                        new StubLinkedList()
                                },
                                new FillingOutUtil()
                        );
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
