package objects;

import objects.factory.Factory;

public class ApplicationRunner {

    private static Organization[] organizations = {
        new Factory()
    };

    public static void run() {
        for (Organization organization : organizations) {
            organization.start();
        }
    }
}
