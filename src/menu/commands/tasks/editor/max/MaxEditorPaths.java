package menu.commands.tasks.editor.max;

import menu.utils.MenuUtils;

import java.util.ArrayList;
import java.util.List;

import static menu.commands.tasks.editor.max.NumbersForMaxEditor.*;

public class MaxEditorPaths {
    private List<String> paths;
    private MaxSerializableManager maxSerializableManager;

    private static MaxEditorPaths instance;

    private MaxEditorPaths() {
        try {
            maxSerializableManager = MaxFactory.createSerializationManager(MaxSerializationType.XML);
            paths = maxSerializableManager.load();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            paths = new ArrayList<>();
        }
    }

    public static synchronized MaxEditorPaths getInstance() {
        if (instance == null) {
            instance = new MaxEditorPaths();
        }
        return instance;
    }

    public void addPath(String filePath) {
        paths.add(filePath);
        maxSerializableManager.save(paths);
    }

    public List<String> getPaths() {
        return paths;
    }

    public int getSize() {
        return this.paths.size();
    }

    public void printFile() {
        MenuUtils.printOption(0, "Back");
        int pathNumber = FIRST_PATH_OF_CHOICE.getValue();
        System.out.println("Select file:");
        for (String file : paths) {
            MenuUtils.printOption(pathNumber++, file);
        }
    }

    public void removePath(int index) {
        paths.remove(index);
        maxSerializableManager.save(paths);
    }
}

