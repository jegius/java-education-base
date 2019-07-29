package objects;

import objects.factory.Factory;
import objects.school.School;

public class ApplicationRunner {

    private static Organization[] organizations = {
            new Factory(),
            new School()

    };

    public static void run() {
        for (Organization organization : organizations) {
            organization.start();
        }
    }
}
