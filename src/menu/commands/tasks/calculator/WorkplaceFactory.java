package menu.commands.tasks.calculator;

import menu.commands.tasks.calculator.ivan.IvanWorkplace;

public class WorkplaceFactory {
    private static WorkplaceFactory instance;

    private WorkplaceFactory() {
    }

    public static synchronized WorkplaceFactory getInstance() {
        if (instance == null) {
            instance = new WorkplaceFactory();
        }
        return instance;
    }

    public Workplace createWorkplace(Executor executor) {
        switch (executor) {
            case IVAN:
                return new IvanWorkplace();
            default:
                return null;
        }
    }
}
