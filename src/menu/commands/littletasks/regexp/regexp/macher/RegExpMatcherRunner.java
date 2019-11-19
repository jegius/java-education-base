package menu.commands.littletasks.regexp.regexp.macher;

import menu.Command;
import menu.commands.littletasks.regexp.RegExpTaskCommand;
import menu.commands.littletasks.regexp.regexp.macher.alex.AlexRegExp;
import menu.commands.littletasks.regexp.regexp.macher.ivan.IvanRegExp;
import menu.utils.MenuUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpMatcherRunner implements Command {
    private static RegExpMatcherRunner instance;

    public static RegExpMatcherRunner getInstance() {
        if (instance == null) {
            instance = new RegExpMatcherRunner();
        }
        return instance;
    }

    private Enum[] currentMatcher;
    private Scanner scanner;
    private Action action;

    private RegExpMatcherRunner() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Command execute() {

        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Ivan matcher find.");
        MenuUtils.printOption("2", "Ivan matcher replace.");
        MenuUtils.printOption("3", "Alex matcher find.");
        MenuUtils.printOption("4", "Alex matcher replace.");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                action = Action.FIND;
                currentMatcher = IvanRegExp.values();
                return chooseAndRunRegExp();
            }
            case 2: {
                action = Action.REPLACE;
                currentMatcher = IvanRegExp.values();
                return chooseAndRunRegExp();
            } case 3: {
                action = Action.FIND;
                currentMatcher = AlexRegExp.values();
                return chooseAndRunRegExp();
            }
            case 4: {
                action = Action.REPLACE;
                currentMatcher = AlexRegExp.values();
                return chooseAndRunRegExp();
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

    private Command chooseAndRunRegExp() {
        MenuUtils.printSeparator();
        System.out.println("Choose regexp:");
        MenuUtils.printExecutors(currentMatcher);
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        int choose = scanner.nextInt();

        if (action == Action.FIND) {
            return find(choose);
        } else  {
            return replace(choose);
        }
    }

    private Command find(int choose) {
        Pattern pattern = Pattern.compile(currentMatcher[choose].toString());
        Matcher matcher = pattern.matcher(TextStore.getInstance().getText());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        return this;
    }

    private Command replace(int choose) {
        MenuUtils.printSeparator();
        System.out.println("Enter text for replace:");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        String newValue = scanner.next();

        Pattern pattern = Pattern.compile(currentMatcher[choose].toString());
        String result = pattern.matcher(TextStore.getInstance().getText())
                .replaceAll(newValue);

        System.out.println(result);
        return this;
    }
}
