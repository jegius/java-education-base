package menu.commands.littletasks.simpleenum;

import menu.commands.littletasks.simpleenum.Alex.AlexTask;
import menu.commands.littletasks.simpleenum.ivan.IvanTask;

import java.util.HashMap;

public class TaskStore {
    private static TaskStore instance;
    private HashMap<Executor, Task> tasks;

    public static TaskStore getInstance() {
        if (instance == null) {
            instance = new TaskStore();
        }
        return instance;
    }

    private TaskStore() {
        tasks = new HashMap<>();
        tasks.put(Executor.IVAN, new IvanTask());
        tasks.put(Executor.ALEX, new AlexTask());
    }

    public Task getTaskByExecutor(Executor executor) {
        return tasks.get(executor);
    }
}
