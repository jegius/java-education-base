package menu.commands.tasks.editor.alex;

import java.util.ArrayList;

public class Options {
    private static ArrayList<String> options = new ArrayList<>();

    public static void addOption(String fileName) {
        options.add(fileName);
    }

    public static ArrayList<String> getOptions() {
        return options;
    }
}
