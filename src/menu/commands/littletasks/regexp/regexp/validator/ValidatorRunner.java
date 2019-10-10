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

    public static ValidatorRunner getInstance() {
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
        if (currentValidator == null) {
            currentValidator = selectValidatorByExecutor();
        }

        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Change executor.");
        MenuUtils.printOption("2", "Email address validation.");
        MenuUtils.printOption("3", "Phone validation.");
        MenuUtils.printOption("4", "Car number validation.");
        MenuUtils.printOption("5", "IP address validation.");
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
                validateByType(currentValidator.getValidatorTypes(Validator.EMAIL_INDEX));
                return this;
            }
            case 3: {
                validateByType(currentValidator.getValidatorTypes(Validator.PHONE_INDEX));
                return this;
            }
            case 4: {
                validateByType(currentValidator.getValidatorTypes(Validator.CAR_NUMBER_INDEX));
                return this;
            }
            case 5: {
                validateByType(currentValidator.getValidatorTypes(Validator.IP_ADDRESS_INDEX));
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

    private void validateByType(Enum validator) {
        MenuUtils.printSeparator();

        String message = "Enter " +
                validator.name().toLowerCase() +
                " for validation";

        System.out.println(message);
        MenuUtils.printPrompt();

        String userInput = scanner.next();

        if (isUserInputValid(validator, userInput)) {
            System.out.println(validator.name().toLowerCase() + " is valid.");
        } else {
            System.out.println(validator.name().toLowerCase() + " is invalid!");
        }
    }

    private boolean isUserInputValid(Enum validator, String userInput) {
        switch (validator.ordinal()) {
            case Validator.EMAIL_INDEX: {
                return currentValidator.isEmailValid(userInput);
            }
            case Validator.PHONE_INDEX: {
                return currentValidator.isPhoneValid(userInput);
            }
            case Validator.IP_ADDRESS_INDEX: {
                return currentValidator.isIpAddressValid(userInput);
            }
            case Validator.CAR_NUMBER_INDEX: {
                return currentValidator.isCarNumberValid(userInput);
            }
            default: {
                return false;
            }
        }
    }
}
