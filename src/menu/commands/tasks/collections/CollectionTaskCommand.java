package menu.commands.tasks.collections;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.collections.arraylist.AlexArrayList;
import menu.commands.tasks.collections.arraylist.DmitiiArrayList;
import menu.commands.tasks.collections.arraylist.MaxArrayList;
import menu.commands.tasks.collections.arraylist.StubArrayList;
import menu.commands.tasks.collections.fillingoututil.FillingOutUtil;
import menu.commands.tasks.collections.fillingoututil.MaxFillingOutUtil;
import menu.commands.tasks.collections.linkedlist.DmitriiLinkedList;
import menu.commands.tasks.collections.linkedlist.MaxLinkedList;
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
        MenuUtils.printOption("4", "Dmitrii check task");
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
                                        new MaxArrayList(),
                                        new MaxLinkedList()
                                },
                                new MaxFillingOutUtil()
                        );
            case 3:
                return CollectionChecker
                        .getInstance()
                        .checkTask(
                                new List[]{
                                        new AlexArrayList(),
                                        new StubLinkedList()
                                },
                                new FillingOutUtil()
                        );case 4:
                return CollectionChecker
                        .getInstance()
                        .checkTask(
                                new List[]{
                                        new DmitiiArrayList(),
                                        new DmitriiLinkedList()
                                },
                                new FillingOutUtil()
                        );
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}