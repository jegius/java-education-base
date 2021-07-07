package menu.commands.littletasks.simpleenum;

import menu.commands.littletasks.simpleenum.Alex.AlexTask;
import menu.commands.littletasks.simpleenum.andrew.AndrewTask;
import menu.commands.littletasks.simpleenum.ivan.IvanTask;
import menu.commands.littletasks.simpleenum.max.MaxTask;

import java.util.HashMap;

public class TaskStore {
    private static TaskStore instance;
    private HashMap<Executor, Task> tasks;

    private TaskStore() {
        tasks = new HashMap<>();
        tasks.put(Executor.IVAN, new IvanTask());
        tasks.put(Executor.ANDREW, new AndrewTask());
        tasks.put(Executor.ALEX, new AlexTask());
        tasks.put(Executor.MAX, new MaxTask());
    }

    public static TaskStore getInstance() {
        if (instance == null) {
            instance = new TaskStore();
        }
        return instance;
    }

    public Task getTaskByExecutor(Executor executor) {
        return tasks.get(executor);
    }
}
