package menu.commands.tasks.objects.exercises;

import menu.commands.tasks.objects.exercises.dns.Dns;
import menu.commands.tasks.objects.exercises.factory.Factory;
import menu.commands.tasks.objects.exercises.pub.Pub;
import menu.commands.tasks.objects.exercises.school.School;

public class ExerciseObjectFactory {
    private static ExerciseObjectFactory instance;

    private ExerciseObjectFactory() {
    }

    public static synchronized ExerciseObjectFactory getInstance() {
        if (instance == null) {
            instance = new ExerciseObjectFactory();
        }
        return instance;
    }

    public Organization createOrganization(Exercise exercise) {
        switch (exercise) {
            case DNS:
                return new Dns();
            case FACTORY:
                return new Factory();
            case SCHOOL:
                return new School();
            case PUB:
                return new Pub();
                default:
                    System.out.println("Unexpected Exercise!");
                    return null;
        }
    }
}
