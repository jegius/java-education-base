package menu.commands.tasks.calculator;

import menu.commands.tasks.calculator.ivan.IvanWorkplace;
import menu.commands.tasks.objects.exercises.Exercise;
import menu.commands.tasks.objects.exercises.Organization;
import menu.commands.tasks.objects.exercises.dns.Dns;
import menu.commands.tasks.objects.exercises.factory.Factory;
import menu.commands.tasks.objects.exercises.school.School;

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
