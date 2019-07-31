package objects;

import objects.calculator.Workplace;
import objects.dns.Dns;
import objects.factory.Factory;
import objects.school.School;

public class ApplicationRunner {

    private static Organization[] organizations = {
            new Factory(),
            new School(),
            new Dns()

    };

    public static void run(Mode mode) {
        switch (mode) {
            case OBJECT:
                startObjectHomeWork();
                break;
            case CALCULATOR:
                startCalculatorHomeWork();
        }
    }

    private static void startObjectHomeWork() {
        for (Organization organization : organizations) {
            organization.start();
        }
    }

    private static void startCalculatorHomeWork() {
        Workplace.start();
    }
}
