package menu.commands.tasks.calculator;

import menu.commands.tasks.calculator.Dimitii.WorkspaceDmitrii;
import menu.commands.tasks.calculator.alex.AlexWorkPlace;
import menu.commands.tasks.calculator.ivan.IvanWorkplace;
import menu.commands.tasks.calculator.max.MaxWorkplace;


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

    Workplace createWorkplace(Executor executor) {
        switch (executor) {
            case IVAN:
                return new IvanWorkplace();

            case ALEX:
                return new AlexWorkPlace();

            case MAX:
                return new MaxWorkplace();

            case DMITRII:
                return new WorkspaceDmitrii();

            default:
                return null;
        }
    }
}
