package menu.commands.tasks.generics;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.exceptions.OutOfArrayLength;
import menu.commands.tasks.generics.alex.Cinema;
import menu.commands.tasks.generics.alex.DogShelter;
import menu.commands.tasks.generics.alex.Street;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class GenericTaskCommand implements Command {

    private static GenericTaskCommand instance;

    public GenericTaskCommand() {
    }

    public static synchronized GenericTaskCommand getInstance(){
        if(instance == null){
            instance = new GenericTaskCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Show Cinema");
        MenuUtils.printOption("2", "Show Dogs");
        MenuUtils.printOption("3", "Show Street");
        MenuUtils.printOption("4", "Compare Cinema with DogShelter");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                Cinema.getInstance().showCinema();
                return this;
            case 2:
                DogShelter.getInstance().showDogShelter();
                return this;
            case 3:
                Street.getInstance().showStreet();
                return this;
            case 4:
                try {
                    Cinema.getInstance()
                            .getCinema()
                            .compare(DogShelter
                                    .getInstance()
                                    .getDogShelter());
                } catch (OutOfArrayLength outOfArrayLength) {
                    outOfArrayLength.printStackTrace();
                }
                return this;
            case 0:
                return TaskMenuCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
