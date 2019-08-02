package objects.pub;

import objects.Organization;
import objects.pub.people.Barmen;
import objects.pub.people.Visitor;
import objects.pub.people.Waiter;

public class Pub extends Organization {


    public void start() {
        Visitor visitorOne = new Visitor("Винсент", "Алкоголик", 32);
        Visitor visitorTwo = new Visitor("Билли", "Машинист", 52);
        Visitor visitorThree = new Visitor("Ральф", "Президент", 49);

        Visitor[] firstGroup = {
                visitorOne,
                visitorTwo
        };

        Visitor[] secondGroup = {
                visitorThree
        };

        Waiter firstWaiter = new Waiter("Джордж", 22, 2,firstGroup, 20000);
        Waiter secondWaiter = new Waiter("Майкл", 23, 3,secondGroup, 30000);

        Waiter[] waiters = {
                firstWaiter,
                secondWaiter
        };

        Barmen barmen = new Barmen("Питер", 35, 8, waiters, 60000);

        barmen.doWork();
    }
}