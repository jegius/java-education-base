package menu.commands.littletasks.regexp.regexp.validator;

import menu.Command;
import menu.commands.littletasks.regexp.RegExpTaskCommand;
import menu.commands.littletasks.regexp.regexp.Executor;
import menu.commands.littletasks.regexp.regexp.validator.ivan.IvanRegExpValidator;
import menu.utils.MenuUtils;

import java.util.HashMap;
import java.util.Scanner;

public class ValidatorRunner implements Command {
    private static ValidatorRunner instance;

    public static  ValidatorRunner getInstance() {
        if (instance == null) {
            instance = new ValidatorRunner();
        }
        return instance;
    }

    private Validator currentValidator;
    private Scanner scanner;
    private HashMap<Executor, Validator> executors;

    private ValidatorRunner() {
        this.scanner = new Scanner(System.in);
        this.executors = new HashMap<>();
        this.executors.put(Executor.IVAN, new IvanRegExpValidator());
    }

    @Override
    public Command execute() {
        if(currentValidator == null) {
            currentValidator = selectValidatorByExecutor();
        }

        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Change executor.");
        MenuUtils.printOption("2", "Email address validation.");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                currentValidator = selectValidatorByExecutor();
                return this;
            }
            case 2: {
                validateEmail();
                return this;
            }
            case 0: {
                return RegExpTaskCommand.getInstance();
            }
            default: {
                System.out.println("Unexpected command!");
                return this;
            }
        }
    }

    private Validator selectValidatorByExecutor() {
        MenuUtils.printSeparator();
        System.out.println("Choose executor:");
        MenuUtils.printExecutors(Executor.values());
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        int choose = scanner.nextInt();

        return executors.get(Executor.values()[choose]);
    }

    private void validateEmail() {
        MenuUtils.printSeparator();
        System.out.println("Enter email for validation");
        MenuUtils.printPrompt();

        String email = scanner.next();

        if (currentValidator.isEmailValid(email)) {
            System.out.println("Email is valid.");
        } else {
            System.out.println("Email invalid!");
        }
    }
}
